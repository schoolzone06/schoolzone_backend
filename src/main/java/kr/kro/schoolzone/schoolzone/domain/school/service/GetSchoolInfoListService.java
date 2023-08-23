package kr.kro.schoolzone.schoolzone.domain.school.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import kr.kro.schoolzone.schoolzone.domain.school.domain.School;
import kr.kro.schoolzone.schoolzone.domain.school.domain.TempSchool;
import kr.kro.schoolzone.schoolzone.domain.school.exception.NotFoundSchoolInfoException;
import kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response.SchoolInfoResponse;
import kr.kro.schoolzone.schoolzone.domain.school.repository.SchoolRepository;
import kr.kro.schoolzone.schoolzone.domain.school.repository.TempSchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetSchoolInfoListService {

    private final SchoolRepository schoolRepository;
    private final TempSchoolRepository tempSchoolRepository;

    @Value("${api-key.neis}")
    private String neisApiKey;

    // @Scheduled(fixedRate = 1000 * 60 * 60 * 24 * 7)
    public void execute() throws JsonProcessingException {
        tempSchoolRepository.deleteAll();

        int i = 1;
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        try {
            while (true) {
                ResponseEntity<String> response = restTemplate.getForEntity(getApiUri(i++), String.class);
                JsonNode result = mapper.readTree(response.getBody()).get("schoolInfo").get(1).get("row");
                List<?> jsonToList = mapper.treeToValue(result, List.class);

                if (schoolRepository.findAll().isEmpty() || i != 1) {
                    for (Object value : jsonToList) {
                        SchoolInfoResponse dto = mapper.convertValue(value, SchoolInfoResponse.class);
                        schoolRepository.save(
                                School.builder()
                                    .schoolName(dto.getSCHUL_NM())
                                    .schoolLocation(getSchoolLocation(dto))
                                    .schoolDomain(getSchoolDomain(dto))
                                    .build()
                        );
                    }
                }

                for (Object value : jsonToList) {
                    SchoolInfoResponse dto = mapper.convertValue(value, SchoolInfoResponse.class);
                    tempSchoolRepository.save(
                            TempSchool.builder()
                                    .schoolName(dto.getSCHUL_NM())
                                    .schoolLocation(getSchoolLocation(dto))
                                    .schoolDomain(getSchoolDomain(dto))
                                    .build()
                    );
                }
            }
        } catch (NullPointerException e) {
            throw new NotFoundSchoolInfoException();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private URI getApiUri(int i) {
        return UriComponentsBuilder
                .fromUriString("https://open.neis.go.kr")
                .path("/hub/schoolInfo")
                .query("KEY={key}")
                .query("Type=json")
                .query("pIndex={i}")
                .query("pSize=1000")
                .query("SCHUL_KND_SC_NM=고등학교")
                .encode()
                .buildAndExpand(neisApiKey, i)
                .toUri();
    }

    private String getSchoolLocation(SchoolInfoResponse dto) {
        String[] schoolLocation = dto.getORG_RDNMA().trim().replace("  ", " ").split(" ");

        if (schoolLocation[0].contains("광역시")) {
            schoolLocation[0] = schoolLocation[0].replace("광역시", "");
        } else if (schoolLocation[0].contains("특별")) {
            if (schoolLocation[0].contains("특별자치시")) {
                schoolLocation[0] = schoolLocation[0].replace("특별자치시", "");
            } else if (schoolLocation[0].contains("특별자치도")) {
                schoolLocation[0] = schoolLocation[0].replace("특별자치", "");
            } else if (schoolLocation[0].contains("특별시")) {
                schoolLocation[0] = schoolLocation[0].replace("특별시", "");
            }
        } else if (schoolLocation[0].length() == 4) {
            String[] location = schoolLocation[0].split("");
            schoolLocation[0] = location[0] + location[2];
        }

        return schoolLocation[0] + " " + schoolLocation[1];
    }

    private String getSchoolDomain(SchoolInfoResponse dto) throws MalformedURLException {
        String schoolDomain = dto.getHMPG_ADRES();

        if (schoolDomain == null) {
            schoolDomain = "";
        }

        schoolDomain = schoolDomain.trim();

        if (schoolDomain.startsWith("http://")) {
            schoolDomain = schoolDomain.substring(7);
        } else if (schoolDomain.startsWith("https://")) {
            schoolDomain = schoolDomain.substring(8);
        }

        if (schoolDomain.startsWith("www.")) {
            schoolDomain = schoolDomain.replace("www.", "");
        }

        if (schoolDomain.endsWith("/")) {
            schoolDomain = schoolDomain.replace("/", "");
        }

        if (!getSchoolLocation(dto).equals("경북")) {
            URL url = new URL("http://" + schoolDomain);
            schoolDomain = url.getHost();
        }

        return schoolDomain;
    }
}

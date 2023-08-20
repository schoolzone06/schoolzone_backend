package kr.kro.schoolzone.schoolzone.domain.school.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import kr.kro.schoolzone.schoolzone.domain.school.exception.NotFoundSchoolInfoException;
import kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response.SchoolInfoResponse;
import kr.kro.schoolzone.schoolzone.domain.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetSchoolInfoListService {

    private final SchoolRepository schoolRepository;

    @Value("${api-key.neis}")
    private String neisApiKey;

    @Scheduled(fixedRate = 1000 * 60 * 60 * 24 * 7)
    public void execute() throws JsonProcessingException {
        schoolRepository.deleteAll();

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

                for (Object value : jsonToList) {
                    SchoolInfoResponse dto = mapper.convertValue(value, SchoolInfoResponse.class);
                    schoolRepository.save(dto.toEntity());
                }
            }
        } catch (NullPointerException e) {
            throw new NotFoundSchoolInfoException();
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
}

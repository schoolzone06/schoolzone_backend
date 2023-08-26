package kr.kro.schoolzone.schoolzone.domain.school.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import kr.kro.schoolzone.schoolzone.domain.school.domain.School;
import kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response.GetMealInfoResponse;
import kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response.MealInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetMealInfoService {

    @Value("${api-key.neis}")
    private String neisApiKey;

    private final GetSchoolObjectService getSchoolObjectService;

    public List<GetMealInfoResponse> getAll(String schoolId) throws JsonProcessingException {
        School school = getSchoolObjectService.findById(schoolId);
        return getInfo(this.getApiUriAll(school.getSchoolOfficeCode(), school.getSchoolId()));
    }

    public List<GetMealInfoResponse> getOne(String schoolId) throws JsonProcessingException {
        School school = getSchoolObjectService.findById(schoolId);
        return getInfo(this.getApiUriOne(school.getSchoolOfficeCode(), school.getSchoolId()));
    }

    private List<GetMealInfoResponse> getInfo(URI url) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JsonNode result = mapper.readTree(response.getBody()).get("mealServiceDietInfo").get(1).get("row");
            List<MealInfoResponse> mealInfoResponses = Arrays.asList(mapper.treeToValue(result, MealInfoResponse[].class));
            return mealInfoResponses.stream()
                    .map(GetMealInfoResponse::new)
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            return null;
        }
    }

    private URI getApiUriAll(String schoolOfficeCode, String schoolCode) {
        String date = LocalDate.now().toString().replace("-", "").substring(0, 6);
        return UriComponentsBuilder
                .fromUriString("https://open.neis.go.kr")
                .path("/hub/mealServiceDietInfo")
                .query("KEY={key}")
                .query("Type=json")
                .query("pIndex=1")
                .query("pSize=100")
                .query("ATPT_OFCDC_SC_CODE={code}")
                .query("SD_SCHUL_CODE={code}")
                .query("MLSV_FROM_YMD={date}01")
                .query("MLSV_TO_YMD={date}31")
                .encode()
                .buildAndExpand(neisApiKey, schoolOfficeCode, schoolCode, date, date)
                .toUri();
    }

    private URI getApiUriOne(String schoolOfficeCode, String schoolCode) {
        String date = LocalDate.now().toString().replace("-", "");
        return UriComponentsBuilder
                .fromUriString("https://open.neis.go.kr")
                .path("/hub/mealServiceDietInfo")
                .query("KEY={key}")
                .query("Type=json")
                .query("pIndex=1")
                .query("pSize=3")
                .query("ATPT_OFCDC_SC_CODE={code}")
                .query("SD_SCHUL_CODE={code}")
                .query("MLSV_YMD={date}")
                .encode()
                .buildAndExpand(neisApiKey, schoolOfficeCode, schoolCode, date)
                .toUri();
    }
}

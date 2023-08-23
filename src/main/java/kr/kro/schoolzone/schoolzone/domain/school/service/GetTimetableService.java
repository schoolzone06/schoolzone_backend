package kr.kro.schoolzone.schoolzone.domain.school.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import kr.kro.schoolzone.schoolzone.domain.school.domain.School;
import kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response.GetTimetableResponse;
import kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response.TimetableResponse;
import kr.kro.schoolzone.schoolzone.domain.user.domain.User;
import kr.kro.schoolzone.schoolzone.domain.user.service.GetOneUserService;
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
public class GetTimetableService {

    @Value("${api-key.neis}")
    private String neisApiKey;

    private final GetOneUserService getOneUserService;

    public List<GetTimetableResponse> execute(Long userId) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

        User user = getOneUserService.execute(userId);
        School school = user.getSchoolId();
        ResponseEntity<String> response = restTemplate.getForEntity(getApiUri(school.getSchoolOfficeCode(), school.getSchoolId(), user.getGrade(), user.getRoom()), String.class);
        JsonNode result = mapper.readTree(response.getBody()).get("hisTimetable").get(1).get("row");
        List<TimetableResponse> timetableResponses = Arrays.asList(mapper.treeToValue(result, TimetableResponse[].class));

        return timetableResponses.stream()
                .map(GetTimetableResponse::new)
                .collect(Collectors.toList());
    }

    private URI getApiUri(String schoolOfficeCode, String schoolCode, String grade, String group) {
        String date = LocalDate.now().toString().replace("-", "");
        return UriComponentsBuilder
                .fromUriString("https://open.neis.go.kr")
                .path("/hub/hisTimetable")
                .query("KEY={key}")
                .query("Type=json")
                .query("pIndex=1")
                .query("pSize=11")
                .query("ATPT_OFCDC_SC_CODE={code}")
                .query("SD_SCHUL_CODE={code}")
                .query("ALL_TI_YMD={date}") // ex) 202308
                .query("GRADE={grade}")
                .query("CLASS_NM={group}")
                .encode()
                .buildAndExpand(neisApiKey, schoolOfficeCode, schoolCode, date, grade, group)
                .toUri();
    }
}

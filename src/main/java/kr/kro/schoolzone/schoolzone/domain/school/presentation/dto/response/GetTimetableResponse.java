package kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response;

import lombok.Getter;

@Getter
public class GetTimetableResponse {

    private final String date;
    private final String period;
    private final String subject;

    public GetTimetableResponse(TimetableResponse response) {
        this.date = response.getALL_TI_YMD();
        this.period = response.getPERIO();
        this.subject = response.getITRT_CNTNT();
    }
}

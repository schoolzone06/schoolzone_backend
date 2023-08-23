package kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response;

import lombok.Getter;

@Getter
public class GetTimetableResponse {

    private final String date;
    private final String period;
    private final String subject;

    public GetTimetableResponse(TimetableResponse response) {
        this.date = response.getLOAD_DTM();
        this.period = response.getPERIO();
        this.subject = response.getITRT_CNTNT();
    }
}

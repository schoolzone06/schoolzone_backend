package kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response;

import lombok.Getter;

@Getter
public class GetMealInfoResponse {

    private final String type;
    private final String contents;
    private final String calorie;

    public GetMealInfoResponse(MealInfoResponse response) {
        this.type = response.getMMEAL_SC_NM();
        this.contents = response.getDDISH_NM();
        this.calorie = response.getCAL_INFO();
    }
}

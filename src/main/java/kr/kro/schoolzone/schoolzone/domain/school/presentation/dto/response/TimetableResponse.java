package kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response;

import lombok.Getter;

@Getter
public class TimetableResponse {

    private String ATPT_OFCDC_SC_CODE; // 시도교육청코드
    private String ATPT_OFCDC_SC_NM;   // 시도교육청명
    private String SD_SCHUL_CODE;      // 표준학교코드
    private String SCHUL_NM;           // 학교명
    private String AY;                 // 학년도
    private String SEM;                // 학기
    private String ALL_TI_YMD;         // 시간표일자
    private String DGHT_CRSE_SC_NM;    // 주야과정명
    private String ORD_SC_NM;          // 계열명
    private String DDDEP_NM;           // 학과명
    private String GRADE;              // 학년
    private String CLRM_NM;            // 강의실명
    private String CLASS_NM;           // 학급명
    private String PERIO;              // 교시
    private String ITRT_CNTNT;         // 수업내용
    private String LOAD_DTM;           // 수정일
}

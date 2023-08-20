package kr.kro.schoolzone.schoolzone.domain.school.exception;

public class NotFoundSchoolInfoException extends NullPointerException {

    public NotFoundSchoolInfoException() {
        super("더 이상 학교 데이터가 존재하지 않습니다.");
    }
}

package kr.kro.schoolzone.schoolzone.domain.school.presentation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response.GetTimetableResponse;
import kr.kro.schoolzone.schoolzone.domain.school.service.GetTimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/school/timetable")
public class TimetableController {

    private final GetTimetableService getTimetableService;

    @GetMapping("/one/{userId}")
    public List<GetTimetableResponse> getTimetableOne(@PathVariable Long userId) throws JsonProcessingException {
        return getTimetableService.getOne(userId);
    }

    @GetMapping("/all/{userId}")
    public List<GetTimetableResponse> getTimetableAll(@PathVariable Long userId) throws JsonProcessingException {
        return getTimetableService.getAll(userId);
    }
}

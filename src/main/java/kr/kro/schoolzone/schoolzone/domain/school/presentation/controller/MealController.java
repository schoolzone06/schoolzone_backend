package kr.kro.schoolzone.schoolzone.domain.school.presentation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.kro.schoolzone.schoolzone.domain.school.presentation.dto.response.GetMealInfoResponse;
import kr.kro.schoolzone.schoolzone.domain.school.service.GetMealInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/school/meal")
public class MealController {

    private final GetMealInfoService getMealInfoService;

    @GetMapping("/one/{schoolId}")
    public List<GetMealInfoResponse> getMealInfoOne(@PathVariable String schoolId) throws JsonProcessingException {
        return getMealInfoService.getOne(schoolId);
    }

    @GetMapping("/all/{schoolId}")
    public List<GetMealInfoResponse> getMealInfoAll(@PathVariable String schoolId) throws JsonProcessingException {
        return getMealInfoService.getAll(schoolId);
    }
}

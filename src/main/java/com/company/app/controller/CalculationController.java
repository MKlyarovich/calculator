package com.company.app.controller;

import com.company.app.service.CalculationService;
import com.company.app.validation.Date;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/calculation")
public class CalculationController {

    private final CalculationService calculationService;

    @GetMapping
    public String getCalculation(@Date @RequestParam String firstDate, @Date @RequestParam String secondDate) {
        return calculationService.getDifferenceBetweenDates(firstDate, secondDate);
    }

    @PostMapping
    public String getCalculation(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return calculationService.getDifferenceBetweenDates(multipartFile);
    }
}
package com.company.app.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CalculationService {

    String getDifferenceBetweenDates(String firstDate, String secondDate);

    String getDifferenceBetweenDates(MultipartFile multipartFile) throws IOException;
}
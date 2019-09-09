package com.company.app.controllers;

import com.company.app.service.CalculationService;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableSpringDataWebSupport
@RunWith(SpringRunner.class)
@WebMvcTest(value = CalculationController.class)
public class CalculationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculationService calculationService;

    @SneakyThrows
    @Test
    public void getCalculationByValuesTest() {
        when(calculationService.getDifferenceBetweenDates(any(), any())).thenReturn("9 1 2010, 9 9 2010, 8");

        mockMvc.perform(get("/calculation")
                .param("firstDate", "09 09 2010")
                .param("secondDate", "09 01 2010"))
                .andExpect(status().isOk())
                .andExpect(content().string("9 1 2010, 9 9 2010, 8"));
    }

    @SneakyThrows
    @Test
    public void getCalculationByFileTest() {
        when(calculationService.getDifferenceBetweenDates(any())).thenReturn("9 1 2010, 9 8 2010, 7");

        MockMultipartFile file = new MockMultipartFile("test.txt", "", "text/plain", "9 1 2010\n9 8 2010".getBytes());

        mockMvc.perform(MockMvcRequestBuilders.multipart("/calculation")
                .file("file", file.getBytes()))
                .andExpect(status().isOk())
                .andExpect(content().string("9 1 2010, 9 8 2010, 7"));
    }
}
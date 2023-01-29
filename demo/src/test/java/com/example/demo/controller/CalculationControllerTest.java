package com.example.demo.controller;

import com.example.demo.service.CalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculationControllerTest {
    @Autowired
    private MockMvc mvc;

    @InjectMocks
    private CalculationController calculationController;
    @Mock
    private CalculationService calculationService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        calculationController = new CalculationController(calculationService);
        this.mvc = MockMvcBuilders.standaloneSetup(calculationController).build();
    }

    @Test
    void postPlus1000() throws Exception {
        String url = "/calculator/v1/plus";
        when(calculationService.getPlus(10, 20))
                .thenReturn(30F);

        mvc.perform(get(url)
                        .param("number1", String.valueOf(10))
                        .param("number2", String.valueOf(20))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }


    @Test
    void postMinus1000() throws Exception {
        String url = "/calculator/v1/minus";
        when(calculationService.getMinus(20, 10))
                .thenReturn(10F);

        mvc.perform(get(url)
                        .param("number1", String.valueOf(20))
                        .param("number2", String.valueOf(10))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    void postMultiply1000() throws Exception {
        String url = "/calculator/v1/multiply";
        when(calculationService.getMultiply(20, 10))
                .thenReturn(200F);

        mvc.perform(get(url)
                        .param("number1", String.valueOf(20))
                        .param("number2", String.valueOf(10))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    void postDivide1000() throws Exception {
        String url = "/calculator/v1/divide";
        when(calculationService.getDivide(10, 10))
                .thenReturn(1F);

        mvc.perform(get(url)
                        .param("number1", String.valueOf(10))
                        .param("number2", String.valueOf(10))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

//    @Test
//    void postDivide500() throws Exception {
//        String url = "/calculator/v1/divide";
//        when(calculationService.getDivide(0, 0))
//                .thenThrow(new IllegalArgumentException());
//
//        mvc.perform(get(url)
//                        .param("number1", String.valueOf(0))
//                        .param("number2", String.valueOf(0))
//                )
//                .andExpect(status().is5xxServerError());
//
//    }
}

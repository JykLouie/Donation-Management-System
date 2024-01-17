package com.DAS.codingQuestionBackend.DonationIntegrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.http.MediaType.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import com.DAS.codingQuestionBackend.request.RecordDonationRequest;
import com.DAS.codingQuestionBackend.enums.DonationType;
import com.DAS.codingQuestionBackend.request.RecordDistributionRequest;


@SpringBootTest
@AutoConfigureMockMvc
public class DonationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testDonationFlow() throws Exception {
        // Record a Donation
        RecordDonationRequest donationRequest = new RecordDonationRequest();
        donationRequest.setName("John Doe");
        donationRequest.setType(DonationType.FOOD);
        donationRequest.setQuantity(100);
        donationRequest.setDate(new Date());

        mockMvc.perform(post("/donation/recordDonation")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(donationRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Donation recorded successfully"));

        // Record a Distribution
        RecordDistributionRequest distributionRequest = new RecordDistributionRequest();
        distributionRequest.setType(DonationType.FOOD);
        distributionRequest.setQuantity(50);
        distributionRequest.setDate(new Date());

        mockMvc.perform(post("/donation/recordDistribution")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(distributionRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Distribution recorded successfully"));

        // Check Current Status
        mockMvc.perform(get("/donation/reportCurrentStatus"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.FOOD").value(50));  // Assuming the initial quantity was 0

        // Check Donators
        mockMvc.perform(get("/donation/reportDonators"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.['John Doe'].FOOD").exists()); 
    }
}
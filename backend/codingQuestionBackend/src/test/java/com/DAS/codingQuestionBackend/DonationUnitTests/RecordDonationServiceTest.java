package com.DAS.codingQuestionBackend.DonationUnitTests;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.DAS.codingQuestionBackend.DAO.DonationDAO;
import com.DAS.codingQuestionBackend.service.RecordDonationService;
import com.DAS.codingQuestionBackend.request.RecordDonationRequest;
import com.DAS.codingQuestionBackend.enums.DonationType;

import java.util.Date;

public class RecordDonationServiceTest {

    @Mock
    private DonationDAO donationDAO;

    @InjectMocks
    private RecordDonationService recordDonationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute_success() {
        RecordDonationRequest request = new RecordDonationRequest();
        request.setName("John Doe");
        request.setType(DonationType.FOOD);
        request.setQuantity((Integer)10);
        request.setDate(new Date());

        boolean result = recordDonationService.execute(request);

        assertTrue(result);
        verify(donationDAO, times(1)).save(eq("John Doe"), eq(DonationType.FOOD), eq(10), any(Date.class));
    }
}
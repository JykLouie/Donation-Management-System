package com.DAS.codingQuestionBackend.DonationUnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.DAS.codingQuestionBackend.DAO.DonationDAO;
import com.DAS.codingQuestionBackend.service.ReportDonatorsService;
import com.DAS.codingQuestionBackend.enums.DonationType;

public class ReportDonatorsServiceTest {

    @Mock
    private DonationDAO donationDAO;

    @InjectMocks
    private ReportDonatorsService reportDonatorsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {
        Map<String, Map<DonationType, Map<Date, Integer>>> mockMap = new HashMap<>();

        Map<DonationType, Map<Date, Integer>> johnDoeDonations = new HashMap<>();
        
        Map<Date, Integer> foodDonations = new HashMap<>();
        foodDonations.put(new Date(), 5);
        foodDonations.put(new Date(), 10);
        
        Map<Date, Integer> moneyDonations = new HashMap<>();
        moneyDonations.put(new Date(), 50);
        
        Map<Date, Integer> clothingDonations = new HashMap<>();
        clothingDonations.put(new Date(), 8);
        
        johnDoeDonations.put(DonationType.FOOD, foodDonations);
        johnDoeDonations.put(DonationType.MONEY, moneyDonations);
        johnDoeDonations.put(DonationType.CLOTHING, clothingDonations);
        
        mockMap.put("John Doe", johnDoeDonations);

        when(donationDAO.getDonationMap()).thenReturn(mockMap);

        Map<String, Map<DonationType, Map<Date, Integer>>> result = reportDonatorsService.execute();

        assertEquals(mockMap, result);
        verify(donationDAO, times(1)).getDonationMap();
    }
}

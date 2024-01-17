package com.DAS.codingQuestionBackend.DonationUnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.DAS.codingQuestionBackend.DAO.CurrentResourcesDAO;
import com.DAS.codingQuestionBackend.enums.DonationType;
import com.DAS.codingQuestionBackend.service.ReportCurrentStatusService;

public class ReportCurrentStatusServiceTest {

    @Mock
    private CurrentResourcesDAO currentResourcesDAO;

    @InjectMocks
    private ReportCurrentStatusService reportCurrentStatusService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {
        Map<DonationType, Integer> mockMap = new HashMap<>();
        mockMap.put(DonationType.MONEY, 1000);
        when(currentResourcesDAO.getCurrentResourcesMap()).thenReturn(mockMap);

        Map<DonationType, Integer> result = reportCurrentStatusService.execute();

        assertEquals(mockMap, result);
        verify(currentResourcesDAO, times(1)).getCurrentResourcesMap();
    }
}

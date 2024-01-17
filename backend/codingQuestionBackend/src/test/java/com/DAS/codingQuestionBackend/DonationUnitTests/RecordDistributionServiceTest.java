package com.DAS.codingQuestionBackend.DonationUnitTests;

import com.DAS.codingQuestionBackend.request.RecordDistributionRequest;
import com.DAS.codingQuestionBackend.service.RecordDistributionService;
import com.DAS.codingQuestionBackend.enums.DonationType;
import com.DAS.codingQuestionBackend.DAO.DistributionDAO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RecordDistributionServiceTest {

    @Mock
    private DistributionDAO distributionDAO;

    @InjectMocks
    private RecordDistributionService recordDistributionService;

    @Test
    public void testExecute_Success() {
        RecordDistributionRequest request = new RecordDistributionRequest();
        request.setType(DonationType.MONEY);
        request.setQuantity(12);
        request.setDate(new Date());

        when(distributionDAO.save(DonationType.MONEY, 12, request.getDate())).thenReturn(true);

        boolean success = recordDistributionService.execute(request);

        assertTrue(success);

        verify(distributionDAO).save(DonationType.MONEY, 12, request.getDate());

        verifyNoMoreInteractions(distributionDAO);
    }

    @Test
    public void testExecute_Failure() {
        RecordDistributionRequest request = new RecordDistributionRequest();
        request.setType(DonationType.MONEY);
        request.setQuantity(12);
        request.setDate(new Date());

        when(distributionDAO.save(DonationType.MONEY, 12, request.getDate())).thenReturn(false);

        boolean success = recordDistributionService.execute(request);

        assertFalse(success);

        verify(distributionDAO).save(DonationType.MONEY, 12, request.getDate());

        verifyNoMoreInteractions(distributionDAO);
    }
}
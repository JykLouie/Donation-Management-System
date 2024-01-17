package com.DAS.codingQuestionBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAS.codingQuestionBackend.request.RecordDistributionRequest;
import com.DAS.codingQuestionBackend.DAO.DistributionDAO;

@Service
public class RecordDistributionService {

    private final DistributionDAO distributionDAO;

    @Autowired
    public RecordDistributionService(DistributionDAO distributionDAO){
        this.distributionDAO = distributionDAO;
    }

    public boolean execute(RecordDistributionRequest recordDistributionRequest){
        boolean result = distributionDAO.save(recordDistributionRequest.getType(),
                            recordDistributionRequest.getQuantity(),
                            recordDistributionRequest.getDate());
        return result;
    }
}

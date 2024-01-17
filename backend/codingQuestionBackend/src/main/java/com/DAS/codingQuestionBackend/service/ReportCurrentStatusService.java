package com.DAS.codingQuestionBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAS.codingQuestionBackend.DAO.CurrentResourcesDAO;
import com.DAS.codingQuestionBackend.enums.DonationType;

import java.util.Map;

@Service
public class ReportCurrentStatusService {
    
    private final CurrentResourcesDAO currentResourcesDAO;

    @Autowired
    public ReportCurrentStatusService(CurrentResourcesDAO currentResourcesDAO){
        this.currentResourcesDAO = currentResourcesDAO;
    }

    public Map<DonationType, Integer> execute(){
        return currentResourcesDAO.getCurrentResourcesMap();
    }
}

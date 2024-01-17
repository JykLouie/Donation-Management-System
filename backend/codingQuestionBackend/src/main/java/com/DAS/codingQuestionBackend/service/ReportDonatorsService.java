package com.DAS.codingQuestionBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAS.codingQuestionBackend.DAO.DonationDAO;
import com.DAS.codingQuestionBackend.enums.DonationType;

import java.util.Map;
import java.util.Date;

@Service
public class ReportDonatorsService {
    private final DonationDAO donationDAO;

    @Autowired
    public ReportDonatorsService(DonationDAO donationDAO){
        this.donationDAO = donationDAO;
    }

    public Map<String, Map<DonationType, Map<Date, Integer>>> execute(){
        return donationDAO.getDonationMap();
    }
}

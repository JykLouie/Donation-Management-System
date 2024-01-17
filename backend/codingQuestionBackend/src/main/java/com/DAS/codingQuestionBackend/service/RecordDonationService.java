package com.DAS.codingQuestionBackend.service;

import com.DAS.codingQuestionBackend.DAO.DonationDAO;
import com.DAS.codingQuestionBackend.request.RecordDonationRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordDonationService {

    private final DonationDAO donationDAO;

    @Autowired
    public RecordDonationService(DonationDAO donationDAO) {
        this.donationDAO = donationDAO;
    }

    public boolean execute(RecordDonationRequest recordDonationRequest){
        donationDAO.save(recordDonationRequest.getName(), 
                        recordDonationRequest.getType(), 
                        recordDonationRequest.getQuantity(),
                        recordDonationRequest.getDate());
        return true;
    }
}

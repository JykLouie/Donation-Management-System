package com.DAS.codingQuestionBackend.DAO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DAS.codingQuestionBackend.enums.DonationType;

@Repository
public class DonationDAO {

    @Autowired
    private CurrentResourcesDAO currentResourcesDAO;


    private final Map<String, Map<DonationType, Map<Date, Integer>>> donationMap = new HashMap<>();

    public void save(String name, DonationType donationType, Integer quantity, Date date){
        //Update DonationMap
        donationMap.putIfAbsent(name, new HashMap<>());
        Map<DonationType, Map<Date, Integer>> nameMap = donationMap.get(name);
        nameMap.putIfAbsent(donationType, new HashMap<>());
        Map<Date, Integer> typeMap = nameMap.get(donationType);
        typeMap.put(date, quantity);

        //Update currentResourcesMap
        Map<DonationType, Integer> currentResourcesMap = currentResourcesDAO.getCurrentResourcesMap();
        currentResourcesDAO.setCurrentResourcesMap(donationType, currentResourcesMap.getOrDefault(donationType, 0) + quantity);
    }

    public Map<String, Map<DonationType, Map<Date, Integer>>> getDonationMap(){
        return donationMap;
    }
}

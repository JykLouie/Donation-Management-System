package com.DAS.codingQuestionBackend.DAO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DAS.codingQuestionBackend.enums.DonationType;

@Repository
public class DistributionDAO {

    @Autowired
    private CurrentResourcesDAO currentResourcesDAO;

    private final Map<Date, Map<DonationType, Integer>> distributionMap = new HashMap<>();
    

    public boolean save(DonationType donationType, Integer quantity, Date date){

        Map<DonationType, Integer> currentResourcesMap = currentResourcesDAO.getCurrentResourcesMap();
        Integer currentResources = currentResourcesMap.get(donationType);

        if(currentResources == null || currentResources < quantity){
            return false;
        }else{
            //Update distributionMap
            distributionMap.putIfAbsent(date, new HashMap<>());
            Map<DonationType, Integer> dateMap = distributionMap.get(date);
            dateMap.put(donationType, quantity);

            //Update currentResourcesMap
            currentResourcesDAO.setCurrentResourcesMap(donationType, currentResources - quantity);
            return true;     
        }
    }

    public Map<Date, Map<DonationType, Integer>> getDistributionMap(){
        return distributionMap;
    }

}

package com.DAS.codingQuestionBackend.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.DAS.codingQuestionBackend.enums.DonationType;

@Repository
public class CurrentResourcesDAO {
        private final Map<DonationType, Integer> currentResourcesMap = new HashMap<>();

    public Map<DonationType, Integer> getCurrentResourcesMap() {
        return currentResourcesMap;
    }

    public void setCurrentResourcesMap(DonationType type, Integer amount){
        currentResourcesMap.put(type, amount);
    }
}

package com.DAS.codingQuestionBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.DAS.codingQuestionBackend.DAO.CurrentResourcesDAO;
import com.DAS.codingQuestionBackend.DAO.DistributionDAO;
import com.DAS.codingQuestionBackend.DAO.DonationDAO;

@Configuration
public class AppConfig {

    @Bean
    public DonationDAO donationDAO() {
        return new DonationDAO();
    }

    @Bean
    public DistributionDAO distributionDAO() {
        return new DistributionDAO();
    }

    @Bean
    public CurrentResourcesDAO currentResourcesDAO(){
        return new CurrentResourcesDAO();
    }
}

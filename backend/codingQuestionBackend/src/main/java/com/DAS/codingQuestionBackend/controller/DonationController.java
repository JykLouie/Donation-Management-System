package com.DAS.codingQuestionBackend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DAS.codingQuestionBackend.request.RecordDonationRequest;
import com.DAS.codingQuestionBackend.service.RecordDistributionService;
import com.DAS.codingQuestionBackend.service.RecordDonationService;
import com.DAS.codingQuestionBackend.request.RecordDistributionRequest;
import com.DAS.codingQuestionBackend.enums.DonationType;
import com.DAS.codingQuestionBackend.service.ReportCurrentStatusService;
import com.DAS.codingQuestionBackend.service.ReportDonatorsService;

import java.util.Map;
import java.util.Date;


@RestController
@RequestMapping("/donation")
public class DonationController {

    private final RecordDonationService recordDonationService;
    private final RecordDistributionService recordDistributionService;
    private final ReportCurrentStatusService reportCurrentStatusService;
    private final ReportDonatorsService reportDonatorsService;

    @Autowired
    public DonationController(RecordDonationService recordDonationService, 
                            RecordDistributionService recordDistributionService,
                            ReportCurrentStatusService reportCurrentStatusService,
                            ReportDonatorsService reportDonatorsService){
        this.recordDonationService = recordDonationService;
        this.recordDistributionService = recordDistributionService;
        this.reportCurrentStatusService = reportCurrentStatusService;
        this.reportDonatorsService = reportDonatorsService;
    }

    @PostMapping("/recordDonation")
    public ResponseEntity<String> recordDonation(@RequestBody RecordDonationRequest recordDonationRequest) {
        boolean success = recordDonationService.execute(recordDonationRequest);
        return success
                ? ResponseEntity.ok("Donation recorded successfully")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to record donation");
    }

    @PostMapping("/recordDistribution")
    public ResponseEntity<String> recordDistribution(@RequestBody RecordDistributionRequest recordDistributionRequest) {
        boolean success = recordDistributionService.execute(recordDistributionRequest);
        return success
                ? ResponseEntity.ok("Distribution recorded successfully")
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to record distribution");
    }

    @GetMapping("/reportCurrentStatus")
    public ResponseEntity<Map<DonationType, Integer>> reportCurrentStatus() {
        Map<DonationType, Integer> currentStatus = reportCurrentStatusService.execute();
        return ResponseEntity.ok(currentStatus);
    }

    @GetMapping("/reportDonators")
    public ResponseEntity<Map<String, Map<DonationType, Map<Date, Integer>>>> reportDonators() {
        Map<String, Map<DonationType, Map<Date, Integer>>> donatorsData = reportDonatorsService.execute();
        return ResponseEntity.ok(donatorsData);
    }
}

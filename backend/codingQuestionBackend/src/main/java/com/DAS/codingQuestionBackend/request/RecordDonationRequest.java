package com.DAS.codingQuestionBackend.request;

import com.DAS.codingQuestionBackend.enums.DonationType;
import java.util.Date;
import lombok.Data;

@Data
public class RecordDonationRequest {
    private String name;
    private DonationType type;
    private Integer quantity;
    private Date date;
}

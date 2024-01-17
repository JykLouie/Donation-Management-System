package com.DAS.codingQuestionBackend.request;

import com.DAS.codingQuestionBackend.enums.DonationType;
import java.util.Date;
import lombok.Data;

@Data
public class RecordDistributionRequest {
    private DonationType type;
    private Integer quantity;
    private Date date;
}

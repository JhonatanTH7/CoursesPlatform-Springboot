package com.Platform.Courses.api.dto.request.update_request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubmissionRequest {

    @NotBlank(message = "The content is required")
    private String content;
    @NotNull(message = "The grade is required")

    @DecimalMin(value = "0.00", inclusive = true, message = "The grade must be between 0 and 5")
    @DecimalMax(value = "5.00", inclusive = true, message = "The grade must be between 0 and 5")
    @Digits(integer = 1, fraction = 2)
    private BigDecimal grade;

}

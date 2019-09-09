package com.company.app.validation.impl;

import com.company.app.validation.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

import static com.company.app.service.impl.CalculationServiceImpl.checkFormatDate;

public class DateValidator implements ConstraintValidator<Date, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)) {
            return true;
        }

        return checkFormatDate(value);
    }
}
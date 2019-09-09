package com.company.app.converter;

import com.company.app.model.CalculationDate;

public interface Converter {

    CalculationDate convert(String source);
}
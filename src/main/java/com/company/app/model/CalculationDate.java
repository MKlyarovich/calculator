package com.company.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculationDate implements Comparable<CalculationDate> {
    private final int day;
    private final int month;
    private final int year;

    @Override
    public int compareTo(CalculationDate calculationDate) {
        if (this.year != calculationDate.getYear()) {
            return this.year > calculationDate.getYear() ? 1 : -1;
        }

        if (this.month != calculationDate.getMonth()) {
            return this.month > calculationDate.getMonth() ? 1 : -1;
        }

        if (this.day != calculationDate.getDay()) {
            return this.day > calculationDate.getDay() ? 1 : -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "" + (String.valueOf(day).length() == 1 ? ("0" + day) : day) + " " +
                (String.valueOf(month).length() == 1 ? ("0" + month) : month) + " " + year;
    }
}
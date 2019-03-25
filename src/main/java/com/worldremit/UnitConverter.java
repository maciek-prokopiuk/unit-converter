package com.worldremit;

import com.worldremit.converters.Converter;

import java.util.List;

import static java.lang.String.format;

public class UnitConverter {

    private final List<Converter> availableConverters;

    public UnitConverter(List<Converter> availableConverters) {
        this.availableConverters = availableConverters;
    }

    public double convert(int value, String fromName, String toName) {
        Converter from = findConverter(fromName);
        Converter to = findConverter(toName);

        validateSameTypeOfUnits(from, to);

        return value * from.getRatioToBase(fromName) / from.getRatioToBase(toName);
    }

    private void validateSameTypeOfUnits(Converter from, Converter to) {
        if (from != to) {
            throw new IllegalArgumentException(
                    "Cannot convert between different types of converters. (eg. mass and length)");
        }
    }

    private Converter findConverter(String unitName) {
        return availableConverters.stream()
                .filter(converter -> converter.containsUnit(unitName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format("Unit %s not supported.", unitName)));
    }
}

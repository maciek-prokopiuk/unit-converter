package com.worldremit.converters;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LengthConverter implements Converter {

    private final Map<String, Double> ratios;

    public LengthConverter() {
        this.ratios = new HashMap<>();
        //let 1cm be the base unit
        ratios.put("cm", 1.0);
        ratios.put("m", 100.0);
        ratios.put("in", 2.54);
    }

    @Override
    public double getRatioToBase(String unit) {
        return ratios.get(unit);
    }

    @Override
    public boolean containsUnit(String unit) {
        return ratios.containsKey(unit);
    }

    @Override
    public Set<String> availableUnits() {
        return ratios.keySet();
    }
}

package com.worldremit.converters;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MassConverter implements Converter {

    private final Map<String, Double> ratios;

    public MassConverter() {
        this.ratios = new HashMap<>();
        //let 1g be the base unit
        ratios.put("g", 1.0);
        ratios.put("kg", 1000.0);
        ratios.put("lb", 453.592);
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
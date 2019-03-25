package com.worldremit.converters;

import java.util.Set;

public interface Converter {

    double getRatioToBase(String unit);

    boolean containsUnit(String unit);

    Set<String> availableUnits();
}

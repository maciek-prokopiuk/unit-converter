package com.worldremit;

import com.worldremit.converters.Converter;
import com.worldremit.converters.LengthConverter;
import com.worldremit.converters.MassConverter;

import java.util.ArrayList;
import java.util.List;

public class Config {

    public static List<Converter> getAvailableConverters() {
        List<Converter> availableConverters = new ArrayList<>();
        availableConverters.add(new LengthConverter());
        availableConverters.add(new MassConverter());

        return availableConverters;
    }
}

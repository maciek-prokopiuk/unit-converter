package com.worldremit;

public class UnitConverterApp {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java -jar jar_file.jar <value> <unit_to_be_converted> <unit_after_convertion>");
            return;
        }

        run(args);
    }

    private static void run(String[] args) {
        UnitConverter unitConverter = new UnitConverter(Config.getAvailableConverters());

        Integer value = Integer.valueOf(args[0]);
        double convertedValue = unitConverter.convert(value, args[1], args[2]);
        System.out.println(convertedValue);
    }
}

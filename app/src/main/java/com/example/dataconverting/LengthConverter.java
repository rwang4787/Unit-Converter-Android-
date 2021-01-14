package com.example.dataconverting;

public class LengthConverter implements UnitConverter{

    // Fields
    double value, convertedValue;
    String from, to;

    LengthConverter(double value, String to, String from) {
        this.value = value;
        convertedValue = value;
        this.to = to;
        this.from = from;
    }

    @Override
    public void convert() {

        // Original base unit is empirical
        if (from == "mi" || from == "yd" || from == "ft" || from == "in") {
            if (to.charAt(1) == 'm') {
                convertedValue = empiricalToMeters(from);

                // Converting meters to another metric base
                convertedValue *= Math.pow(10, -metricBases(to));
            } else {

                // Converting meters to an empirical unit
                convertedValue = metersToEmpirical(to);
            }

        // Original base unit is metric
        } else {
            if (to.charAt(1) == 'm') {

                // Converting between metric bases
                convertedValue *= Math.pow(10, metricBases(from) - metricBases(to));

                // Converting from metric to empirical
            } else {
                convertedValue *= Math.pow(10, metricBases(from));
                convertedValue = metersToEmpirical(to);
            }
        }
    }

    // Converts the value to meters
    double empiricalToMeters(String unit) {
        switch (unit) {
            case "mi":
                return convertedValue*1609.344;
            case "yd":
                return convertedValue/1.094;
            case "ft":
                return convertedValue/3.281;
            case "in":
                return convertedValue/39.37;
        }
        return convertedValue;
    }

    double metersToEmpirical(String unit) {
        switch (unit) {
            case "mi":
                return convertedValue*1609.344;
            case "yd":
                return convertedValue/1.094;
            case "ft":
                return convertedValue/3.281;
            case "in":
                return convertedValue/39.37;
        }
        return convertedValue;
    }

    double metricBases(String unit) {
        switch (unit) {
            case "km":
                return 3;
            case "cm":
                return -2;
            case "mm":
                return -3;

            // default for meters (m)
            default:
                return 0;
        }
    }

    @Override
    public double getConvertedValue() {
        return convertedValue;
    }
}

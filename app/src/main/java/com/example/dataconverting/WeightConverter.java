package com.example.dataconverting;


public class WeightConverter implements UnitConverter{

    // Fields
    double value, convertedValue;
    String from, to;

    WeightConverter(double value, String from, String to) {
        this.value = value;
        convertedValue = value;
        this.from = from;
        this.to = to;
    }

    @Override
    public void convert() {

        // Original base unit is empirical
        if (from.equals("oz") || from.equals("lb")) {
            convertedValue = empiricalToGrams(from);

            if (to.equals("g") || to.charAt(1) == 'g') {

                // Converting grams to another metric base
                convertedValue *= Math.pow(10, -metricBases(to));
            } else {

                // Converting grams to an empirical unit
                convertedValue = gramsToEmpirical(to);
            }

            // Original base unit is metric
        } else {
            if (to.equals("g") || to.charAt(1) == 'g') {

                // Converting between metric bases
                convertedValue *= Math.pow(10, metricBases(from) - metricBases(to));

                // Converting from metric to empirical
            } else {
                convertedValue *= Math.pow(10, metricBases(from));
                convertedValue = gramsToEmpirical(to);
            }
        }
    }

    // Converts the value to grams
    double empiricalToGrams(String unit) {
        switch (unit) {
            case "lb":
                return convertedValue*454;
            case "oz":
                return convertedValue*28.35;
        }
        return convertedValue;
    }

    // Converts grams to an empirical unit
    double gramsToEmpirical(String unit) {
        switch (unit) {
            case "lb":
                return convertedValue/454;
            case "oz":
                return convertedValue/28.35;
        }
        return convertedValue;
    }

    // Returns metric power of ten
    double metricBases(String unit) {
        switch (unit) {
            case "kg":
                return 3;
            case "mg":
                return -3;

            // default for grams (g)
            default:
                return 0;
        }
    }

    public double getConvertedValue() {
        return convertedValue;
    }
}

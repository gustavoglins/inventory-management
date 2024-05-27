package br.com.gustavo.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    public Utils() {
    }

    public String formatValue(double value) {
        Locale locale = new Locale("en", "United Stated");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(value);
    }
}

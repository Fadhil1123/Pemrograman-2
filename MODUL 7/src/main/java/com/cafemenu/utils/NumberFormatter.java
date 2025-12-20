package com.cafemenu.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatter {
    public static final NumberFormat CURRENCY_FORMATTER =
            NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public static final NumberFormat NUMBER_FORMATTER =
            NumberFormat.getNumberInstance(new Locale("id", "ID"));

    public static String currencyFormat(double mount){
        return CURRENCY_FORMATTER.format(mount);
    }

    public static String numberFormat(double number){
        return NUMBER_FORMATTER.format(number);
    }
}

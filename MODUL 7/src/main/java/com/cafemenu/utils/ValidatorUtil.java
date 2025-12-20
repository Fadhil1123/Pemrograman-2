package com.cafemenu.utils;

import javafx.scene.control.TextField;
import java.util.regex.Pattern;

public class ValidatorUtil {
    private ValidatorUtil() {}

    public static boolean isValidId(String id, String jenis) {
        if (id == null || id.trim().isEmpty()) return false;

        Pattern pattern;
        if ("MAKANAN".equalsIgnoreCase(jenis)) {
            pattern = Pattern.compile("F\\d{3}$");
        } else if ("MINUMAN".equalsIgnoreCase(jenis)) {
            pattern = Pattern.compile("D\\d{3}$");
        } else {
            return false;
        }

        return pattern.matcher(id).matches();
    }

    public static boolean isValidPrice(String price) {
        try {
            Double value = Double.parseDouble(price);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNotEmpty(TextField textField) {
        return textField.getText() != null && !textField.getText().trim().isEmpty();
    }
}
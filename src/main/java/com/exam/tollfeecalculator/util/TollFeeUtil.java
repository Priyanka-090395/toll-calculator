package com.exam.tollfeecalculator.util;

public class TollFeeUtil {

    private TollFeeUtil() {
    }

    public static boolean isNotNull(Object anyObject) {
        return null != anyObject;
    }

    public static boolean isArrayNotEmpty(Object[] array) {
        return array != null && array.length > 0;
    }
}

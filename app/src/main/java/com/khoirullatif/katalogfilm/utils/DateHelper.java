package com.khoirullatif.katalogfilm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {
    public static String getCurrentDate() {
        DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();

        return dateformat.format(date);
    }
}

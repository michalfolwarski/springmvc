package com.mfolwarski.springmvc.date;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    private static final String US_PATTERN = "MM/dd/yyyy";
    private static final String NORMAL_PATTERN = "dd/MM/yyyy";
    private static final String ISO_PATTERN = "yyyy-MM-dd";

    public static String getPattern(Locale locale) {
        return isUnitedStates(locale) ? US_PATTERN : ISO_PATTERN;
    }

    private static boolean isUnitedStates(Locale locale) {
        return Locale.US.getCountry().equals(locale.getCountry());
    }

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
    }
}

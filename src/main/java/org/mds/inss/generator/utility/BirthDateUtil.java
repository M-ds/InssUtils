package org.mds.inss.generator.utility;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BirthDateUtil {

    public static Map<String, String> extractBirthDate(final LocalDate birthDate) {
        String year = String.valueOf(birthDate.getYear());
        String month = determineIfZeroNeedsToBeAdded(birthDate.getMonthValue());
        String day = determineIfZeroNeedsToBeAdded(birthDate.getDayOfMonth());

        Map<String, String> splitBirthDate = new HashMap<>();
        splitBirthDate.put("year", year);
        splitBirthDate.put("month", month);
        splitBirthDate.put("day", day);

        return splitBirthDate;
    }

    private static String determineIfZeroNeedsToBeAdded(final int originalValue) {
        if (originalValue < 10) {
            return ("0" + originalValue);
        }
        return String.valueOf(originalValue);
    }
}

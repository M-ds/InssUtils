package org.polarbear.inss.generator.util.main.java.org.polarbear.inss.generator.util;

import java.util.Map;

public class InssFormatUtil {

    public static String formatInss(InssFormat format, Map<String, String> splitBirthDate, String correctedBirthNumber, String lastTwoNumberOfYear, String checkNumber) {
        switch (format) {
            case DEFAULT:
                return lastTwoNumberOfYear + splitBirthDate.get("month") + splitBirthDate.get("day") + correctedBirthNumber + checkNumber;
            case ONLY_DOTS:
                return lastTwoNumberOfYear + "." + splitBirthDate.get("month") + "." + splitBirthDate.get("day") + "." + correctedBirthNumber + "." + checkNumber;
            case ONLY_DASHES:
                return lastTwoNumberOfYear + "-" + splitBirthDate.get("month") + "-" + splitBirthDate.get("day") + "-" + correctedBirthNumber + "-" + checkNumber;
            case READABLE:
            default:
                return lastTwoNumberOfYear + "." + splitBirthDate.get("month") + "." + splitBirthDate.get("day") + "-" + correctedBirthNumber + "." + checkNumber;
        }
    }

    public static String addAdditionalCharacterAtStartOfString(String stringWhichNeedModifying, char characterToAdd) {
        StringBuilder sb = new StringBuilder(stringWhichNeedModifying);
        sb.insert(0, characterToAdd);
        return sb.toString();
    }

    public static String addAdditionalZerosBeforeBirthNumber(int originalLastBirtNumber) {
        StringBuilder sb = new StringBuilder();
        sb.insert(0, "00");
        sb.append(originalLastBirtNumber);
        return sb.toString();
    }

    public static String formatCheckNumber(long checkNumber) {
        if (checkNumber < 10) {
            return "0" + checkNumber;
        }
        return String.valueOf(checkNumber);
    }
}

package nl.mds.inss.generator.format;

import nl.mds.inss.domain.InssFormat;
import nl.mds.inss.generator.util.BirthDateUtil;

import java.util.Map;

public class InssFormatUtil {

    public static String formatInss(InssFormat format, Map<String, String> splitBirthDate, String correctedBirthNumber, String lastTwoNumberOfYear, String checkNumber) {
        switch (format) {
            case DEFAULT:
                return lastTwoNumberOfYear + splitBirthDate.get(BirthDateUtil.MONTH) + splitBirthDate.get(BirthDateUtil.DAY) + correctedBirthNumber + checkNumber;
            case ONLY_DOTS:
                return formatFinalInss(splitBirthDate, correctedBirthNumber, lastTwoNumberOfYear, checkNumber, ".", ".");
            case ONLY_DASHES:
                return formatFinalInss(splitBirthDate, correctedBirthNumber, lastTwoNumberOfYear, checkNumber, "-", "-");
            case READABLE:
            default:
                return formatFinalInss(splitBirthDate, correctedBirthNumber, lastTwoNumberOfYear, checkNumber, ".", "-");
        }
    }

    // Method to generate Inss like: 10-12-11.154-12
    private static String formatFinalInss(Map<String, String> splitBirthDate, String correctedBirthNumber, String lastTwoNumberOfYear, String checkNumber, String firstFormat, String secondOptionalFormat) {
        return lastTwoNumberOfYear + firstFormat + splitBirthDate.get(BirthDateUtil.MONTH) + firstFormat + splitBirthDate.get(BirthDateUtil.DAY) + secondOptionalFormat + correctedBirthNumber + firstFormat + checkNumber;
    }

    public static String addAdditionalCharacterAtStartOfString(String stringWhichNeedModifying, String charactersToAdd) {
        final char[] characters = charactersToAdd.toCharArray();
        StringBuilder sb = new StringBuilder(stringWhichNeedModifying);
        if (characters.length > 0) {
            sb.insert(0, characters[0]);
        }
        if (characters.length > 1) {
            sb.insert(1, characters[1]);
        }
        return sb.toString();
    }
}

package nl.mds.inss.generator.util;

import nl.mds.inss.generator.format.InssFormatUtil;

public class CheckNumberUtil {

    private static final long MODULE_VALUE = 97;

    public String generateCheckNumber(final int birthYear, final String inssWithoutSecurityCode) {
        String refactoredInssSecurityCode;
        if (birthYear >= 2000) {
            refactoredInssSecurityCode = InssFormatUtil.addAdditionalCharacterAtStartOfString(inssWithoutSecurityCode, "2");
        } else {
            refactoredInssSecurityCode = inssWithoutSecurityCode;
        }

        long checkNumber = determineCheckNumber(refactoredInssSecurityCode);
        return formatCheckNumber(checkNumber);
    }

    private static long determineCheckNumber(final String inssWithoutSecurityCode) {
        long inssLongValue = Long.parseLong(inssWithoutSecurityCode);
        long moduleValue = inssLongValue % MODULE_VALUE;
        return MODULE_VALUE - moduleValue;
    }

    private static String formatCheckNumber(final long checkNumber) {
        if (checkNumber < 10) {
            return "0" + checkNumber;
        }
        return String.valueOf(checkNumber);
    }
}

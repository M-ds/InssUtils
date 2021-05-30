package org.polarbear.inss.generator.util;

public class CheckNumberUtil {

    private static final long MODULE_VALUE = 97;

    public static String generateCheckNumber(int birthYear, String inssWithoutSecurityCode) {
        String refactoredInssSecurityCode;
        if (birthYear >= 2000) {
            refactoredInssSecurityCode = InssFormatUtil.addAdditionalCharacterAtStartOfString(inssWithoutSecurityCode, '2');
        } else {
            refactoredInssSecurityCode = inssWithoutSecurityCode;
        }

        long checkNumber = determineCheckNumber(refactoredInssSecurityCode);
        return InssFormatUtil.formatCheckNumber(checkNumber);
    }

    private static long determineCheckNumber(String inssWithoutSecurityCode) {
        long inssLongValue = Long.parseLong(inssWithoutSecurityCode);
        long moduleValue = inssLongValue % MODULE_VALUE;
        return MODULE_VALUE - moduleValue;
    }
}

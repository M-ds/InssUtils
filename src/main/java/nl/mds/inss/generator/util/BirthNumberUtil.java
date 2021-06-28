package nl.mds.inss.generator.util;

import nl.mds.inss.domain.Gender;
import nl.mds.inss.generator.format.InssFormatUtil;
import nl.mds.inss.util.GeneralBirthNumberUtil;

public class BirthNumberUtil {

    private static final int MAX_BIRTH_NUMBER = 997;

    public String getCorrectedBirthNumber(final String birthNumber, final Gender gender) {
        int parsedBirthNumber = parseBirthNumber(birthNumber);
        int correctedBirthNumber = correctBirthNumberIfNecessary(parsedBirthNumber, gender);
        return presentBirthNumber(correctedBirthNumber);
    }

    private int parseBirthNumber(final String birthNumber) {
        int parsedBirthNumber = Integer.parseInt(birthNumber);
        return Math.min(parsedBirthNumber, MAX_BIRTH_NUMBER);
    }

    private int correctBirthNumberIfNecessary(final int parsedBirthNumber, final Gender gender) {
        int correctedBirthNumber = parsedBirthNumber;
        if (Gender.MALE.equals(gender)) {
            if (GeneralBirthNumberUtil.isEven(parsedBirthNumber)) {
                correctedBirthNumber += 1;
            }
        } else {
            if (GeneralBirthNumberUtil.isOdd(parsedBirthNumber)) {
                correctedBirthNumber += 1;
            }
        }
        return correctedBirthNumber;
    }

    private String presentBirthNumber(int correctedBirthNumber) {
        String presentableBirthNumber = String.valueOf(correctedBirthNumber);
        if (presentableBirthNumber.length() == 1) {
            return InssFormatUtil.addAdditionalCharacterAtStartOfString(presentableBirthNumber, "00");
        } else if (presentableBirthNumber.length() == 2) {
            return InssFormatUtil.addAdditionalCharacterAtStartOfString(presentableBirthNumber, "0");
        } else {
            return presentableBirthNumber;
        }
    }
}

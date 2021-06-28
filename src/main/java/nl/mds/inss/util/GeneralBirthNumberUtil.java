package nl.mds.inss.util;

import nl.mds.inss.domain.Gender;

public class GeneralBirthNumberUtil {

    public static boolean isInvalidBirthNumber(String birthNumber) {
        return !birthNumber.matches("[0-9]+");
    }

    public static boolean isEven(final int birthNumber) {
        return birthNumber % 2 == 0;
    }

    public static boolean isOdd(final int birthNumber) {
        return !isEven(birthNumber);
    }

    public static Gender determineGender(final int birthNumber) {
        if (isEven(birthNumber)) {
            return Gender.FEMALE;
        }
        return Gender.MALE;
    }
}

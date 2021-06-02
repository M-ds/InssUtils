package org.polarbear.software.inss.util;

public class BirthNumberUtil {

    public static boolean isValidBirthNumber(String birthNumber) {
        return birthNumber.matches("[0-9]+");
    }

}

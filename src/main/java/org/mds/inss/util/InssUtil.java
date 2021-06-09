package org.mds.inss.util;

import org.mds.inss.domain.Gender;
import org.mds.inss.domain.Inss;
import org.mds.inss.domain.InssConstants;
import org.mds.inss.domain.InssFormat;
import org.mds.inss.domain.InternalInss;
import org.mds.inss.exception.InvalidInssFormat;
import org.mds.inss.generator.utility.Generator;

import java.time.LocalDate;

public class InssUtil {

    public static InternalInss extractInss(final String inss) throws InvalidInssFormat {
        if (validLength(inss)) {
            return new InternalInss(inss);
        }
        throw new InvalidInssFormat("Please check your provided INSS number. The format is not correct.");
    }

    private static boolean validLength(final String inss) {
        return inss.length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT || inss.length() == InssConstants.INSS_LENGTH_WITH_FORMAT;
    }

    public static boolean isBirthDateBefore2000(Inss inss) {
        if (hasNoFormat(inss)) {
            LocalDate birthDate = extractBirthDateBefore2000WithoutFormat(inss);
            int birthNumber = extractBirthNumber(inss);
            String stringBirthNumber = String.valueOf(birthNumber);
            Gender gender = GeneralBirthNumberUtil.determineGender(birthNumber);
            Inss generateInss = Generator.getInstance().generateInss(InssFormat.DEFAULT, birthDate, stringBirthNumber, gender);
            return inss.getInss().equals(generateInss.getInss());
        }
        LocalDate birthDate = extractBirthDateBefore2000WithFormat(inss);
        int birthNumber = extractBirthNumber(inss);
        String stringBirthNumber = String.valueOf(birthNumber);
        Gender gender = GeneralBirthNumberUtil.determineGender(birthNumber);
        Inss generateInss = Generator.getInstance().generateInss(InssFormat.READABLE, birthDate, stringBirthNumber, gender);
        return inss.getInss().equals(generateInss.getInss());
    }

    private static boolean hasNoFormat(Inss inss) {
        return inss.getInss().length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT;
    }

    public static LocalDate extractBirthDateAfter2000WithoutFormat(Inss inss) {
        String birthDate = inss.getInss().substring(0, 6);
        String year = "20" + birthDate.substring(0, 2);
        String month = birthDate.substring(2, 4);
        String day = birthDate.substring(4, 6);
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    public static LocalDate extractBirthDateAfter2000WithFormat(Inss inss){
        String birthDate = inss.getInss().substring(0, 8);
        String year = "20" + birthDate.substring(0, 2);
        String month = birthDate.substring(3, 5);
        String day = birthDate.substring(6, 8);
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    public static LocalDate extractBirthDateBefore2000WithoutFormat(Inss inss) {
        String birthDate = inss.getInss().substring(0, 6);
        String year = "19" + birthDate.substring(0, 2);
        String month = birthDate.substring(2, 4);
        String day = birthDate.substring(4, 6);
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    public static LocalDate extractBirthDateBefore2000WithFormat(Inss inss){
        String birthDate = inss.getInss().substring(0, 8);
        String year = "19" + birthDate.substring(0, 2);
        String month = birthDate.substring(4, 5);
        String day = birthDate.substring(6, 8);
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    public static int extractBirthNumber(Inss inss) {
        if (hasNoFormat(inss)) {
            String birthNumber = inss.getInss().substring(6, 9);
            return Integer.parseInt(birthNumber);
        }
        String birthNumber = inss.getInss().substring(9, 12);
        return Integer.parseInt(birthNumber);
    }
}

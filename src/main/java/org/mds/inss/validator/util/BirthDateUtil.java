package org.mds.inss.validator.util;

import org.mds.inss.domain.Gender;
import org.mds.inss.domain.Inss;
import org.mds.inss.domain.InssConstants;
import org.mds.inss.domain.InssFormat;
import org.mds.inss.generator.service.Generator;
import org.mds.inss.util.GeneralBirthNumberUtil;

import java.time.LocalDate;

public class BirthDateUtil {

    public boolean isBirthDateBefore2000(Inss inss) {
        if (inss.isHasNoFormat()) {
            LocalDate birthDate = extractBirthDateBefore2000WithoutFormat(inss);
            int birthNumber = inss.extractBirthNumber();
            String stringBirthNumber = String.valueOf(birthNumber);
            Gender gender = GeneralBirthNumberUtil.determineGender(birthNumber);
            Inss generateInss = Generator.getInstance().generateInss(InssFormat.DEFAULT, birthDate, stringBirthNumber, gender);
            return inss.getInss().equals(generateInss.getInss());
        }
        LocalDate birthDate = extractBirthDateBefore2000WithFormat(inss);
        int birthNumber = inss.extractBirthNumber();
        String stringBirthNumber = String.valueOf(birthNumber);
        Gender gender = GeneralBirthNumberUtil.determineGender(birthNumber);
        Inss generateInss = Generator.getInstance().generateInss(InssFormat.READABLE, birthDate, stringBirthNumber, gender);
        return inss.getInss().equals(generateInss.getInss());
    }

    public LocalDate getBirthDate(Inss inss) {
        boolean before2000 = isBirthDateBefore2000(inss);
        boolean hasNoFormat = hasNoFormat(inss);
        if (hasNoFormat && before2000) {
            return extractBirthDateBefore2000WithoutFormat(inss);
        } else if (!hasNoFormat && before2000) {
            return extractBirthDateBefore2000WithFormat(inss);
        } else if (hasNoFormat) {
            return extractBirthDateAfter2000WithoutFormat(inss);
        } else {
            return extractBirthDateAfter2000WithFormat(inss);
        }
    }

    private LocalDate extractBirthDateAfter2000WithoutFormat(Inss inss) {
        String birthDate = inss.getInss().substring(0, 6);
        String year = "20" + birthDate.substring(0, 2);
        String month = birthDate.substring(2, 4);
        String day = birthDate.substring(4, 6);
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    private static LocalDate extractBirthDateAfter2000WithFormat(Inss inss){
        String birthDate = inss.getInss().substring(0, 8);
        String year = "20" + birthDate.substring(0, 2);
        String month = birthDate.substring(3, 5);
        String day = birthDate.substring(6, 8);
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    private static LocalDate extractBirthDateBefore2000WithoutFormat(Inss inss) {
        String birthDate = inss.getInss().substring(0, 6);
        String year = "19" + birthDate.substring(0, 2);
        String month = birthDate.substring(2, 4);
        String day = birthDate.substring(4, 6);
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    private static LocalDate extractBirthDateBefore2000WithFormat(Inss inss){
        String birthDate = inss.getInss().substring(0, 8);
        String year = "19" + birthDate.substring(0, 2);
        String month = birthDate.substring(4, 5);
        String day = birthDate.substring(6, 8);
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    private boolean hasNoFormat(Inss inss) {
        return inss.getInss().length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT;
    }
}

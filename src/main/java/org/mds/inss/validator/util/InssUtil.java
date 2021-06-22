package org.mds.inss.validator.util;

import org.mds.inss.domain.Gender;
import org.mds.inss.domain.Inss;
import org.mds.inss.domain.InssConstants;
import org.mds.inss.domain.InssFormat;
import org.mds.inss.exception.InvalidInssFormat;
import org.mds.inss.generator.service.Generator;
import org.mds.inss.util.GeneralBirthNumberUtil;

import java.time.DateTimeException;
import java.time.LocalDate;

public class InssUtil {

    private final BirthDateUtil birthDateUtil;

    public InssUtil(){
        this.birthDateUtil = new BirthDateUtil();
    }

    public static Inss extractInss(final String inss) throws InvalidInssFormat {
        if (validLength(inss)) {
            return new Inss(inss);
        }
        throw new InvalidInssFormat("Please check your provided INSS number. The format is not correct.");
    }

    private static boolean validLength(final String inss) {
        return inss.length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT || inss.length() == InssConstants.INSS_LENGTH_WITH_FORMAT;
    }

    public boolean isValidInss(Inss inss) {
        try {
            LocalDate extractedBirthDate = birthDateUtil.getBirthDate(inss);
            int extractedBirthNumber = inss.extractBirthNumber();
            Gender gender = GeneralBirthNumberUtil.determineGender(extractedBirthNumber);
            Inss generatedInss;
            if (inss.isHasNoFormat()) {
                generatedInss = Generator.getInstance().generateInss(InssFormat.DEFAULT, extractedBirthDate, String.valueOf(extractedBirthNumber), gender);
            } else {
                generatedInss = Generator.getInstance().generateInss(InssFormat.READABLE, extractedBirthDate, String.valueOf(extractedBirthNumber), gender);
            }
            return generatedInss.hasValidLength();
        } catch (
                DateTimeException exception) {
            System.out.println("Invalid date provided");
            return false;
        }

    }
}

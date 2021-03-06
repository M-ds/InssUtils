package nl.mds.inss.validator.util;

import nl.mds.inss.domain.Gender;
import nl.mds.inss.domain.Inss;
import nl.mds.inss.domain.InssFormat;
import nl.mds.inss.generator.service.Generator;
import nl.mds.inss.util.GeneralBirthNumberUtil;
import nl.mds.inss.domain.InssConstants;
import nl.mds.inss.exception.InvalidInssFormat;

import java.time.DateTimeException;
import java.time.LocalDate;

public class InssUtil {

    private final static String ONLY_KEEP_DIGITS = "[^\\d]";
    private final BirthDateUtil birthDateUtil;

    public InssUtil() {
        this.birthDateUtil = new BirthDateUtil();
    }

    public static Inss extractInss(final String inss) throws InvalidInssFormat {
        if (validLength(inss)) {
            return extractFormatIfPresent(new Inss(inss));
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
            Inss originalInssWithoutMarkup = extractFormatIfPresent(inss);
            Inss generatedInss = Generator.getInstance().generateInss(InssFormat.DEFAULT, extractedBirthDate, String.valueOf(extractedBirthNumber), gender);
            return originalInssWithoutMarkup.getInss().equals(generatedInss.getInss());
        } catch (
                DateTimeException exception) {
            System.out.println("Invalid date provided");
            return false;
        }

    }

    private static Inss extractFormatIfPresent(Inss inss) {
        if (!inss.hasNoFormat()) {
            String inssWithoutFormat = inss.getInss().replaceAll(ONLY_KEEP_DIGITS, "");
            return new Inss(inssWithoutFormat);
        }
        return inss;
    }
}

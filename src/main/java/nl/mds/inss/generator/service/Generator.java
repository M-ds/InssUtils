package nl.mds.inss.generator.service;

import nl.mds.inss.domain.Gender;
import nl.mds.inss.domain.Inss;
import nl.mds.inss.generator.format.InssFormatUtil;
import nl.mds.inss.generator.util.BirthNumberUtil;
import nl.mds.inss.generator.util.CheckNumberUtil;
import nl.mds.inss.domain.InssFormat;
import nl.mds.inss.generator.util.BirthDateUtil;

import java.time.LocalDate;
import java.util.Map;

public class Generator {

    private static Generator INSTANCE;

    private final BirthNumberUtil birthNumberUtil;
    private final CheckNumberUtil checkNumberUtil;

    private Generator() {
        this.birthNumberUtil = new BirthNumberUtil();
        this.checkNumberUtil = new CheckNumberUtil();
    }

    public static Generator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Generator();
        }
        return INSTANCE;
    }

    public Inss generateInss(final InssFormat format, final LocalDate birthDate, final String birthNumber, final Gender gender) {
        Map<String, String> splitBirthDate = BirthDateUtil.extractBirthDate(birthDate);
        String correctedBirthNumber = birthNumberUtil.getCorrectedBirthNumber(birthNumber, gender);

        String year = splitBirthDate.get(BirthDateUtil.YEAR);
        String lastTwoNumberOfYear = year.substring(year.length() - 2);

        String inssWithoutSecurityCode = formatInssWithoutSecurityCode(splitBirthDate, correctedBirthNumber, lastTwoNumberOfYear);

        String formattedCheckNumber = checkNumberUtil.generateCheckNumber(Integer.parseInt(year), inssWithoutSecurityCode);

        return new Inss(
                InssFormatUtil.formatInss(
                        format,
                        splitBirthDate,
                        correctedBirthNumber,
                        lastTwoNumberOfYear,
                        formattedCheckNumber
                )
        );
    }

    private String formatInssWithoutSecurityCode(Map<String, String> splitBirthDate, String correctedBirthNumber, String lastTwoNumberOfYear) {
        return lastTwoNumberOfYear
                + splitBirthDate.get(BirthDateUtil.MONTH)
                + splitBirthDate.get(BirthDateUtil.DAY)
                + correctedBirthNumber;
    }
}

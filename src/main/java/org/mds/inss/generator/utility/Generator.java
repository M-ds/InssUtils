package org.mds.inss.generator.utility;

import org.mds.inss.domain.Gender;
import org.mds.inss.domain.Inss;
import org.mds.inss.domain.InssFormat;
import org.mds.inss.generator.format.InssFormatUtil;

import java.time.LocalDate;
import java.util.Map;

public class Generator {

    private static Generator INSTANCE;

    private Generator() {
    }

    public static Generator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Generator();
        }
        return INSTANCE;
    }

    public Inss generateInss(final InssFormat format, final LocalDate birthDate, final String birthNumber, final Gender gender) {
        Map<String, String> splitBirthDate = BirthDateUtil.extractBirthDate(birthDate);
        String correctedBirthNumber = BirthNumberUtil.getBirthNumber(birthNumber, gender);

        String year = splitBirthDate.get("year");
        String lastTwoNumberOfYear = year.substring(year.length() - 2);

        String inssWithoutSecurityCode = lastTwoNumberOfYear
                + splitBirthDate.get("month")
                + splitBirthDate.get("day")
                + correctedBirthNumber;

        String formattedCheckNumber = CheckNumberUtil.generateCheckNumber(Integer.parseInt(year), inssWithoutSecurityCode);

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

}

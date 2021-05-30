package org.polarbear.inss.generator.util;

import org.polarbear.inss.domain.Gender;
import org.polarbear.inss.domain.Inss;

import java.time.LocalDate;
import java.util.Map;

public class GenerateInss {

    private static GenerateInss INSTANCE;

    private GenerateInss() {
    }

    public static GenerateInss getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GenerateInss();
        }
        return INSTANCE;
    }

    /**
     * This function generates a new Inss number. Each of the constraints are checked in this function.
     * Therefore a valid and usable Inss number is generated.
     *
     * @param birthDate   - birthDate to which is used for the generation of the Inss number
     * @param birthNumber - Needed to generate a check number
     * @param gender      - Needed to check if the birthNumber is valid or need to be adjusted.
     * @return Inss number.
     */
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

package org.polarbear.inss.generator;

import org.polarbear.inss.domain.Gender;
import org.polarbear.inss.domain.Inss;
import org.polarbear.inss.exception.InvalidBirthNumberException;
import org.polarbear.inss.InssGenerator;
import org.polarbear.inss.generator.util.GenerateInss;
import org.polarbear.inss.generator.util.InssFormat;
import org.polarbear.inss.util.RandomnessUtil;

import java.time.LocalDate;

public class InssGeneratorImpl implements InssGenerator {

    @Override
    public Inss generateRandomInss() {
        return generateCompleteInssNumber(
                InssFormat.DEFAULT,
                RandomnessUtil.generateRandomBirthDate(),
                RandomnessUtil.generateRandomBirthNumber(),
                RandomnessUtil.generateRandomGender()
        );
    }

    @Override
    public Inss generateInss(LocalDate birthDate, String birthNumber, Gender gender) {
        return generateCompleteInssNumber(InssFormat.READABLE, birthDate, birthNumber, gender);
    }

    @Override
    public Inss generateInss(LocalDate birthDate, int birthNumber, Gender gender) throws InvalidBirthNumberException {
        if (birthNumber > 997) {
            throw new InvalidBirthNumberException("BirthNumber can not be greater than 999. Current number is: " + birthNumber);
        }
        String birthNumberString = String.valueOf(birthNumber);
        return generateCompleteInssNumber(InssFormat.READABLE, birthDate, birthNumberString, gender);
    }

    private Inss generateCompleteInssNumber(final InssFormat format, final LocalDate birthDate, final String birthNumber, final Gender gender) {
        return GenerateInss.getInstance().generateInss(format, birthDate, birthNumber, gender);
    }

}

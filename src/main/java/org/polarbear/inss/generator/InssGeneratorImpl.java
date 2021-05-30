package org.polarbear.inss.generator;

import org.polarbear.inss.domain.Gender;
import org.polarbear.inss.domain.Inss;
import org.polarbear.inss.exception.InvalidBirthNumberException;
import org.polarbear.inss.InssGenerator;
import org.polarbear.inss.generator.readable.GenerateInss;
import org.polarbear.inss.generator.readable.InssFormat;
import org.polarbear.inss.util.RandomnessUtil;

import java.time.LocalDate;

public class InssGeneratorImpl implements InssGenerator {

    @Override
    public Inss generateDefaultInss() {
        return generateCompleteInssNumber(
                InssFormat.DEFAULT,
                RandomnessUtil.generateRandomBirthDate(),
                RandomnessUtil.generateRandomBirthNumber(),
                RandomnessUtil.generateRandomGender()
        );
    }

    @Override
    public Inss generateReadableInss() {
        return generateCompleteInssNumber(
                InssFormat.READABLE,
                RandomnessUtil.generateRandomBirthDate(),
                RandomnessUtil.generateRandomBirthNumber(),
                RandomnessUtil.generateRandomGender()
        );
    }

    @Override
    public Inss generateReadableInss(final LocalDate birthDate, final String birthNumber, final Gender gender) {
        return generateCompleteInssNumber(
                InssFormat.READABLE,
                birthDate,
                birthNumber,
                gender
        );
    }

    @Override
    public Inss generateReadableInss(final LocalDate birthDate, final int birthNumber, final Gender gender) throws InvalidBirthNumberException {
        if (birthNumber > 997) {
            throw new InvalidBirthNumberException("BirthNumber can not be greater than 999. Current number is: " + birthNumber);
        }
        String birthNumberString = String.valueOf(birthNumber);
        return generateCompleteInssNumber(
                InssFormat.READABLE,
                birthDate,
                birthNumberString,
                gender
        );
    }

    @Override
    public Inss generateMaleInss(final LocalDate birthDate) {
        return generateCompleteInssNumber(
                InssFormat.DEFAULT,
                birthDate,
                RandomnessUtil.generateRandomBirthNumber(),
                Gender.MALE
        );
    }

    @Override
    public Inss generateFemaleInss(final LocalDate birthDate) {
        return generateCompleteInssNumber(
                InssFormat.DEFAULT,
                birthDate,
                RandomnessUtil.generateRandomBirthNumber(),
                Gender.FEMALE
        );
    }

    private Inss generateCompleteInssNumber(final InssFormat format, final LocalDate birthDate, final String birthNumber, final Gender gender) {
        return GenerateInss.getInstance().generateInss(format, birthDate, birthNumber, gender);
    }

}

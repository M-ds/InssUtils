package org.polarbear.software.inss.generator;

import org.polarbear.software.inss.domain.Gender;
import org.polarbear.software.inss.domain.Inss;
import org.polarbear.software.inss.exception.InvalidBirthNumberException;
import org.polarbear.software.inss.InssGenerator;
import org.polarbear.software.inss.generator.readable.GenerateInss;
import org.polarbear.software.inss.generator.readable.InssFormat;
import org.polarbear.software.inss.util.BirthNumberUtil;
import org.polarbear.software.inss.util.RandomnessUtil;

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
        String birthNumberString = String.valueOf(birthNumber);
        if (!BirthNumberUtil.isValidBirthNumber(birthNumberString)) {
            throw new InvalidBirthNumberException("BirthNumber can not be greater than 997. Current number is: " + birthNumber);
        }
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

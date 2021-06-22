package org.mds.inss.generator;

import org.mds.inss.InssGenerator;
import org.mds.inss.domain.Gender;
import org.mds.inss.domain.Inss;
import org.mds.inss.exception.InvalidBirthNumberException;
import org.mds.inss.domain.InssFormat;
import org.mds.inss.util.GeneralBirthNumberUtil;
import org.mds.inss.util.RandomnessUtil;
import org.mds.inss.generator.util.Generator;

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
    public Inss generateOnlyDotsInss() {
        return generateCompleteInssNumber(
                InssFormat.ONLY_DOTS,
                RandomnessUtil.generateRandomBirthDate(),
                RandomnessUtil.generateRandomBirthNumber(),
                RandomnessUtil.generateRandomGender()
        );
    }

    @Override
    public Inss generateOnlyDashesInss() {
        return generateCompleteInssNumber(
                InssFormat.ONLY_DASHES,
                RandomnessUtil.generateRandomBirthDate(),
                RandomnessUtil.generateRandomBirthNumber(),
                RandomnessUtil.generateRandomGender()
        );
    }

    @Override
    public Inss generateDefaultFemaleInss() {
        return generateCompleteInssNumber(
                InssFormat.DEFAULT,
                RandomnessUtil.generateRandomBirthDate(),
                RandomnessUtil.generateRandomBirthNumber(),
                Gender.FEMALE
        );
    }

    @Override
    public Inss generateReadableFemaleInss() {
        return generateCompleteInssNumber(
                InssFormat.READABLE,
                RandomnessUtil.generateRandomBirthDate(),
                RandomnessUtil.generateRandomBirthNumber(),
                Gender.FEMALE
        );
    }

    @Override
    public Inss generateDefaultMaleInss() {
        return generateCompleteInssNumber(
                InssFormat.DEFAULT,
                RandomnessUtil.generateRandomBirthDate(),
                RandomnessUtil.generateRandomBirthNumber(),
                Gender.MALE
        );
    }

    @Override
    public Inss generateReadableMaleInss() {
        return generateCompleteInssNumber(
                InssFormat.READABLE,
                RandomnessUtil.generateRandomBirthDate(),
                RandomnessUtil.generateRandomBirthNumber(),
                Gender.MALE
        );
    }

    @Override
    public Inss generateDefaultInss(final LocalDate birthDate, final String birthNumber, final Gender gender) throws InvalidBirthNumberException {
        if (GeneralBirthNumberUtil.isInvalidBirthNumber(birthNumber)) {
            throw new InvalidBirthNumberException("Birth Number is invalid, it should only contain numbers. Provided input: " + birthNumber);
        }
        return generateCompleteInssNumber(
                InssFormat.DEFAULT,
                birthDate,
                birthNumber,
                gender
        );
    }

    @Override
    public Inss generateDefaultInss(final LocalDate birthDate, final int birthNumber, final Gender gender) {
        String birthNumberString = String.valueOf(birthNumber);
        return generateCompleteInssNumber(
                InssFormat.DEFAULT,
                birthDate,
                birthNumberString,
                gender
        );
    }


    @Override
    public Inss generateReadableInss(final LocalDate birthDate, final String birthNumber, final Gender gender) throws InvalidBirthNumberException {
        if (GeneralBirthNumberUtil.isInvalidBirthNumber(birthNumber)) {
            throw new InvalidBirthNumberException("Birth Number is invalid, it should only contain numbers. Provided input: " + birthNumber);
        }
        return generateCompleteInssNumber(
                InssFormat.READABLE,
                birthDate,
                birthNumber,
                gender
        );
    }

    @Override
    public Inss generateReadableInss(final LocalDate birthDate, final int birthNumber, final Gender gender) {
        String birthNumberString = String.valueOf(birthNumber);
        return generateCompleteInssNumber(
                InssFormat.READABLE,
                birthDate,
                birthNumberString,
                gender
        );
    }

    @Override
    public Inss generateDefaultMaleInss(final LocalDate birthDate) {
        return generateCompleteInssNumber(
                InssFormat.DEFAULT,
                birthDate,
                RandomnessUtil.generateRandomBirthNumber(),
                Gender.MALE
        );
    }

    @Override
    public Inss generateReadableMaleInss(final LocalDate birthDate) {
        return generateCompleteInssNumber(
                InssFormat.READABLE,
                birthDate,
                RandomnessUtil.generateRandomBirthNumber(),
                Gender.MALE
        );
    }

    @Override
    public Inss generateDefaultFemaleInss(final LocalDate birthDate) {
        return generateCompleteInssNumber(
                InssFormat.DEFAULT,
                birthDate,
                RandomnessUtil.generateRandomBirthNumber(),
                Gender.FEMALE
        );
    }

    @Override
    public Inss generateReadableFemaleInss(final LocalDate birthDate) {
        return generateCompleteInssNumber(
                InssFormat.READABLE,
                birthDate,
                RandomnessUtil.generateRandomBirthNumber(),
                Gender.FEMALE
        );
    }

    @Override
    public Inss generateInss(final InssFormat inssFormat, final LocalDate birthDate, final String birthNumber, final Gender gender) throws InvalidBirthNumberException {
        if (GeneralBirthNumberUtil.isInvalidBirthNumber(birthNumber)) {
            throw new InvalidBirthNumberException("Birth Number is invalid, it should only contain numbers. Provided input: " + birthNumber);
        }
        return generateCompleteInssNumber(
                inssFormat,
                birthDate,
                birthNumber,
                gender
        );
    }

    @Override
    public Inss generateInss(final InssFormat inssFormat, final LocalDate birthDate, final int birthNumber, final Gender gender) {
        String birthNumberString = String.valueOf(birthNumber);
        return generateCompleteInssNumber(
                inssFormat,
                birthDate,
                birthNumberString,
                gender
        );
    }

    private Inss generateCompleteInssNumber(final InssFormat format, final LocalDate birthDate, final String birthNumber, final Gender gender) {
        return Generator.getInstance().generateInss(format, birthDate, birthNumber, gender);
    }

}

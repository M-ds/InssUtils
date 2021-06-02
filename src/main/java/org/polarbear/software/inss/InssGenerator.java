package org.polarbear.software.inss;

import org.polarbear.software.inss.domain.Gender;
import org.polarbear.software.inss.domain.Inss;
import org.polarbear.software.inss.exception.InvalidBirthNumberException;

import java.time.LocalDate;

public interface InssGenerator {

    Inss generateDefaultInss();

    Inss generateReadableInss();

    Inss generateReadableInss(LocalDate birthDate, String birthNumber, Gender gender);

    /**
     * Generates an Inss number based on parameters provided.
     * Inss number will have the format of "11.11.11-111.11"
     *
     * @param birthDate - BirthDate to be put in the Inss generation
     * @param birthNumber - birthNumber. If greater than 997 it will be set automatically to 997.
     * @param gender - Needed to perform a check for the validity of the birthNumber.
     *
     * @return Generated INSS number based on the input values
     */
    Inss generateReadableInss(LocalDate birthDate, int birthNumber, Gender gender) throws InvalidBirthNumberException;

    Inss generateMaleInss(LocalDate birthDate);

    Inss generateFemaleInss(LocalDate birthDate);

}

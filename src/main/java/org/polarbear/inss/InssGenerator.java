package org.polarbear.inss;

import org.polarbear.inss.domain.Gender;
import org.polarbear.inss.domain.Inss;
import org.polarbear.inss.exception.InvalidBirthNumberException;

import java.time.LocalDate;

public interface InssGenerator {

    Inss generateDefaultInss();

    Inss generateReadableInss();

    Inss generateReadableInss(LocalDate birthDate, String birthNumber, Gender gender);

    Inss generateReadableInss(LocalDate birthDate, int birthNumber, Gender gender) throws InvalidBirthNumberException;

    Inss generateMaleInss(LocalDate birthDate);

    Inss generateFemaleInss(LocalDate birthDate);

}

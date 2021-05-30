package org.polarbear.inss;

import org.polarbear.inss.domain.Gender;
import org.polarbear.inss.domain.Inss;
import org.polarbear.inss.exception.InvalidBirthNumberException;

import java.time.LocalDate;

public interface InssGenerator {

    Inss generateRandomInss();

    Inss generateInss(LocalDate birthDate, String birthNumber, Gender gender);

    Inss generateInss(LocalDate birthDate, int birthNumber, Gender gender) throws InvalidBirthNumberException;

}

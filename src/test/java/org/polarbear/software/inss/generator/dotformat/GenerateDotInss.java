package org.polarbear.software.inss.generator.dotformat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.polarbear.software.inss.InssGenerator;
import org.polarbear.software.inss.domain.Gender;
import org.polarbear.software.inss.domain.Inss;
import org.polarbear.software.inss.exception.InvalidBirthNumberException;
import org.polarbear.software.inss.generator.InssGeneratorImpl;
import org.polarbear.software.inss.generator.readable.InssFormat;
import org.polarbear.software.inss.util.RandomnessUtil;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenerateDotInss {
    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateRandomInss() {
        Inss result = underTest.generateOnlyDotsInss();
        assertNotNull(result);
    }

    @Test
    void generateInssWithPredefinedValuesMale() throws InvalidBirthNumberException {
        Inss result = underTest.generateInss(
                InssFormat.ONLY_DOTS,
                LocalDate.of(1999, 3, 27),
                "1",
                Gender.MALE
        );
        assertEquals("99.03.27.001.28", result.getInss());
    }

    @Test
    void generateInssWithPredefinedValuesFemale() throws InvalidBirthNumberException {
        Inss result = underTest.generateInss(
                InssFormat.ONLY_DOTS,
                LocalDate.of(2000, 5, 17),
                "124",
                Gender.FEMALE
        );
        assertEquals("00.05.17.124.12", result.getInss());
    }

    @Test
    void AssertionErrorIsThrown() {
        InvalidBirthNumberException error = Assertions.assertThrows(InvalidBirthNumberException.class, () -> underTest.generateInss(
                InssFormat.ONLY_DOTS,
                RandomnessUtil.generateRandomBirthDate(),
                "abc",
                RandomnessUtil.generateRandomGender()
        ));
        assertEquals("Birth Number is invalid, it should only contain numbers. Provided input: abc", error.getMessage());
    }

}
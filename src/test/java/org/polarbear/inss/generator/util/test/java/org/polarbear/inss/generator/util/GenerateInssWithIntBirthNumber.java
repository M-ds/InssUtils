package org.polarbear.inss.generator.util.test.java.org.polarbear.inss.generator.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.polarbear.inss.generator.util.main.java.org.polarbear.inss.InssGenerator;
import org.polarbear.inss.generator.util.main.java.org.polarbear.inss.domain.Gender;
import org.polarbear.inss.generator.util.main.java.org.polarbear.inss.domain.Inss;
import org.polarbear.inss.generator.util.main.java.org.polarbear.inss.exception.InvalidBirthNumberException;
import org.polarbear.inss.generator.util.main.java.org.polarbear.inss.generator.InssGeneratorImpl;
import org.polarbear.inss.generator.util.main.java.org.polarbear.inss.util.RandomnessUtil;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateInssWithIntBirthNumber {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void invalidBirthNumber() {
        Assertions.assertThrows(InvalidBirthNumberException.class, () -> underTest.generateInss(
                RandomnessUtil.generateRandomBirthDate(),
                999,
                Gender.FEMALE
        ));
    }

    @Test
    void validBirthNumber() throws InvalidBirthNumberException {
        Inss result = underTest.generateInss(
                LocalDate.of(1999, 3, 27),
                1,
                Gender.MALE
        );
        assertEquals("99.03.27-001.28", result.getInss());
    }

}

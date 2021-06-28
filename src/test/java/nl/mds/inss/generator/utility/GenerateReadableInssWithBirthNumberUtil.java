package nl.mds.inss.generator.utility;

import nl.mds.inss.InssGenerator;
import nl.mds.inss.domain.Gender;
import nl.mds.inss.domain.Inss;
import nl.mds.inss.generator.InssGeneratorImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateReadableInssWithBirthNumberUtil {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void validBirthNumber() {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(1999, 3, 27),
                1,
                Gender.MALE
        );
        assertEquals("99.03.27-001.28", result.getInss());
    }

    @Test
    void validFemaleInssWithBirthNumber() {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(2001, 7, 30),
                100,
                Gender.FEMALE
        );
        assertEquals("01.07.30-100.69", result.getInss());
    }

    @Test
    void validMaleInssWithBirthNumber() {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(1954, 2, 28),
                329,
                Gender.MALE
        );
        assertEquals("54.02.28-329.76", result.getInss());
    }
}

package org.polarbear.software.inss.generator.defaultformat;

import org.junit.jupiter.api.Test;
import org.polarbear.software.inss.InssGenerator;
import org.polarbear.software.inss.domain.Inss;
import org.polarbear.software.inss.generator.InssGeneratorImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenerateDefaultForGender {
    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateInssForMale() {
        Inss result = underTest.generateDefaultMaleInss(
                LocalDate.of(2013, 10, 7)
        );
        assertNotNull(result);
    }

    @Test
    void generateInssForFemale() {
        Inss result = underTest.generateDefaultFemaleInss(
                LocalDate.of(2013, 10, 7)
        );
        assertNotNull(result);
    }
}

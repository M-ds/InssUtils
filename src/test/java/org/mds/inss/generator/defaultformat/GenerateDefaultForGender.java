package org.mds.inss.generator.defaultformat;

import org.junit.jupiter.api.Test;
import org.mds.inss.InssGenerator;
import org.mds.inss.domain.Inss;
import org.mds.inss.generator.InssGeneratorImpl;

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

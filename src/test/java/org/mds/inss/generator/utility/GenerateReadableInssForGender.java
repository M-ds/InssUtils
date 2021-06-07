package org.mds.inss.generator.utility;

import org.junit.jupiter.api.Test;
import org.mds.inss.InssGenerator;
import org.mds.inss.domain.Inss;
import org.mds.inss.generator.InssGeneratorImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenerateReadableInssForGender {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateInssForMale() {
        Inss result = underTest.generateReadableMaleInss(
                LocalDate.of(2013, 10, 7)
        );
        assertNotNull(result);
    }

    @Test
    void generateInssForFemale() {
        Inss result = underTest.generateReadableFemaleInss(
                LocalDate.of(2013, 10, 7)
        );
        assertNotNull(result);
    }
}

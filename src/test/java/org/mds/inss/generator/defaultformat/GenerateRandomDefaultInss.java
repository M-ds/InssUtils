package org.mds.inss.generator.defaultformat;

import org.junit.jupiter.api.Test;
import org.mds.inss.InssGenerator;
import org.mds.inss.domain.Inss;
import org.mds.inss.generator.InssGeneratorImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateRandomDefaultInss {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateRandomInss() {
        Inss result = underTest.generateDefaultInss();
        assertNotNull(result);
    }

    @Test
    void generateDefaultFemaleInss() {
        Inss result = underTest.generateDefaultFemaleInss();
        assertNotNull(result);
    }

    @Test
    void generateDefaultMaleInss() {
        Inss result = underTest.generateDefaultMaleInss();
        assertNotNull(result);
    }

    @Test
    void generateOverOneHonderdInssNumbersAllShouldBeValid() {
        for (int i = 0; i < 10000; i++) {
            Inss result = underTest.generateDefaultInss();
            assertNotNull(result);
            assertTrue(result.hasValidLength());
        }
    }
}

package org.polarbear.software.inss.generator.readable;

import org.junit.jupiter.api.Test;
import org.polarbear.software.inss.InssGenerator;
import org.polarbear.software.inss.domain.Inss;
import org.polarbear.software.inss.generator.InssGeneratorImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenerateRandomReadableInss {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateRandomInss() {
        Inss result = underTest.generateReadableInss();
        assertNotNull(result);
    }

    @Test
    void generateReadableFemaleInss() {
        Inss result = underTest.generateReadableFemaleInss();
        assertNotNull(result);
    }

    @Test
    void generateReadableMaleInss() {
        Inss result = underTest.generateReadableMaleInss();
        assertNotNull(result);
    }

}
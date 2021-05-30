package org.polarbear.inss.generator.readable;

import org.junit.jupiter.api.Test;
import org.polarbear.inss.InssGenerator;
import org.polarbear.inss.domain.Inss;
import org.polarbear.inss.generator.InssGeneratorImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GenerateRandomInss {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateRandomInss() {
        Inss result = underTest.generateReadableInss();
        assertNotNull(result);
    }

}
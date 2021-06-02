package org.polarbear.software.inss.generator.defaultformat;

import org.junit.jupiter.api.Test;
import org.polarbear.software.inss.InssGenerator;
import org.polarbear.software.inss.domain.Inss;
import org.polarbear.software.inss.generator.InssGeneratorImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenerateDefaultInss {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateRandomInss() {
        Inss result = underTest.generateDefaultInss();
        assertNotNull(result);
    }
}

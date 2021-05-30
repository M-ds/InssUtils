package org.polarbear.inss.generator.util.test.java.org.polarbear.inss.generator.util;

import org.junit.jupiter.api.Test;
import org.polarbear.inss.generator.util.main.java.org.polarbear.inss.InssGenerator;
import org.polarbear.inss.generator.util.main.java.org.polarbear.inss.domain.Inss;
import org.polarbear.inss.generator.util.main.java.org.polarbear.inss.generator.InssGeneratorImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GenerateRandomInss {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateRandomInss() {
        Inss result = underTest.generateRandomInss();
        assertNotNull(result);
    }

}
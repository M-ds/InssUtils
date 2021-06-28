package nl.mds.inss.generator.utility;

import nl.mds.inss.InssGenerator;
import nl.mds.inss.domain.Inss;
import nl.mds.inss.generator.InssGeneratorImpl;
import org.junit.jupiter.api.Test;

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
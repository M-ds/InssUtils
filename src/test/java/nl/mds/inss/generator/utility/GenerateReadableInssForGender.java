package nl.mds.inss.generator.utility;

import nl.mds.inss.InssGenerator;
import nl.mds.inss.domain.Inss;
import nl.mds.inss.generator.InssGeneratorImpl;
import org.junit.jupiter.api.Test;

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

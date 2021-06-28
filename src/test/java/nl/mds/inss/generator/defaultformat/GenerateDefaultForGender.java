package nl.mds.inss.generator.defaultformat;

import nl.mds.inss.InssGenerator;
import nl.mds.inss.InssValidator;
import nl.mds.inss.domain.Inss;
import nl.mds.inss.generator.InssGeneratorImpl;
import org.junit.jupiter.api.Test;
import nl.mds.inss.exception.InvalidInssFormat;
import nl.mds.inss.validator.InssValidatorImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateDefaultForGender {
    private final InssGenerator underTest = new InssGeneratorImpl();
    private final InssValidator validator = new InssValidatorImpl();

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

    @Test
    void generateALotOfFemaleInssNumbers() throws InvalidInssFormat {
        for (int i = 0; i < 10000; i++) {
            Inss result = underTest.generateDefaultFemaleInss();
            assertNotNull(result);
            assertTrue(result.hasValidLength());
            assertTrue(validator.isFemaleInss(result.getInss()));
        }
    }

    @Test
    void generateALotOfMaleInssNumbers() throws InvalidInssFormat {
        for (int i = 0; i < 10000; i++) {
            Inss result = underTest.generateDefaultMaleInss();
            assertNotNull(result);
            assertTrue(result.hasValidLength());
            assertTrue(validator.isMaleInss(result.getInss()));
        }
    }
}

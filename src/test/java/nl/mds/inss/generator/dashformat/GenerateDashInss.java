package nl.mds.inss.generator.dashformat;

import nl.mds.inss.InssGenerator;
import nl.mds.inss.domain.Gender;
import nl.mds.inss.domain.Inss;
import nl.mds.inss.generator.InssGeneratorImpl;
import org.junit.jupiter.api.Test;
import nl.mds.inss.domain.InssFormat;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenerateDashInss {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateRandomInss() {
        Inss result = underTest.generateOnlyDashesInss();
        assertNotNull(result);
    }

    @Test
    void generateInssWithPredefinedValuesMale() {
        Inss result = underTest.generateInss(
                InssFormat.ONLY_DASHES,
                LocalDate.of(1999, 3, 27),
                1,
                Gender.MALE
        );
        assertEquals("99-03-27-001-28", result.getInss());
    }

    @Test
    void generateInssWithPredefinedValuesFemale() {
        Inss result = underTest.generateInss(
                InssFormat.ONLY_DASHES,
                LocalDate.of(2000, 5, 17),
                124,
                Gender.FEMALE
        );
        assertEquals("00-05-17-124-12", result.getInss());
    }

}

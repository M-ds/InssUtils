package nl.mds.inss.generator.dotformat;

import nl.mds.inss.InssGenerator;
import nl.mds.inss.domain.Gender;
import nl.mds.inss.domain.Inss;
import nl.mds.inss.exception.InvalidBirthNumberException;
import nl.mds.inss.generator.InssGeneratorImpl;
import nl.mds.inss.util.RandomnessUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import nl.mds.inss.domain.InssFormat;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenerateDotInss {
    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateRandomInss() {
        Inss result = underTest.generateOnlyDotsInss();
        assertNotNull(result);
    }

    @Test
    void generateInssWithPredefinedValuesMale() throws InvalidBirthNumberException {
        Inss result = underTest.generateInss(
                InssFormat.ONLY_DOTS,
                LocalDate.of(1999, 3, 27),
                "1",
                Gender.MALE
        );
        assertEquals("99.03.27.001.28", result.getInss());
    }

    @Test
    void generateInssWithPredefinedValuesFemale() throws InvalidBirthNumberException {
        Inss result = underTest.generateInss(
                InssFormat.ONLY_DOTS,
                LocalDate.of(2000, 5, 17),
                "124",
                Gender.FEMALE
        );
        assertEquals("00.05.17.124.12", result.getInss());
    }

    @Test
    void assertionErrorIsThrown() {
        InvalidBirthNumberException error = Assertions.assertThrows(InvalidBirthNumberException.class, () -> underTest.generateInss(
                InssFormat.ONLY_DOTS,
                RandomnessUtil.generateRandomBirthDate(),
                "abc",
                RandomnessUtil.generateRandomGender()
        ));
        assertEquals("Birth Number is invalid, it should only contain numbers. Provided input: abc", error.getMessage());
    }

}

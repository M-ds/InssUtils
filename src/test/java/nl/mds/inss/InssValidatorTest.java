package nl.mds.inss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import nl.mds.inss.exception.InvalidInssFormat;
import nl.mds.inss.validator.InssValidatorImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InssValidatorTest {

    private final InssValidator underTest = new InssValidatorImpl();
    private final String maleInss = "77021412321";
    private final String maleInssFormat = "88.10.13-033.40";
    private final String femaleInss = "94030704492";
    private final String femaleInssFormat = "98.04.14-124.87";

    @Test
    void isValidInss() throws InvalidInssFormat {
        boolean result = underTest.isValidInss(maleInss);
        assertTrue(result);
    }

    @Test
    void isValidInssWithFormat() throws InvalidInssFormat {
        boolean result = underTest.isValidInss(femaleInssFormat);
        assertTrue(result);
    }

    @Test
    void isInvalidInss() throws InvalidInssFormat {
        boolean result = underTest.isValidInss("12345678998");
        assertFalse(result);
    }

    @Test
    void isMaleInss() throws InvalidInssFormat {
        boolean result = underTest.isMaleInss(maleInss);
        assertTrue(result);
    }

    @Test
    void isMaleInssFormat() throws InvalidInssFormat {
        boolean result = underTest.isMaleInss(maleInssFormat);
        assertTrue(result);
    }

    @Test
    void isNotAMaleInss() throws InvalidInssFormat {
        boolean result = underTest.isMaleInss(femaleInss);
        assertFalse(result);
    }

    @Test
    void isNotAMaleInssFormat() throws InvalidInssFormat {
        boolean result = underTest.isMaleInss(femaleInssFormat);
        assertFalse(result);
    }

    @Test
    void isMaleInssException() {
        InvalidInssFormat error = Assertions.assertThrows(InvalidInssFormat.class, () -> underTest.isMaleInss("basear"));
        assertEquals("Please check your provided INSS number. The format is not correct.", error.getMessage());
    }

    @Test
    void isFemaleInss() throws InvalidInssFormat {
        boolean result = underTest.isFemaleInss(femaleInss);
        assertTrue(result);
    }

    @Test
    void isFemaleInssFormat() throws InvalidInssFormat {
        boolean result = underTest.isFemaleInss(femaleInssFormat);
        assertTrue(result);
    }

    @Test
    void isNotAFemaleInss() throws InvalidInssFormat {
        boolean result = underTest.isFemaleInss(maleInss);
        assertFalse(result);
    }

    @Test
    void isNotAFemaleInssFormat() throws InvalidInssFormat {
        boolean result = underTest.isFemaleInss(maleInssFormat);
        assertFalse(result);
    }

    @Test
    void extractBirthDate() throws InvalidInssFormat {
        LocalDate extractedDate = underTest.extractBirthDate(maleInss);
        assertEquals(LocalDate.of(1977,2,14), extractedDate);
    }

    @Test
    void extractBirthDateWithFormat() throws InvalidInssFormat {
        LocalDate extractedDate = underTest.extractBirthDate(femaleInssFormat);
        assertEquals(LocalDate.of(1998,4,14), extractedDate);
    }
}
package nl.mds.inss.domain;

import nl.mds.inss.validator.util.BirthDateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InssTest {

    private final Inss validInssWithoutFormat = new Inss("88052801063");
    private final Inss validInssWithOneBirthNumberWithoutFormat = new Inss("88052800963");
    private final Inss inssWithThreeBirthNumbersWithoutFormat = new Inss("03052812363");

    private final Inss validInssWithFormat = new Inss("75.05.28-010.81");
    private final Inss validInssWithOneBirthNumberFormat = new Inss("66.08.03-009.63");
    private final Inss inssWithThreeBirthNumbers = new Inss("88.09.28-345.63");

    private final BirthDateUtil birthDateUtil = new BirthDateUtil();

    @Test
    void getBirthDateWithoutFormat() {
        LocalDate extractedBirthDate = birthDateUtil.getBirthDate(validInssWithoutFormat);
        assertEquals(LocalDate.of(1988, 5, 28), extractedBirthDate);
    }

    @Test
    void getBirthDateAfter2000WithoutFormat() {
        LocalDate extractedBirthDate = birthDateUtil.getBirthDate(inssWithThreeBirthNumbersWithoutFormat);
        assertEquals(LocalDate.of(2003, 5, 28), extractedBirthDate);
    }

    @Test
    void getBirthNumberWithoutFormat() {
        int birthNumber = validInssWithoutFormat.extractBirthNumber();
        assertEquals(10, birthNumber);
    }

    @Test
    void getBirthNumberWithoutFormatAndOneBirthNumber() {
        int birthNumber = validInssWithOneBirthNumberWithoutFormat.extractBirthNumber();
        assertEquals(9, birthNumber);
    }

    @Test
    void inssWithThreeBirthNumbers() {
        int birthNumber = inssWithThreeBirthNumbers.extractBirthNumber();
        assertEquals(345, birthNumber);
    }

    @Test
    void getBirthNumberWithFormat() {
        int birthNumber = validInssWithFormat.extractBirthNumber();
        assertEquals(10, birthNumber);
    }

    @Test
    void getBirthNumberWithOneNumber() {
        int birthNumber = validInssWithOneBirthNumberFormat.extractBirthNumber();
        assertEquals(9, birthNumber);
    }

    @Test
    void inssWithThreeBirthNumbersWithoutFormat() {
        int birthNumber = inssWithThreeBirthNumbersWithoutFormat.extractBirthNumber();
        assertEquals(123, birthNumber);
    }
}

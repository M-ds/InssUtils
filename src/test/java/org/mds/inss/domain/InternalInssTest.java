package org.mds.inss.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InternalInssTest {

    private final InternalInss validInssWithoutFormat = new InternalInss("88052801063");
    private final InternalInss validInssWithOneBirthNumberWithoutFormat = new InternalInss("88052800963");
    private final InternalInss inssWithThreeBirthNumbersWithoutFormat = new InternalInss("03052812363");

    private final InternalInss validInssWithFormat = new InternalInss("75.05.28-010.81");
    private final InternalInss validInssWithOneBirthNumberFormat = new InternalInss("66.08.03-009.63");
    private final InternalInss inssWithThreeBirthNumbers = new InternalInss("88.09.28-345.63");
    private final InternalInss inssWithFormatAfter2000 = new InternalInss("01.11.07-069.42");

    @Test
    void getBirthDateWithoutFormat() {
        LocalDate extractedBirthDate = validInssWithoutFormat.getBirthDate();
        assertEquals(LocalDate.of(1988, 5, 28), extractedBirthDate);
    }

    @Test
    void getBirthDateWithFormat() {
        LocalDate extractedBirthDate = validInssWithFormat.getBirthDate();
        assertEquals(LocalDate.of(1975, 5, 28), extractedBirthDate);
    }

    @Test
    void getBirthDateAfter2000WithoutFormat() {
        LocalDate extractedBirthDate = inssWithThreeBirthNumbersWithoutFormat.getBirthDate();
        assertEquals(LocalDate.of(2003, 5, 28), extractedBirthDate);
    }

    @Test
    void getBirthDateAfter2000WithFormat() {
        LocalDate extractedBirthDate = inssWithFormatAfter2000.getBirthDate();
        assertEquals(LocalDate.of(2001, 11, 7), extractedBirthDate);
    }

    @Test
    void getBirthNumberWithoutFormat() {
        int birthNumber = validInssWithoutFormat.getBirthNumber();
        assertEquals(10, birthNumber);
    }

    @Test
    void getBirthNumberWithoutFormatAndOneBirthNumber() {
        int birthNumber = validInssWithOneBirthNumberWithoutFormat.getBirthNumber();
        assertEquals(9, birthNumber);
    }

    @Test
    void inssWithThreeBirthNumbers() {
        int birthNumber = inssWithThreeBirthNumbers.getBirthNumber();
        assertEquals(345, birthNumber);
    }

    @Test
    void getBirthNumberWithFormat() {
        int birthNumber = validInssWithFormat.getBirthNumber();
        assertEquals(10, birthNumber);
    }

    @Test
    void getBirthNumberWithOneNumber() {
        int birthNumber = validInssWithOneBirthNumberFormat.getBirthNumber();
        assertEquals(9, birthNumber);
    }

    @Test
    void inssWithThreeBirthNumbersWithoutFormat() {
        int birthNumber = inssWithThreeBirthNumbersWithoutFormat.getBirthNumber();
        assertEquals(123, birthNumber);
    }
}
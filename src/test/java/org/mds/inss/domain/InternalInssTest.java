package org.mds.inss.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternalInssTest {

    private final InternalInss validInssWithoutFormat = new InternalInss("88052801063");
    private final InternalInss validInssWithOneBirthNumberWithoutFormat = new InternalInss("88052800963");
    private final InternalInss inssWithThreeBirthNumbersWithoutFormat = new InternalInss("03052812363");

    private final InternalInss validInssWithFormat = new InternalInss("75-05-28.010-63");
    private final InternalInss validInssWithOneBirthNumberFormat = new InternalInss("66-08-03.009-63");
    private final InternalInss inssWithThreeBirthNumbers = new InternalInss("88-09-28.345-63");

    @Test
    void getBirthDate() {

    }

    @Test
    void getBirthDateAfter2000() {

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
package org.mds.inss.util;

import org.junit.jupiter.api.Test;
import org.mds.inss.domain.Gender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GeneralBirthNumberUtilTest {

    @Test
    void isInvalidBirthNumber() {
        String validBirthNumber = "123";
        boolean result = GeneralBirthNumberUtil.isInvalidBirthNumber(validBirthNumber);
        assertFalse(result);
    }

    @Test
    void invalidBirthNumber() {
        String invalidBirthNumber = "abc";
        boolean result = GeneralBirthNumberUtil.isInvalidBirthNumber(invalidBirthNumber);
        assertTrue(result);
    }

    @Test
    void isEven() {
        assertTrue(GeneralBirthNumberUtil.isEven(8));
    }

    @Test
    void isNotEven() {
        assertFalse(GeneralBirthNumberUtil.isEven(7));
    }

    @Test
    void isOdd() {
        assertTrue(GeneralBirthNumberUtil.isOdd(7));
    }

    @Test
    void isNotOdd() {
        assertFalse(GeneralBirthNumberUtil.isOdd(8));
    }

    @Test
    void isMaleGender() {
        assertEquals(Gender.MALE, GeneralBirthNumberUtil.determineGender(3));
    }

    @Test
    void isFemaleGender() {
        assertEquals(Gender.FEMALE, GeneralBirthNumberUtil.determineGender(2));
    }
}
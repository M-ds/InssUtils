package org.polarbear.software.inss.generator.defaultformat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.polarbear.software.inss.InssGenerator;
import org.polarbear.software.inss.domain.Gender;
import org.polarbear.software.inss.domain.Inss;
import org.polarbear.software.inss.exception.InvalidBirthNumberException;
import org.polarbear.software.inss.generator.InssGeneratorImpl;
import org.polarbear.software.inss.util.RandomnessUtil;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateDefaultInss {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateInssForMale() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(2013, 10, 7),
                "257",
                Gender.MALE
        );
        assertEquals("13100725702", result.getInss());
    }

    @Test
    void generateInssForPersonOnLeapDay() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(1944, 2, 29),
                "329",
                Gender.MALE
        );
        assertEquals("44022932930", result.getInss());
    }

    @Test
    void generateFemaleInssForPersonOnLeapDay() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(1948, 2, 29),
                "12",
                Gender.FEMALE
        );
        assertEquals("48022901243", result.getInss());
    }

    @Test
    void generateInssForFemale() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(1993, 2, 28),
                "147",
                Gender.FEMALE
        );
        assertEquals("93022814809", result.getInss());
    }

    @Test
    void generateInssForMaleHappyFlow() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(1975, 6, 30),
                "151",
                Gender.MALE
        );
        assertEquals("75063015181", result.getInss());
    }

    @Test
    void generateInssForFemaleWith9AtEnd() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(1969, 9, 1),
                "149",
                Gender.FEMALE
        );
        assertEquals("69090115071", result.getInss());
    }

    @Test
    void generatePredefinedInssAfter2000() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(2010, 3, 3),
                "33",
                Gender.MALE
        );
        assertEquals("10030303340", result.getInss());
    }

    @Test
    void generateInssWithCorrectedBirthNumber() {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(2010, 3, 3),
                33,
                Gender.FEMALE
        );
        assertEquals("10030303439", result.getInss());
    }

    @Test
    void generateInssWithBirthNumberOf999() {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(1935, 3, 3),
                999,
                Gender.MALE
        );
        assertEquals("35030399757", result.getInss());
    }

    @Test
    void generateInssForFemaleWithBirthNumber999() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(1988, 2, 28),
                "999",
                Gender.FEMALE
        );
        assertEquals("88022899824", result.getInss());
    }

    @Test
    void withBirtNumberConsistOnlyOneNumberMale() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(1988, 2, 28),
                "1",
                Gender.MALE
        );
        assertEquals("88022800151", result.getInss());
    }

    @Test
    void withBirtNumberConsistOnlyOneNumberFemale() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(1988, 2, 5),
                "5",
                Gender.FEMALE
        );
        assertEquals("88020500657", result.getInss());
    }

    @Test
    void withBirthNumberOf9() throws InvalidBirthNumberException {
        Inss result = underTest.generateDefaultInss(
                LocalDate.of(1988, 5, 28),
                "9",
                Gender.FEMALE
        );
        assertEquals("88052801063", result.getInss());
    }

    @Test
    void assertErrorIsThrown() {
        InvalidBirthNumberException error = Assertions.assertThrows(InvalidBirthNumberException.class, () -> underTest.generateDefaultInss(
                RandomnessUtil.generateRandomBirthDate(),
                "abc",
                RandomnessUtil.generateRandomGender()
        ));
        assertEquals("Birth Number is invalid, it should only contain numbers. Provided input: abc", error.getMessage());
    }

    @Test
    void invalidBirtNumberThrowsError() {
        InvalidBirthNumberException error = Assertions.assertThrows(InvalidBirthNumberException.class, () -> underTest.generateDefaultInss(
                RandomnessUtil.generateRandomBirthDate(),
                "123.0",
                RandomnessUtil.generateRandomGender()
        ));
        assertEquals("Birth Number is invalid, it should only contain numbers. Provided input: 123.0", error.getMessage());
    }
}

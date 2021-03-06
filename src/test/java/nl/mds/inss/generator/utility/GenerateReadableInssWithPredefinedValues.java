package nl.mds.inss.generator.utility;

import nl.mds.inss.InssGenerator;
import nl.mds.inss.domain.Gender;
import nl.mds.inss.domain.Inss;
import nl.mds.inss.exception.InvalidBirthNumberException;
import nl.mds.inss.generator.InssGeneratorImpl;
import nl.mds.inss.util.RandomnessUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateReadableInssWithPredefinedValues {

    private final InssGenerator underTest = new InssGeneratorImpl();

    @Test
    void generateInssForMale() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(2013, 10, 7),
                "257",
                Gender.MALE
        );
        assertEquals("13.10.07-257.02", result.getInss());
    }

    @Test
    void generateInssForFemale() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(1993, 2, 28),
                "147",
                Gender.FEMALE
        );
        assertEquals("93.02.28-148.09", result.getInss());
    }

    @Test
    void generateInssForMaleHappyFlow() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(1975, 6, 30),
                "151",
                Gender.MALE
        );
        assertEquals("75.06.30-151.81", result.getInss());
    }

    @Test
    void generateInssForFemaleWith9AtEnd() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(1969, 9, 1),
                "149",
                Gender.FEMALE
        );
        assertEquals("69.09.01-150.71", result.getInss());
    }

    @Test
    void generatePredefinedInssAfter2000() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(2010, 3, 3),
                "33",
                Gender.MALE
        );
        assertEquals("10.03.03-033.40", result.getInss());
    }

    @Test
    void generateInssWithCorrectedBirthNumber() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(2010, 3, 3),
                "33",
                Gender.FEMALE
        );
        assertEquals("10.03.03-034.39", result.getInss());
    }

    @Test
    void generateInssWithBirthNumberOf999() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(1935, 3, 3),
                "999",
                Gender.MALE
        );
        assertEquals("35.03.03-997.57", result.getInss());
    }

    @Test
    void generateInssForFemaleWithBirthNumber999() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(1988, 2, 28),
                "999",
                Gender.FEMALE
        );
        assertEquals("88.02.28-998.24", result.getInss());
    }

    @Test
    void withBirtNumberConsistOnlyOneNumberMale() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(1988, 2, 28),
                "1",
                Gender.MALE
        );
        assertEquals("88.02.28-001.51", result.getInss());
    }

    @Test
    void withBirtNumberConsistOnlyOneNumberFemale() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(1988, 2, 5),
                "5",
                Gender.FEMALE
        );
        assertEquals("88.02.05-006.57", result.getInss());
    }

    @Test
    void withBirthNumberOf9() throws InvalidBirthNumberException {
        Inss result = underTest.generateReadableInss(
                LocalDate.of(1988, 5, 28),
                "9",
                Gender.FEMALE
        );
        assertEquals("88.05.28-010.63", result.getInss());
    }

    @Test
    void assertErrorIsThrown() {
        InvalidBirthNumberException error = Assertions.assertThrows(InvalidBirthNumberException.class, () -> underTest.generateReadableInss(
                RandomnessUtil.generateRandomBirthDate(),
                "abc",
                RandomnessUtil.generateRandomGender()
        ));
        assertEquals("Birth Number is invalid, it should only contain numbers. Provided input: abc", error.getMessage());
    }

    @Test
    void invalidBirtNumberThrowsError() {
        InvalidBirthNumberException error = Assertions.assertThrows(InvalidBirthNumberException.class, () -> underTest.generateReadableInss(
                RandomnessUtil.generateRandomBirthDate(),
                "123.0",
                RandomnessUtil.generateRandomGender()
        ));
        assertEquals("Birth Number is invalid, it should only contain numbers. Provided input: 123.0", error.getMessage());
    }

}

package nl.mds.inss.util;

import nl.mds.inss.domain.Gender;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is responsible to generate random values. However, these random values do have some constraints.
 * These contains are the following
 * - Birthdate generation can not be in the future, and not be older than 100 years.
 * - Birth number generation can not be greater than 997.
 * - Gender generation can only be Male or Female
 */
public class RandomnessUtil {

    private static final Random random = new Random();
    private static final int LOWEST_VALUE = 1;

    public static LocalDate generateRandomBirthDate() {
        long minDay = LocalDate.of(1950, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public static String generateRandomBirthNumber() {
        return String.valueOf(random.nextInt(998 - LOWEST_VALUE) + LOWEST_VALUE);
    }

    public static Gender generateRandomGender() {
        return random.nextInt(2) == 0 ? Gender.FEMALE : Gender.MALE;
    }
}

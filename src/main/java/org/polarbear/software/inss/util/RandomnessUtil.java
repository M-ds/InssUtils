package org.polarbear.software.inss.util;

import org.polarbear.software.inss.domain.Gender;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is responsible to generate random values. However, these random values do have some constraints.
 * These contains are the following
 * - Birthdate generation can not be in the future, and not be older than 100 years.
 * - Birth number generation can not be greater than 999.
 * - Gender generation can only be Male or Female
 */
public class RandomnessUtil {

    private static final Random random = new Random();

    public static LocalDate generateRandomBirthDate() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2015, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        System.out.println(randomDate);
        return randomDate;
    }

    public static String generateRandomBirthNumber() {
        int number = random.nextInt(997);
        return String.valueOf(number);
    }

    public static Gender generateRandomGender() {
        int randomValue = random.nextInt(2);
        if (randomValue == 0) {
            return Gender.FEMALE;
        }
        return Gender.MALE;
    }
}

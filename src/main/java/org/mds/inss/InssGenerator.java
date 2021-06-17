package org.mds.inss;

import org.mds.inss.domain.Gender;
import org.mds.inss.domain.Inss;
import org.mds.inss.domain.InssFormat;
import org.mds.inss.exception.InvalidBirthNumberException;

import java.time.LocalDate;

/**
 * This is the main interface which can be used.
 * Different utility methods are defined and can be used to generate a INSS.
 * The INSS can be formatted in 4 different formats:
 * - Default - eg. 99032700128
 * - Readable - eg. 99.03.27-001.28
 * - Only Dots - eg. 99.03.27.001.28
 * - Only Dashes - eg. 99-03-27-001-28
 */
public interface InssGenerator {

    /**
     * Generates a random INSS number with random values.
     * Can be either a Male number or Female number.
     * INSS format "12070812312"
     *
     * @return INSS number without any formatting
     */
    Inss generateDefaultInss();

    /**
     * Generates a random INSS number with random values.
     * Can be either a Male number or Female number.
     * INSS format "12.07.08-123.12"
     *
     * @return INSS number with readable format
     */
    Inss generateReadableInss();

    /**
     * Generates a random INSS number with random values.
     * Can be either a Male number or Female number.
     * INSS format "12.07.08.123.12"
     *
     * @return INSS number with dotted format
     */
    Inss generateOnlyDotsInss();

    /**
     * Generates a random INSS number with random values.
     * Can be either a Male number or Female number.
     * INSS format "12-07-08-123-12"
     *
     * @return INSS number with dashes format
     */
    Inss generateOnlyDashesInss();

    /**
     * Generates a random INSS number with random values.
     * INSS format "12070812412"
     *
     * @return INSS number without any formatting
     */
    Inss generateDefaultFemaleInss();

    /**
     * Generates a random INSS number with random values.
     * INSS format "12.07.08-124.12"
     *
     * @return INSS number with readable format
     */
    Inss generateReadableFemaleInss();

    /**
     * Generates a random INSS number with random values.
     * INSS format "12070812312"
     *
     * @return INSS number without any formatting
     */
    Inss generateDefaultMaleInss();

    /**
     * Generates a random INSS number with random values.
     * INSS format "12.07.08-123.12"
     *
     * @return INSS number with readable format
     */
    Inss generateReadableMaleInss();

    /**
     * Generates an INSS number based on the parameters provided.
     * Inss number will have the format of "11071234511"
     *
     * @param birthDate   - BirthDate to be put in the Inss generation
     * @param birthNumber - birthNumber. Should only contain whole numbers, maximum value is 997. If this number is exceeded it will be automatically set to 97
     * @param gender      - Needed to perform a check for the validity of the birthNumber
     * @return Generated INSS number and based on the input values
     * @throws InvalidBirthNumberException - Is thrown when the birthNumber is not a whole value
     */
    Inss generateDefaultInss(LocalDate birthDate, String birthNumber, Gender gender) throws InvalidBirthNumberException;

    /**
     * Generates an Inss number based on parameters provided.
     * Inss number will have the format of "11071234511"
     *
     * @param birthDate   - BirthDate to be put in the Inss generation
     * @param birthNumber - birthNumber. If greater than 997 it will be set automatically to 997.
     * @param gender      - Needed to perform a check for the validity of the birthNumber.
     * @return Generated INSS number based on the input values
     */
    Inss generateDefaultInss(LocalDate birthDate, int birthNumber, Gender gender);

    /**
     * Generates an INSS number based on the parameters provided.
     * Inss number will have the format of "11.11.11-111.11"
     *
     * @param birthDate   - BirthDate to be put in the Inss generation
     * @param birthNumber - birthNumber. Should only contain whole numbers, maximum value is 997. If this number is exceeded it will be automatically set to 97
     * @param gender      - Needed to perform a check for the validity of the birthNumber
     * @return Generated INSS number and based on the input values
     * @throws InvalidBirthNumberException - Is thrown when the birthNumber is not a whole value
     */
    Inss generateReadableInss(LocalDate birthDate, String birthNumber, Gender gender) throws InvalidBirthNumberException;

    /**
     * Generates an Inss number based on parameters provided.
     * Inss number will have the format of "11.11.11-111.11"
     *
     * @param birthDate   - BirthDate to be put in the Inss generation
     * @param birthNumber - birthNumber. If greater than 997 it will be set automatically to 997.
     * @param gender      - Needed to perform a check for the validity of the birthNumber.
     * @return Generated INSS number based on the input values
     */
    Inss generateReadableInss(LocalDate birthDate, int birthNumber, Gender gender);

    /**
     * Generates an male inss based on the birthDate provided
     * Inss number will have the format of "11.11.11-111.11"
     *
     * @param birthDate - BirthDate to be put in the Inss generation
     * @return Generated male INSS number based on birth date
     */
    Inss generateReadableMaleInss(LocalDate birthDate);

    /**
     * Generates an male inss based on the birthDate provided
     * Inss number will have the format of "11071234511"
     *
     * @param birthDate - BirthDate to be put in the Inss generation
     * @return Generated male INSS number based on birth date
     */
    Inss generateDefaultMaleInss(LocalDate birthDate);

    /**
     * Generates an female inss based on the birthDate provided
     * Inss number will have the format of "11.11.11-111.11"
     *
     * @param birthDate - BirthDate to be put in the Inss generation
     * @return Generated Female INSS number based on birth date
     */
    Inss generateReadableFemaleInss(LocalDate birthDate);

    /**
     * Generates an female inss based on the birthDate provided
     * Inss number will have the format of "11071234511"
     *
     * @param birthDate - BirthDate to be put in the Inss generation
     * @return Generated female INSS number based on birth date
     */
    Inss generateDefaultFemaleInss(LocalDate birthDate);

    /**
     * Generates an INSS number bases on all the provided input variables.
     *
     * @param inssFormat  - Format can be either one of the following: DEFAULT, READABLE, ONLY_DOTS, ONLY_DASHES
     * @param birthDate   - BirthDate to be put in the Inss generation
     * @param birthNumber - birthNumber. Should only contain whole numbers, maximum value is 997. If this number is exceeded it will be automatically set to 97
     * @param gender      - Needed to perform a check for the validity of the birthNumber
     * @return generated INSS number bases on the input variables
     * @throws InvalidBirthNumberException - Is thrown when the birthNumber is not a whole number
     */
    Inss generateInss(InssFormat inssFormat, LocalDate birthDate, String birthNumber, Gender gender) throws InvalidBirthNumberException;

    /**
     * Generates an INSS number bases on all the provided input variables.
     *
     * @param inssFormat  - Format can be either one of the following: DEFAULT, READABLE, ONLY_DOTS, ONLY_DASHES
     * @param birthDate   - BirthDate to be put in the Inss generation
     * @param birthNumber - birthNumber. If greater than 997 it will be set automatically to 997.
     * @param gender      - Needed to perform a check for the validity of the birthNumber.
     * @return generated INSS number bases on the input variables
     */
    Inss generateInss(InssFormat inssFormat, LocalDate birthDate, int birthNumber, Gender gender);
}

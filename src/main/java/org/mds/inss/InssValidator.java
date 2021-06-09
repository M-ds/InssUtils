package org.mds.inss;

import org.mds.inss.exception.InvalidInssFormat;

import java.time.LocalDate;

public interface InssValidator {

    /**
     * Check if the input INSS is a valid inss number
     *
     * @param inss - String, can contain only the following formats: DEFAULT, READABLE
     * @return if INSS is valid or not
     * @throws InvalidInssFormat is thrown when the inss format is incorrect
     */
    boolean isValidInss(final String inss) throws InvalidInssFormat;

    /**
     * Check if the input INSS is a male INSS number.
     *
     * @param inss - String, can contain only the following formats: DEFAULT, READABLE
     * @return true if the INSS is a male INSS
     * @throws InvalidInssFormat is thrown when the inss format is incorrect
     */
    boolean isMaleInss(final String inss) throws InvalidInssFormat;

    /**
     * Check if the input INSS is a female INSS number.
     *
     * @param inss - String, can contain only the following formats: DEFAULT, READABLE
     * @return true if the INSS is a female INSS
     * @throws InvalidInssFormat is thrown when the inss format is incorrect
     */
    boolean isFemaleInss(final String inss) throws InvalidInssFormat;

    /**
     * Obtain the birthDate based on the input INSS.
     *
     * @param inss from which the birthdate should be extracted.
     * @return birthdate based on the input
     * @throws InvalidInssFormat is thrown when the inss format is incorrect
     */
    LocalDate extractBirthDate(final String inss) throws InvalidInssFormat;
}

package org.mds.inss;

import org.mds.inss.exception.InvalidInssFormat;

import java.time.LocalDate;

public interface InssValidator {

    boolean isValidInss(final String inss) throws InvalidInssFormat;

    boolean isMaleInss(final String inss) throws InvalidInssFormat;

    boolean isFemaleInss(final String inss) throws InvalidInssFormat;

    LocalDate extractBirthDate(final String inss);
}

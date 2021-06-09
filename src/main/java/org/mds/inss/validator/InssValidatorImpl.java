package org.mds.inss.validator;

import org.mds.inss.InssValidator;
import org.mds.inss.domain.InternalInss;
import org.mds.inss.exception.InvalidInssFormat;
import org.mds.inss.util.GeneralBirthNumberUtil;
import org.mds.inss.util.InssUtil;

import java.time.LocalDate;

public class InssValidatorImpl implements InssValidator {

    @Override
    public boolean isValidInss(String inss) throws InvalidInssFormat {
        InternalInss extractedInss = InssUtil.extractInss(inss);
        // Extract birthDate
        // Extract birthNumber
        // regenerate this inss
        // check if both are valid
        return false;
    }

    @Override
    public boolean isMaleInss(String inss) throws InvalidInssFormat {
        InternalInss extractedInss = InssUtil.extractInss(inss);
        return GeneralBirthNumberUtil.isOdd(extractedInss.getBirthNumber());
    }

    @Override
    public boolean isFemaleInss(String inss) throws InvalidInssFormat {
        InternalInss extractedInss = InssUtil.extractInss(inss);
        return GeneralBirthNumberUtil.isEven(extractedInss.getBirthNumber());
    }

    @Override
    public LocalDate extractBirthDate(String inss) throws InvalidInssFormat {
        InternalInss extractedInss = InssUtil.extractInss(inss);
        return extractedInss.getBirthDate();
    }
}

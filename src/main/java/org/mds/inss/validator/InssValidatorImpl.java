package org.mds.inss.validator;

import org.mds.inss.InssValidator;
import org.mds.inss.domain.Inss;
import org.mds.inss.exception.InvalidInssFormat;
import org.mds.inss.util.GeneralBirthNumberUtil;
import org.mds.inss.validator.util.BirthDateUtil;
import org.mds.inss.validator.util.InssUtil;

import java.time.LocalDate;

public class InssValidatorImpl implements InssValidator {

    private final BirthDateUtil birthDateUtil;
    private final InssUtil inssUtil;

    public InssValidatorImpl() {
        this.birthDateUtil = new BirthDateUtil();
        this.inssUtil = new InssUtil();
    }

    @Override
    public boolean isValidInss(String inss) throws InvalidInssFormat {
        return inssUtil.isValidInss(InssUtil.extractInss(inss));
    }

    @Override
    public boolean isMaleInss(String inss) throws InvalidInssFormat {
        Inss extractedInss = InssUtil.extractInss(inss);
        return GeneralBirthNumberUtil.isOdd(extractedInss.extractBirthNumber());
    }

    @Override
    public boolean isFemaleInss(String inss) throws InvalidInssFormat {
        return GeneralBirthNumberUtil.isEven(InssUtil.extractInss(inss).extractBirthNumber());
    }

    @Override
    public LocalDate extractBirthDate(String inss) throws InvalidInssFormat {
        return birthDateUtil.getBirthDate(InssUtil.extractInss(inss));
    }
}

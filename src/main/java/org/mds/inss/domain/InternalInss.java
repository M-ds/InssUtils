package org.mds.inss.domain;

import org.mds.inss.util.InssUtil;

import java.time.LocalDate;

public class InternalInss {

    private final Inss inss;

    public InternalInss(String inss) {
        this.inss = new Inss(inss);
    }

    //TODO: Have a look at the different formatting.. As we now always assume we have a format of READABLE or DEFAULT..
    public LocalDate getBirthDate() {
        boolean before2000 = InssUtil.isBirthDateBefore2000(inss);
        if (inssHasNoFormat() && before2000) {
            return InssUtil.extractBirthDateBefore2000WithoutFormat(inss);
        } else if (!inssHasNoFormat() && before2000) {
            return InssUtil.extractBirthDateBefore2000WithFormat(inss);
        } else if (inssHasNoFormat() && !before2000) {
            return InssUtil.extractBirthDateAfter2000WithoutFormat(inss);
        } else if (!inssHasNoFormat() && !before2000) {
            return InssUtil.extractBirthDateAfter2000WithFormat(inss);
        } else {
            System.out.println("Something went wrong while trying to obtain the birthdate....");
            return LocalDate.MIN;
        }
    }

    public int getBirthNumber() {
        return InssUtil.extractBirthNumber(inss);
    }

    private boolean inssHasNoFormat() {
        return inss.getInss().length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT;
    }

    public Inss getInss() {
        return inss;
    }

}

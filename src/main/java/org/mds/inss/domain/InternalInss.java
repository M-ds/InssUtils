package org.mds.inss.domain;

import java.time.LocalDate;

public class InternalInss {

    private final Inss inss;

    public InternalInss(String inss) {
        this.inss = new Inss(inss);
    }

    public LocalDate getBirthDate() {
        return LocalDate.now();
    }

    public int getBirthNumber() {
        if (inss.getInss().length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT) {
            String birthNumber = inss.getInss().substring(6, 9);
            return Integer.parseInt(birthNumber);
        }
        String birthNumber = inss.getInss().substring(9, 12);
        return Integer.parseInt(birthNumber);
    }

    public Inss getInss() {
        return inss;
    }

}

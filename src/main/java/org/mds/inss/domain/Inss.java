package org.mds.inss.domain;

public class Inss {
    private final String inss;

    public Inss(String inss) {
        this.inss = inss;
    }

    public String getInss() {
        return inss;
    }

    @Override
    public String toString() {
        return "Inss{ inss= " + inss + " }";
    }

    public boolean isValid() {
        return !inss.trim().isEmpty()
                && (inss.length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT || inss.length() == InssConstants.INSS_LENGTH_WITH_FORMAT);
    }
}

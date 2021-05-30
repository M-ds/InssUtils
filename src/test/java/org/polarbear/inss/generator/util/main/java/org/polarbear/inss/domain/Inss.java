package org.polarbear.inss.generator.util.main.java.org.polarbear.inss.domain;

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
}

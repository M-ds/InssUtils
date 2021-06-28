package nl.mds.inss.domain;

public class Inss {
    private final String inss;
    private final boolean hasNoFormat;

    public Inss(String inss) {
        this.inss = inss;
        this.hasNoFormat = inss.length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT;
    }

    public int extractBirthNumber() {
        if (inss.length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT) {
            return Integer.parseInt(inss.substring(6, 9));
        }
        return Integer.parseInt(inss.substring(9, 12));
    }

    public boolean hasValidLength() {
        return !inss.trim().isEmpty()
                && (inss.length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT || inss.length() == InssConstants.INSS_LENGTH_WITH_FORMAT);
    }

    public String getInss() {
        return inss;
    }

    @Override
    public String toString() {
        return "Inss{ inss= " + inss + " }";
    }

    public boolean hasNoFormat() {
        return hasNoFormat;
    }
}

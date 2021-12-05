package nl.mds.inss.bis;

import java.time.DateTimeException;
import java.time.LocalDate;

public class BisNumber {
    /**
     * This function checks whether an 11-digit number received from the
     * Crossroads bank for social security. Following documentation was read on
     * its site
     * <p/>
     * <p align="justify">
     * <a name="faq_5_2"><span class="title">Hoe zit de structuur van een
     * bisnummer in elkaar?<br>
     * <p/>
     * <br>
     * </span></a>
     * <p align="justify">
     * <span class="normaltxt">Het bisnummer (Kruispuntbanknummer) bestaat uit
     * 11 cijfers volgens een bepaalde structuur.</span>
     * <ul>
     * <li>eerste 6 cijfers = geboortedatum in omgekeerde volgorde: JJMMDD<br>
     * <br>
     * Het derde en vierde cijfer geven de geboortemaand aan, vermeerderd met 40
     * indien het geslacht van de persoon gekend is op het moment van toekenning
     * van het nummer, of vermeerderd met 20 indien het geslacht van de persoon
     * niet gekend is op het moment van toekenning van het nummer.<br>
     * <br>
     * <p/></li>
     * <li>volgende 3 cijfers = dagteller van de geboortes<br>
     * <ul>
     * <li>oneven voor het mannelijke geslacht</li>
     * <li>even voor het vrouwelijke geslacht<br>
     * <br>
     * <p/></li>
     * </ul>
     * </li>
     * <li>laatste 2 cijfers = <span lang="EN">check digit</span></li>
     * </ul>
     *
     * @param bisNumber the CPB number
     * @return true when it is valid
     */
//    private static boolean isValidBisNumber(Long bisNumber) {
//        if (bisNumber >= Math.pow(10, 11)) {
//            return false;
//        }
//
//        int day = getDay(bisNumber);
//        int month = getMonth(bisNumber);
//        int year = getYear(bisNumber);
//        return month == 0 || isValidDate(year, month, day);
//    }
//
//    static boolean isValidDate(int year, int month, int day) {
//        try {
//            LocalDate.of(year, month, day);
//        } catch (DateTimeException e) {
//            return false;
//        }
//        return true;
//    }
//
//    public boolean isInssABisNumber(String inss) {
//        return isValid(inss) && isBisNumber(inss);
//    }
//
//    private boolean isBisNumber(String parsedInss) {
//        try {
//            long inss = Long.parseLong(parsedInss);
//
//            long date = inss / 100000;
//            int month = (int) ((date / 100) % 100);
//
//            if (month > 12) {
//                month = month - 20;
//            } else {
//                return false;
//            }
//            if (month > 12) {
//                month = month - 20;
//            } else {
//                return true;
//            }
//            return month <= 12;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
}

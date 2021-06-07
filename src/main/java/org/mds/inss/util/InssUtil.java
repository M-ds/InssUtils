package org.mds.inss.util;

import org.mds.inss.domain.InssConstants;
import org.mds.inss.domain.InternalInss;
import org.mds.inss.exception.InvalidInssFormat;

public class InssUtil {

    public static InternalInss extractInss(final String inss) throws InvalidInssFormat {
        if (validLength(inss)) {
            return new InternalInss(inss);
        }
        throw new InvalidInssFormat("Please check your provided INSS number. The format is not correct.");
    }

    private static boolean validLength(final String inss) {
        return inss.length() == InssConstants.INSS_LENGTH_WITHOUT_FORMAT || inss.length() == InssConstants.INSS_LENGTH_WITH_FORMAT;
    }
}

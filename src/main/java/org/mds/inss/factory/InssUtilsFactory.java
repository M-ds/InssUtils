package org.mds.inss.factory;

import org.mds.inss.InssGenerator;
import org.mds.inss.InssValidator;
import org.mds.inss.generator.InssGeneratorImpl;
import org.mds.inss.validator.InssValidatorImpl;

/**
 * Factory to create instances of {@link InssGenerator} and {@link InssValidator}
 */
public final class InssUtilsFactory {
    private InssUtilsFactory() {
    }

    /**
     * Creates an instance of {@link InssGenerator}
     * @return new instance
     */
    public static InssGenerator createInssGenerator() {
        return new InssGeneratorImpl();
    }

    /**
     * Creates an instance of {@link InssValidator}
     * @return new instance
     */
    public static InssValidator createInssValidator() {
        return new InssValidatorImpl();
    }
}

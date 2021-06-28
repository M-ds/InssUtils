package nl.mds.inss.factory;

import nl.mds.inss.InssGenerator;
import nl.mds.inss.InssValidator;
import nl.mds.inss.generator.InssGeneratorImpl;
import nl.mds.inss.validator.InssValidatorImpl;

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

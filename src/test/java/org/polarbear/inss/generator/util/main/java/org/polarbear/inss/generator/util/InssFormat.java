package org.polarbear.inss.generator.util.main.java.org.polarbear.inss.generator.util;

public enum InssFormat {
    /** eg. 99032700128 */
    DEFAULT,
    /** eg. 99.03.27-001.28 */
    READABLE,
    /** eg. 99.03.27.001.28 */
    ONLY_DOTS,
    /** eg. 99-03-27-001-28 */
    ONLY_DASHES
}

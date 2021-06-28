package nl.mds.inss.domain;

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

# InssUtils

![CI](https://github.com/m-ds/InssUtils/actions/workflows/CI_pipeline.yml/badge.svg)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/2283fdc61e2e43afb1f451254f32140c)](https://www.codacy.com/gh/M-ds/InssUtils/dashboard?utm_source=github.com&utm_medium=referral&utm_content=M-ds/InssUtils&utm_campaign=Badge_Coverage)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/2283fdc61e2e43afb1f451254f32140c)](https://www.codacy.com/gh/M-ds/InssUtils/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=M-ds/InssUtils&amp;utm_campaign=Badge_Grade)

This repository has different utility classes to validate or generate a INSS number. This number is specifically
developed to be compliant with the Belgian standard. Some synonyms for INSS are

- INSZ (Idenficatienummer van de Sociale Zekerheid)
- NISS (No. d'identification de Sécurité Sociale)
- INSS (Identifizierungsnummer der Soziale Sicherheit)
- SSIN (Social Security Identification Number)
- INSS (Identification Number Social Security)

## How to use

In order to use the project just copy past one of the following to your pom.xml or build.gradle.

**Gradle**  
Gradle Groovy DSL

```Groovy
implementation 'io.github.m-ds.inssutils:InssUtils:1.0'
```

Gradle Kotlin DSL

```Kotlin
implementation("io.github.m-ds.inssutils:InssUtils:1.0")
```

**Maven**

```xml

<dependency>
    <groupId>io.github.m-ds.inssutils</groupId>
    <artifactId>InssUtils</artifactId>
    <version>1.0</version>
</dependency>
```

**Code Example**  
Once imported, one of the factory methods should be called upon. For instance to utilise the InssValidator:

```java
private final InssValidator inssValidator=InssUtilsFactory.createInssValidator();

public Inss generateInss() {
    return inssGenerator.generateDefaultInss();
}
```  

If you want to generate INSS numbers the generatorMethod should be called upon.

```java
private final InssGenerator inssGenerator=InssUtilsFactory.createInssGenerator();

public boolean isValidInss(String inss) throws InvalidInssFormat {
    return inssValidator.isValidInss(inss);
}
```

## Content of the project

### Generators

- GenerateRandomInss in different formats
  - eg. 99032700128 (Default format)
  - eg. 99.03.27-001.28 (Readable format)
  - eg. 99.03.27.001.28 (Only Dots format)
  - eg. 99-03-27-001-28 (Only Dashes format)
- generateInssForMale (Default- or Readable-format)
- generateInssForFemale (Default- or Readable-format)
- generateInss custom INSS with the following values:
  - provide your own LocalDate (**Necessary**)
  - birth number value (_Optional_)
  - Gender (_Optional_)
  
All the methods can be found in the **InssGenerator.java** interface.

### Validators

- Validate if inss is a valid inss
- Validate if inss is a male inss
- validate if inss is a female inss
- Extract birthdate (inss)

All methods can be found in the **InssValidator.java** interface.

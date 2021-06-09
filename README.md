# InssUtils

![CI](https://github.com/m-ds/InssUtils/actions/workflows/CI_pipeline.yml/badge.svg)
![Deployment](https://github.com/m-ds/InssUtils/actions/workflows/publish_pipeline.yml/badge.svg)
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

### Gradle

Gradle Groovy DSL

```
dependencies {
    implementation 'org.mds.inssutils:0.0.4'
}
```

```
plugins {
    id 'maven'
}
```

```
$ gradle install
```

Gradle Kotlin DSL

```
dependencies {
    implementation("org.mds.inssutils:0.0.4")
}
```

```
plugins {
    `maven`
}
```

```
$ gradle install
```

### Maven

First Step

```XML

<dependency>
    <groupId>org.mds</groupId>
    <artifactId>inssutils</artifactId>
    <version>0.0.4</version>
</dependency>
```

Second Step

```
mvn install
```

## Content of the project

### Generators

- GenerateRandomInss in different formats
    - eg. 99032700128  
    - eg. 99.03.27-001.28  
    - eg. 99.03.27.001.28  
    - eg. 99-03-27-001-28  
- generateInssForMale
- generateInssForFemale
- generateInss with your own values

### Validators

- Validate if inss is a valid inss
- Validate if inss is a male inss
- validate if inss is a female inss
- Extract birthdate (inss)

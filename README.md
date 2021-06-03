# InssUtils

![CI](https://github.com/m-ds/InssUtils/actions/workflows/CI_pipeline.yml/badge.svg)
![Deployment](https://github.com/m-ds/InssUtils/actions/workflows/publish_pipeline.yml/badge.svg)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/2283fdc61e2e43afb1f451254f32140c)](https://www.codacy.com/gh/M-ds/InssUtils/dashboard?utm_source=github.com&utm_medium=referral&utm_content=M-ds/InssUtils&utm_campaign=Badge_Coverage)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/2283fdc61e2e43afb1f451254f32140c)](https://www.codacy.com/gh/M-ds/InssUtils/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=M-ds/InssUtils&amp;utm_campaign=Badge_Grade)

This repository has different utility classes to validate or generate a INSS number. This number is specifically developed to be compient with the Belgian standard. Some synoyms for INSS are 
- INSZ (Idenficatienummver van de Sociale Zekerheid)
- NISS (No. d'identification de Sécurité Sociale)
- INSS (Identifizierungsnummer der Soziale Sicherheit)
- SSIN (Social Security Identification Number)
- INSS (Identification Number Social Security)

## Content of the project

### Validators

- Validate is valid inss
- Is male (inss)
- Is female (inss)
- Extract birthdate (inss)

### Generators

- Inss generation (random one)
- generateInss(date, gender)
- generateInss(date, gender, birthding)
- generateMaleInss(date)
- generateFemaleInss(date)

# SaludNacional-MVC

## Descripción

Proyecto académico en **Java** desarrollado en el marco de la
Especialización en Desarrollo de Software.\
Implementa la **arquitectura Modelo-Vista-Controlador (MVC)** para la
gestión de profesionales de salud a nivel nacional, aplicando principios
de programación orientada a objetos, encapsulación, pruebas y buenas
prácticas de ingeniería de software.

## Arquitectura

El sistema está diseñado siguiendo el patrón MVC con separación por
capas:

-   **Model**: Entidades de dominio (`ProfesionalSalud`).
-   **Repositorio**: Interfaz (`ProfesionalSaludRepository`) e
    implementación en memoria (`InMemoryProfesionalSaludRepository`).
-   **Servicio**: Lógica de negocio (`ProfesionalSaludService`).
-   **Controlador**: Orquesta la interacción
    (`ProfesionalSaludControlador`).
-   **Vista**: Interfaz de usuario por consola
    (`ProfesionalSaludVista`).
-   **App**: Punto de entrada del sistema (`App.java`).

## Requisitos

-   **Java JDK 17** o superior\
-   **IntelliJ IDEA** (recomendado) u otro IDE compatible\
-   Sistema operativo: Windows, Linux o macOS

## Ejecución

1.  Clonar el repositorio:

    ``` bash
    git clone https://github.com/ingenierocastroucc/SaludNacional-MVC.git
    ```

2.  Abrir el proyecto en IntelliJ IDEA.

3.  Ejecutar el archivo:

        src/App/App.java

4.  Interactuar con el menú de consola para registrar, listar, buscar,
    actualizar y eliminar profesionales de salud.

## Funcionalidades

-   Registrar profesional de salud
-   Listar todos los profesionales
-   Buscar por ID, Documento, Cargo, Especialidad y Nombre
-   Actualizar información de un profesional
-   Eliminar un profesional
-   Consultar estadísticas (total registrados)

## Diagramas UML

Se incluyen en el **Anexo C** del informe académico: - Diagrama de
Clases UML\
- Diagrama de Secuencia UML

## Autor

**Pedro Castro**\
Especialización en Desarrollo de Software\
Asignatura: Plataformas de Desarrollo de Software

## Licencia

Este proyecto se publica con fines académicos bajo licencia MIT.

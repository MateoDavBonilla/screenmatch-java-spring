# Screenmatch – Java & Spring Boot

Proyecto desarrollado en **Java** utilizando **Spring Boot**, enfocado en el consumo de APIs externas,
procesamiento de datos y buenas prácticas de organización por capas.

El proyecto parte de un curso de formación, pero fue **adaptado y extendido** para funcionar con
versiones modernas del ecosistema Java/Spring y para enfrentar problemas reales como
incompatibilidad de librerías y consumo de servicios externos.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven
- Jackson (JSON)
- API REST externa
- Git / GitHub

---

## 📦 Estructura del proyecto

src/main/java/com/aluracursos/screenmatch
├── model # Modelos y DTOs
├── service # Consumo de APIs y lógica de transformación
├── principal # Lógica principal y uso de Streams
└── ScreenmatchApplication.java


---

## ⚙️ Funcionalidades principales

- Consumo de una API externa de series
- Conversión de respuestas JSON a modelos Java
- Procesamiento de datos usando Java Streams
- Organización por capas (model / service / principal)
- Integración opcional con OpenAI para traducción de textos
- Manejo de errores en consumo de APIs externas

---

## 🤖 Integración con OpenAI (opcional)

El proyecto incluye una integración opcional con la API de OpenAI para traducción de textos.
Esta funcionalidad puede activarse mediante una variable de entorno.

```bash
OPENAI_API_KEY=sk-xxxxxxxx
Nota: El proyecto puede ejecutarse sin esta integración utilizando valores simulados,
lo que permite continuar el flujo sin depender de servicios externos.

🧠 Aprendizajes destacados
Adaptación de código legacy a APIs modernas

Manejo de incompatibilidades entre versiones de librerías

Consumo seguro de APIs REST

Separación de responsabilidades en un proyecto Java

Uso práctico de Streams en Java

▶️ Cómo ejecutar el proyecto
mvn clean install
mvn spring-boot:run
📌 Notas finales
Este repositorio forma parte de mi proceso de aprendizaje en Java y Spring Boot,
y refleja tanto el contenido del curso como las decisiones técnicas tomadas
para mantener el proyecto funcional y actualizado.


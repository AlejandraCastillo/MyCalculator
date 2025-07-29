# 🧮 MyCalculator

**Estado:** ⏳ En pausa

[English version](README.md)

## 🧩 ¿Qué es MyCalculator?

MyCalculator es una aplicación móvil de calculadora desarrollada con Jetpack Compose. Fue diseñada como un ejercicio de arquitectura, implementando el patrón MVVM (sin framework externo) y principios SOLID, con énfasis en una lógica modular y mantenible.

## 🧠 Sobre este proyecto

Al iniciar este proyecto me sentía perdida. Creía que mi lugar era en la programación móvil, pero me costaba mucho trabajo sentarme a estudiar y a programar. La idea de tener en mi portafolios los pequeños proyectos típicos no me parecía diferente. Pero había pasado ya por varias entrevistas fallidas y me convencí de que el problema era la ausencia de un portafolio. Me sentí presionada a tener al menos esos típicos proyectos pequeños, por lo que decidí empezar con una calculadora, porque poco era mejor que nada.

Sin embargo, inconscientemente escalé la complejidad del proyecto. Decidí que si iba a hacer solo una calculadora, de menos la haría bien. Quería aprender la biblioteca de MVVM, pero en aquel entonces siempre sentía que tenía el tiempo encima y aprender la biblioteca me tomaría tiempo que sentí que no tenía. Así que decidí aprender con este proyecto, pero para poder tener un avance significativo más rápido, decidí empezar implementándolo solo como una arquitectura e incluir la biblioteca cuando ya tuviera la primera versión estable.

Luego, mientras programaba, como una ocurrencia tardía, decidí implementar SOLID. También quise respetar la jerarquía de operaciones y aprender a hacer test unitarios para ver que todo saliera como debía. Al final el proyecto se complicó bastante y terminó por darme ansiedad que no avanzara rápido, por lo que lo dejé a medias.

Ahora, mirando en retrospectiva, me doy cuenta del gran valor que tenía este proyecto y que el tiempo que me tomó realizarlo no era un impedimento para mí, sino algo que me haría resaltar. También me doy cuenta de que esta experiencia me estaba advirtiendo que mi lugar era otro. Siempre me sentí más cómoda trabajando directamente con estructuras lógicas y arquitecturas que con bibliotecas de alto nivel, pero no me había dado cuenta de que existía otro camino.

Actualmente, me estoy adentrando al mundo de los sistemas de bajo nivel, por lo que no sé cuándo podré volver a completar este proyecto.

## 🧮 Funcionalidades esperadas

- Mostrar y actualizar los textos de dos paneles:
    - Principal: refleja lo que se está escribiendo en el momento
    - Secundario: muestra la operación completa hasta el momento
- Soportar botones con distintos tipos de comportamiento (números, operaciones, acciones)
- Procesar expresiones matemáticas respetando la jerarquía de operaciones
- Manejar errores como la división por cero
- Ser validable mediante pruebas unitarias en la lógica
- Servir como base modular para futuras extensiones (historial, modo científico, etc.)

## 🛠️ Tecnologías utilizadas

- **Lenguaje:** Kotlin
- **Framework UI:** Jetpack Compose
- **Arquitectura:** MVVM (manual), principios SOLID
- **SDK de Android:**
    - minSdk: 26
    - targetSdk: 34
    - compileSdk: 35
- **Temas y estilos personalizados:** Material 3
- **Dependencias:**
    - `androidx.core:core-ktx`
    - `androidx.lifecycle:lifecycle-runtime-ktx`
    - `androidx.activity:activity-compose`
    - `androidx.compose.*`
    - `androidx.material3`
    - `junit`, `espresso`, `compose.ui.test`

## ▶️ Cómo ejecutar el proyecto

### Requisitos del sistema

- Android Studio con soporte para Jetpack Compose
- SDK de Android 35 instalado
- Kotlin JVM target 11
- Gradle con acceso a plugins de Compose y Kotlin
### Clonar el proyecto

```bash
git clone https://github.com/AlejandraCastillo/MyCalculator.git
cd MyCalculator
```

Abrir el proyecto en Android Studio y ejecutar con un emulador o dispositivo físico con Android 8.0 (API 26) o superior.

## 🧪 Pruebas unitarias

El proyecto cuenta con un conjunto de pruebas unitarias para validar el comportamiento del `MathProcessor`, incluyendo:

- Agregado y validación de operadores válidos e inválidos
- Agregado de números y manejo de banderas de error
- Validación de operaciones básicas (suma, resta, multiplicación, división)
- Jerarquía de operaciones y evaluación combinada
- Manejo de errores como la división por cero
- Limpieza adecuada del estado tras errores

Estas pruebas están ubicadas en `test/com.example.mycalculator/domain.logic/BasicMathProcessorTest.kt`.

### Pruebas aún pendientes por implementar

Aunque varias funcionalidades están cubiertas, aún faltan algunos casos importantes por testear:

- ✅ Operaciones con múltiples operadores encadenados
- ✅ Manejo de decimales en operaciones combinadas
- ✅ Evaluación segura ante entrada vacía o incompleta
- ✅ Manejo de operadores inválidos o repetidos
- ✅ Robustez frente a espacios en blanco (si aplica)

Estas pruebas están contempladas para una futura fase de consolidación y extensión del proyecto.

## 🗂️ Estructura del proyecto

```
app/
├── manifests/                       # AndroidManifest.xml
│
├── kotlin+java/
│   └── com.example.mycalculator/   # Paquete raíz
│       ├── domain/                 # Capa de lógica de negocio
│       │   ├── interfaces/         # Interfaces ButtonOnClick y MathProcessor
│       │   ├── logic/              # Implementaciones de comportamiento de botones y procesador matemático
│       │   └── model/              # Modelos de datos: botones y tipos
│       │
│       ├── ui/                     # Capa de presentación
│       │   ├── components/         # Componentes visuales como botones y displays
│       │   ├── screens/            # Pantalla principal (CalculatorScreen)
│       │   └── theme/              # Definiciones de tema y estilo (Material 3)
│       │
│       └── MainActivity.kt         # Actividad principal
│
├── com.example.mycalculator (androidTest)/
│   └── (vacío por el momento)
│
├── com.example.mycalculator (test)/       # Pruebas unitarias
│   └── domain.logic/
│       ├── BasicMathProcessorTest.kt      # Tests del procesador matemático
│       └── ExampleUnitTest.kt             # Test por defecto generado
│
├── res/                            # Recursos
│   ├── drawable/                   # Recursos gráficos
│   ├── mipmap/                     # Íconos de la aplicación
│   ├── values/                     # Colores, cadenas, temas
│   └── xml/                        # Reglas de respaldo y extracción
│
└── build.gradle.kts               # Configuración del módulo
```

📝 **Nota:** La estructura mostrada corresponde a la vista _"Android"_ de Android Studio. Esta vista organiza el contenido por responsabilidades lógicas (como UI, lógica y tests), no por el sistema real de archivos. Para ver la estructura real, cambia a la vista _"Project"_ en el explorador.

## 🚀 Planes a futuro

Aunque este proyecto está en pausa, sigue siendo un punto de referencia para mi evolución como desarrolladora, y espero retomarlo con una nueva perspectiva en el futuro. Planeo terminar la primera versión estable y posteriormente irlo escalando poco a poco. Primero agregar un historial de operaciones, luego una calculadora científica, tal vez incluso una calculadora de divisas.
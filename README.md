# 🧮 MyCalculator

**Status:** ⏳ On hold

[Versión en español](README.es.md)

## 🧩 What is MyCalculator?

MyCalculator is a mobile calculator app developed with Jetpack Compose. It was designed as an architecture exercise, implementing the MVVM pattern (without external frameworks) and SOLID principles, with a strong emphasis on modular and maintainable logic.

## 🧠 About this project

When I started this project, I felt lost. I believed my place was in mobile development, but I struggled to sit down and actually study or code. Having the typical small portfolio projects didn't feel meaningful to me. However, after several failed interviews, I convinced myself that the lack of a portfolio was the issue. I felt pressured to at least build one of those standard small projects, so I decided to start with a calculator—because something was better than nothing.

However, I unconsciously kept increasing the complexity of the project. I decided that if I was going to build a calculator, I would at least do it right. I wanted to learn the MVVM library, but at the time I constantly felt like I was running out of time, and learning a new library felt like time I didn’t have. So I decided to learn by building this project, starting with a manual architecture first and adding the library later, once I had a stable version.

Then, almost as an afterthought, I decided to follow SOLID principles. I also wanted to respect operator precedence and learn how to write unit tests to ensure everything worked as expected. Eventually, the project became quite complex and slow to complete, which triggered anxiety and led me to leave it unfinished.

Now, in hindsight, I can see the true value of this project. The time it took was not a weakness—it was something that made it stand out. I also realize now that this experience was trying to tell me something: my place might lie elsewhere. I’ve always felt more comfortable working directly with logic structures and architecture than with high-level libraries, but I hadn’t realized there was another path.

Currently, I’m diving into the world of low-level systems programming, so I’m not sure when I’ll be able to complete this project.

## 🧮 Expected Features

- Display and update two panels:

    - Main: shows the current user input

    - Secondary: shows the full expression so far

- Support for different button types (numbers, operations, actions)

- Process mathematical expressions with operator precedence

- Handle errors (e.g., division by zero)

- Be testable through unit tests in the logic layer

- Serve as a modular base for future extensions (history, scientific mode, etc.)


## 🛠️ Technologies Used

- **Language:** Kotlin

- **UI Framework:** Jetpack Compose

- **Architecture:** Manual MVVM, SOLID principles

- **Android SDK:**

    - minSdk: 26

    - targetSdk: 34

    - compileSdk: 35

- **Theming:** Material 3

- **Dependencies:**

    - `androidx.core:core-ktx`

    - `androidx.lifecycle:lifecycle-runtime-ktx`

    - `androidx.activity:activity-compose`

    - `androidx.compose.*`

    - `androidx.material3`

    - `junit`, `espresso`, `compose.ui.test`


## ▶️ How to Run the Project

### System Requirements

- Android Studio with Jetpack Compose support

- Android SDK 35 installed

- Kotlin JVM target 11

- Gradle with Compose and Kotlin plugins


### Clone the Repository

```bash
git clone https://github.com/AlejandraCastillo/MyCalculator.git
cd MyCalculator
```

Open the project in Android Studio and run it on an emulator or physical device with Android 8.0 (API 26) or higher.

## 🧪 Unit Testing

The project includes a set of unit tests for the `MathProcessor` logic, covering:

- Addition and validation of valid/invalid operators

- Addition of numbers and error flag handling

- Basic operations (addition, subtraction, multiplication, division)

- Operator precedence and combined expression evaluation

- Error handling (e.g., division by zero)

- Proper state reset after errors


Tests are located at:  
`test/com.example.mycalculator/domain.logic/BasicMathProcessorTest.kt`

### Pending Tests

While several key behaviors are already covered, a few important test cases are still pending:

- ✅ Chained operations with multiple operators

- ✅ Handling decimals in mixed operations

- ✅ Safe evaluation with empty or incomplete input

- ✅ Handling invalid or repeated operators

- ✅ Resilience to whitespace input (if applicable)


These are planned for a future consolidation and extension phase of the project.

## 🗂️ Project Structure

```
app/
├── manifests/                       # AndroidManifest.xml
│
├── kotlin+java/
│   └── com.example.mycalculator/   # Root package
│       ├── domain/                 # Business logic layer
│       │   ├── interfaces/         # Interfaces: ButtonOnClick and MathProcessor
│       │   ├── logic/              # Button behavior and math processor implementations
│       │   └── model/              # Data models: buttons and types
│       │
│       ├── ui/                     # Presentation layer
│       │   ├── components/         # Visual components: buttons, displays
│       │   ├── screens/            # Main screen (CalculatorScreen)
│       │   └── theme/              # Styling and theming definitions (Material 3)
│       │
│       └── MainActivity.kt         # Main entry point
│
├── com.example.mycalculator (androidTest)/
│   └── (currently empty)
│
├── com.example.mycalculator (test)/       # Unit tests
│   └── domain.logic/
│       ├── BasicMathProcessorTest.kt      # Math logic tests
│       └── ExampleUnitTest.kt             # Default generated test
│
├── res/                            # Resources
│   ├── drawable/                   # Graphic assets
│   ├── mipmap/                     # App icons
│   ├── values/                     # Colors, strings, themes
│   └── xml/                        # Backup and extraction rules
│
└── build.gradle.kts               # Module configuration
```

📝 **Note:** This structure corresponds to Android Studio’s _“Android”_ view, which organizes content by logical responsibility (UI, logic, tests). For the actual file system layout, switch to the _“Project”_ view in the file explorer.

## 🚀 Future Plans

Although this project is currently on hold, it remains a key milestone in my journey as a developer. I plan to return to it with a new perspective:  
first to complete a stable version, and then to gradually expand its scope—adding an operation history, a scientific mode, and possibly even a currency converter.
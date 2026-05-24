# Network Call - Retrofit

A modern Android application demonstrating best practices for network communication, dependency injection, and UI development using Jetpack Compose.

## 🚀 Features

- **Network Integration**: Fetches real-time data from a remote API using Retrofit.
- **Modern UI**: Built entirely with Jetpack Compose and Material 3 design components.
- **Dependency Injection**: Utilizes Dagger Hilt for robust and scalable dependency management.
- **Image Loading**: Efficiently loads and caches remote images using Coil.
- **Clean Architecture**: Follows MVVM (Model-View-ViewModel) pattern for better separation of concerns and testability.
- **Type Safety**: Uses Kotlin Serialization/Gson for safe JSON parsing.

## 🛠 Tech Stack

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Dependency Injection**: [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Networking**: [Retrofit](https://square.github.io/retrofit/)
- **Image Loading**: [Coil](https://coil-kt.github.io/coil/)
- **Async Programming**: [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [Flow](https://kotlinlang.org/docs/flow.html)
- **Navigation**: [Jetpack Navigation Compose](https://developer.android.com/jetpack/compose/navigation)

## 📁 Project Structure

```text
com.sri.testnetworkcall
├── di          # Dependency Injection modules
├── network     # Retrofit API service definitions
├── ui          # Compose UI components and screens
│   └── screens
│       └── home
│           ├── model     # Data classes for API response
│           ├── view      # Compose screen implementations
│           └── viewmodel # ViewModels and Repositories
└── utils       # Helper classes and constants
```

## ⚙️ Getting Started

1. Clone the repository.
2. Open the project in Android Studio (Ladybug or newer recommended).
3. Sync project with Gradle files.
4. Run the app on an emulator or physical device.

## 📝 License

This project is licensed under the MIT License - see below for details:

```text
MIT License

Copyright (c) 2024 Sri

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

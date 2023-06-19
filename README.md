# Android Github User Search App

This repository hosts an Android application designed to interact with the GitHub Search API, retrieve data, parse the response, and exhibit the results in a user-friendly interface.

## Architecture & Libraries

The app employs the following architecture and libraries:

- Clean Architecture with Model-View-ViewModel (MVVM)
- Paging 3
- Kotlin Coroutines
- Retrofit
- Glide
- Hilt (for Dependency Injection)
- Navigation Architecture
- Mockito (for unit testing)
- Espresso (for UI testing)

### Clean Architecture with MVVM

The app uses Model-View-ViewModel (MVVM) architectural pattern combined with Clean Architecture principles. This approach enhances separation of concerns within the codebase by clearly outlining the logic of actions that can be performed.

### Paging 3

Paging 3 is utilized to load and display a large dataset efficiently, either from local storage or over the network. This library optimizes the usage of network resources and system memory.

### Kotlin Coroutines

Kotlin Coroutines provide a means of handling long-running tasks that might otherwise block the main thread. Conceptually akin to threads, coroutines run concurrently with the rest of the code but are not tied to any specific thread.

### Retrofit

Retrofit, a type-safe HTTP client for Android and Java by Square, is used for network requests. It provides a powerful framework for authenticating and interacting with APIs.

### Glide

Glide is an efficient image loading library for Android with a focus on smooth scrolling. It provides a simple API, excellent performance, and extensible resource decoding pipeline.

### Hilt

Hilt is a robust dependency injection library for Android, which reduces the boilerplate code associated with manual DI, ensuring better code readability and maintainability.

### Navigation Architecture

Android Jetpack's Navigation component is used to implement navigational patterns in the app, including simple button clicks to more complex patterns, like app bars and navigation drawers.

### Mockito

Mockito, a Java-based library, is used for crafting effective unit tests. It allows for creating mock interfaces with dummy functionalities, which can be employed in unit tests.

### Espresso

Espresso, a UI testing framework developed by Google, assists in writing UI tests for automation. It supports both black-box testing and granular component testing during the development cycle.

## Project Overview

This application aims to fetch user data from the Github API based on the input login credentials. Once the search button is activated, a paginated response list of search results is displayed, showcasing the user's login name, type, and avatar.

### Known Limitations

The API does not currently support the display of sorted user results based on login (username). Ideally, the API should accept a filter map to display sorted paginated data. Although a per-page sorting scheme is implemented, the ideal solution would be sorted data provision from the API itself.

## Code Organization

- **Base Package**: Includes `BaseAdapter`, `BaseActivity`, and `BaseFragment`.

- **DI Package**: Concentrates on providing common dependencies.

- **Features Package**: Houses the search feature, with its own DI and ViewModel scope, presentation layer (adapters, fragments, etc.), core business layer (use cases, repositories), and data layer (POJOs).

- **Manager Package**: Consists of managers like `String Resources Manager` and `Toast Managers`.

- **Utils Package**: Holds `Constants`, `Common Binding Adapters`, `Extensions`, `Functional Interfaces`, `Network Utils`, and `View Extensions`.

## Testing

- **Instrumentation Test**: Espresso-based tests with custom test runner added in Gradle for Hilt support.

- **Unit Test**: Mockito and JUnit are used to craft these tests.

## Useful References

- [Github Search API](https://docs.github.com/en/rest/search#search-users)
- [Clean Architecture](https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started)
- [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
- [Navigation Architecture](https://developer.android.com/guide/navigation?gclid=Cj0KCQjw39uYBhCLARIsAD_SzMQ68QSMYOBZ6CiC0X6MRuwaraiASCozhRg4LWNTJbWgcqmFySFQECgaAu7CEALw_wcB&gclsrc=aw.ds)
- [Retrofit](https://square.github.io/retrofit/)
- [Glide](https://bumptech.github.io/glide/)
- [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Espresso](https://developer.android.com/training/testing/espresso)
- [Mockito](https://site.mockito.org/)

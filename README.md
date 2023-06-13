Stock Market and KoeNaWin with Android Architecture Components
===========================================================


Stock Market => designed and built in the  architecture and modularization.
Stock Market app built entirely with Kotlin and Jetpack Compose that follows Android design and development best practices. It is currently in development. 
KoeNaWin => First ever burmese medidation app, the solution to bring the benefits of a regular meditation circle right to your fingers. 

This is the repository for the Now in Android app. It is a work in progress 🚧.

Introduction
-------------

### Feature
Stock Market displays companylist from https://alphavantage.co. Users can browse for all listing, can check each company's deatil.

### Architecture
The Stock Market follows the google official architecture guidance.
### Modularization
The Stock Market app has been fully modularized and followed google official modularization learning journey.
### Testing
It is a work in progress 🚧.

#### Device Tests
##### UI Tests
It is a work in progress 🚧.

##### Database Tests
It is a work in progress 🚧.

##### Local Unit Tests
It is a work in progress 🚧.

##### Repository Tests
It is a work in progress 🚧.

### Tech stacks 
* Minimum SDK level 21
* Kotlin based, Coroutines + Flow for asynchronous.
* Jetpack Compose : User Interface
* StateFlow: handle UI states upon the lifecycle changes.
* ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
* Room: Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
* Hilt: for dependency injection.
* Architecture
* MVVM Architecture (Model - View - ViewModel)
* Repository Pattern
* Retrofit2 : the REST APIs.
* Moshi: A modern JSON library for Kotlin and Java.
* Material-Components: Material design components.

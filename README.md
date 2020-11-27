# Square Rpo

An Android app consuming [Github Square repositories](https://api.github.com/orgs/square/repos) to display List of repositories. it has been built with Repository Pattern and MVVM pattern as Architecture Components.

Min Api Level : 21 [Supports Over 94% Devices ](https://developer.android.com/about/dashboards)

Build System : [Gradle](https://gradle.org/)

## Table of Contents

- [Architecture](#architecture)
- [Testing](#testing)
- [Libraries](#libraries)
- [Demo](#demo)

## Architecture

The Application is split into a three layer architecture:
- Presentation
- Domain
- Data

This provides better abstractions between framework implementations 
and the underlying business logic.It requires a number of classes to get 
things running but the pros outweigh the cons in terms of building an app 
that should scale.

The 3 layered architectural approach is majorly guided by clean architecture which provides
a clear separation of concerns with its Abstraction Principle.

#### Presentation

```app``` contains the UI files and handles binding of DI components from other modules.
Binding of data is facilitated by jetpacks data binding by serving data from the viewmodel
to the UI.The data being received is part of a viewstate class that has properties contained in the
relevant state.

#### Domain

The ```domain``` module contains domain model classes which represent the
data we will be handling across presentation and data layer.

Use cases(here Repositories) are also provided in the domain layer and orchestrate the flow 
of data from the data layer onto the presentation layer and a split into
modular pieces serving one particular purpose.

#### Data

- ```data-remote```

Handles data interacting with the network and is later serverd up to the database.

- ```data-local```

Handles data interacting with the database and is later serverd up to the presentation layer through
local object

## Testing

Each module has its own tests except for the ```domain``` module which is catered for since its
part of the behavior under test.

All server responses in the tests are served by mock web server by appending relative urls to
the localhost and the connected port as the base url.

In the ``data-remote`` module the responses are mocked using the mockwebserver and verified that they
are what we expect.

In the ```app``` module there are unit tests for the viewmodels and util classes 
and connected tests for the UI Screens.

The test instrumentation app uses modules that have been swaped with fakes for
the network module so as to run requests on localhost with mockwebserver,this removes flakiness 
compared to relying on actual data from the real server aspects such as internet connection or
network service might bring up issues.
 
## Libraries

Libraries used in the whole application are:

- [Jetpack](https://developer.android.com/jetpack)🚀
  - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data in a lifecycle conscious way and act as a channel between use cases and ui
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding) - support library that allows binding of UI components in layouts to data sources,binds images results to UI
  - [Navigation Component](https://developer.android.com/guide/navigation) - Handle application navigation.
  - [Room](https://developer.android.com/training/data-storage/room) - Provides abstraction layer over SQLite
- [Retrofit](https://square.github.io/retrofit/) - type safe http client and supports coroutines out of the box.
- [GSON](https://github.com/google/gson) - JSON Parser,used to parse requests on the data layer for Entities.
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logs HTTP request and response data.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines,provides `runBlocking` coroutine builder used in tests
- [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) - web server for testing HTTP clients ,verify requests and responses on the star wars api with the retrofit client.
- [Material Design](https://material.io/develop/android/docs/getting-started/) - build awesome beautiful UIs.🔥🔥
- [Dagger Hilt](https://dagger.dev/hilt/) - Hilt provides a standard way to incorporate Dagger dependency injection into an Android application.
- [Robolectric](http://robolectric.org/) - Unit test on android framework.

## Demo


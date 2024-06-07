# GOTO Amsterdam 2024

## Using Ktor 3.0 with all the Shiny Things


This repository contains a number of independent Kotlin / Gradle projects. These are used as samples within the [GOTO Amsterdam 2024](https://gotoams.nl/2024) talk entitled [Using Ktor 3.0 with all the Shiny Things](https://gotoams.nl/2024/sessions/3231/using-ktor-3-0-with-all-the-shiny-things). All the projects are based around the idea of a microservice that provides endopoints for querying Stack Exchange.

The projects are as follows:

* **kotlin-conf-notebooks** - Provides a notebook which uses the built-in support for Ktor Client in [Kotlin Notebook](https://blog.jetbrains.com/kotlin/2023/07/introducing-kotlin-notebook/).
* **kotlin-conf-testing** - Shows how to use the built-in Ktor testing framework to validate your services and mock out dependencies.
* **kotlin-conf-koin** - Covers integrating Ktor with the Koin library, for the purpose of injecting dependencies.
* **kotlin-conf-websockets** - Demonstrates how to configure support for WebSockets in Ktor microservices, allowing you to incrementally stream data down to a client.
* **kotlin-conf-graphql** - Uses GraphQL, instead of REST, for querying and modifying data.
* **kmp-ktor-retries** - Contains a Compose Multiplatform client, which uses the retry functionality in Ktor Client to repeatedly attempt to access a service.
* **ktor-native-server** - Demonstrates how to configure and build a Ktor microservice using the Kotlin Native compiler.

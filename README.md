<p align="center">
	<a href="https://www.tcgdex.net">
		<img src="https://www.tcgdex.net/assets/og.png" width="90%" alt="TCGdex Main Image">
	</a>
</p>
<p align="center">
	<a href="https://jitpack.io/#net.tcgdex/java-sdk">
		<img src="https://img.shields.io/jitpack/v/github/tcgdex/java-sdk?style=flat-square" alt="Package Version">
	</a>
	<!--<a href="http://npmjs.com/@tcgdex/sdk">
		<img src="https://img.shields.io/npm/dm/@tcgdex/sdk?style=flat-square" alt="NPM Downloads">
	</a>
	<a href="https://app.codecov.io/gh/tcgdex/javascript-sdk/">
		<img src="https://img.shields.io/codecov/c/github/tcgdex/javascript-sdk?style=flat-square&token=FR4BI94N4Q" alt="coverage">
	</a>-->
		<a href="https://github.com/tcgdex/java-sdk/stargazers">
		<img src="https://img.shields.io/github/stars/tcgdex/java-sdk?style=flat-square" alt="Github stars">
	</a>
	<a href="https://github.com/tcgdex/javascript-sdk/actions/workflows/build.yml">
		<img src="https://img.shields.io/github/workflow/status/tcgdex/javascript-sdk/Build%20&%20Test?style=flat-square" alt="the TCGdex JAvascript SDK is released under the MIT license." />
	</a>
	<a href="https://discord.gg/NehYTAhsZE">
		<img src="https://img.shields.io/discord/857231041261076491?color=%235865F2&label=Discord&style=flat-square" alt="Discord Link">
	</a>
</p>

# TCGdex Kotlin/Java SDK

The Kotlin/Java SDK provides a convenient access with the Open Source TCGdex API.

The SDK is available both for Kotlin use and Java.

## Documentation

_The full API/SDK documentation in progress at [API Documentation - TCGdex](https://www.tcgdex.dev)_

### Getting Started

#### How To install

**Gradle**

1. add the repository in you `build.gradle`

```gradle
repositories {
  ...
  maven { url 'https://jitpack.io' }
}
```

2. Add the dependency in your `build.gradle`

```gradle
dependencies {
        implementation 'net.tcgdex:java-sdk:{Version}'
}
```
  
**Maven**

1. add the repository in your `pom.xml`

```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```

2. Add the depedency in your `pom.xml`

```xml
<dependency>
    <groupId>net.tcgdex</groupId>
    <artifactId>java-sdk</artifactId>
    <version>{Version}</version>
</dependency>
```

#### Usage

_Note: a complete documentation is available at [TCGdex.dev](https://www.tcgdex.dev)_

##### Kotlin

**Example: Fetch a Card**

```kotlin
// Import the SDK
import net.tcgdex.sdk.TCGdex

// Init the library with the language code (see the API REST documentation for the list)
val api = TCGdex("en")

// returns you a Card Class with every informations filled!
val card = api.fetchCard("swsh1-1")
```

**Other Functions**

```kotlin
api.fetchCard("swsh3-136")
api.fetchCard("swsh3", "136")
api.fetchSet("swsh3")
api.fetchSets()
api.fetchSerie("swsh")
api.fetchSeries()
api.fetchTypes()
api.fetchType("Colorless")
api.fetchRetreats()
api.fetchRetreat("1")
api.fetchRarities()
api.fetchRarity("Uncommon")
api.fetchIllustrators()
api.fetchIllustrator("tetsuya koizumi")
api.fetchHPs()
api.fetchHP("110")
api.fetchCategories()
api.fetchCategory("Pokemon")
api.fetchDexIds()
api.fetchDexId("162")
api.fetchEnergyTypes()
api.fetchEnergyType("Special")
api.fetchRegulationMarks()
api.fetchRegulationMark("D")
api.fetchStages()
api.fetchStage("Basic")
api.fetchSuffixes()
api.fetchSuffix("EX")
api.fetchTrainerTypes()
api.fetchTrainerType("Tool")
api.fetchVariants()
api.fetchVariant("holo")
```

## Contributing

See [CONTRIBUTING.md](https://github.com/tcgdex/javascript-sdk/blob/master/CONTRIBUTING.md)

TL::DR

- Fork

- Commit your changes

- Pull Request on this Repository

## License

This project is licensed under the MIT License. A copy of the license is available at [LICENSE.md](https://github.com/tcgdex/javascript-sdk/blob/master/LICENSE.md)

This is based on the [Maxopoly](https://github.com/Maxopoly) TCGdex Java SDK

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "2.1.20"
    id("org.jetbrains.dokka") version "2.0.0"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`

    // maven publishing
    id("com.vanniktech.maven.publish") version "0.29.0"
}

// from: https://discuss.kotlinlang.org/t/use-git-hash-as-version-number-in-build-gradle-kts/19818/8
fun String.runCommand(
    workingDir: File = File("."),
    timeoutAmount: Long = 60,
    timeoutUnit: TimeUnit = TimeUnit.SECONDS
): String = ProcessBuilder(split("\\s(?=(?:[^'\"`]*(['\"`])[^'\"`]*\\1)*[^'\"`]*$)".toRegex()))
    .directory(workingDir)
    .redirectOutput(ProcessBuilder.Redirect.PIPE)
    .redirectError(ProcessBuilder.Redirect.PIPE)
    .start()
    .apply { waitFor(timeoutAmount, timeoutUnit) }
    .run {
        val error = errorStream.bufferedReader().readText().trim()
        if (error.isNotEmpty()) {
            return@run ""
        }
        inputStream.bufferedReader().readText().trim()
    }

val branch = "git rev-parse --abbrev-ref HEAD".runCommand(workingDir = rootDir)
val tag = "git tag -l --points-at HEAD".runCommand(workingDir = rootDir)
val commitId = "git rev-parse HEAD".runCommand(workingDir = rootDir)

val finalVersion = System.getenv("version") ?: tag.drop(1) ?: "2.0.0"
val finalGroup = System.getenv("group") ?: "net.tcgdex"
val artifact = System.getenv("artifact") ?: "sdk"

group = finalGroup
version = finalVersion

repositories {
    mavenCentral()
}

dependencies {

    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))
    // Gson
    implementation("com.google.code.gson:gson:2.13.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_1_8)
    }
}

java {
    withJavadocJar()
    withSourcesJar()

    targetCompatibility = JavaVersion.VERSION_1_8
}

// Javadocs
// val javadocJar = tasks.named<Jar>("javadocJar") {
//     from(tasks.named("dokkaJavadoc"))
// }


mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(finalGroup, artifact, finalVersion)

    pom {
        name.set("TCGdex SDK")
        description.set("Communicate with the Open Source TCGdex API in Kotlin/Java using the SDK")
        url.set("https://github.com/tcgdex/java-sdk")
        inceptionYear.set("2022")

        licenses {
            license {
                name.set("MIT License")
                url.set("https://github.com/tcgdex/java-sdk/blob/master/LICENSE.md")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("avior")
                name.set("Avior")
                email.set("contact@dze.io")
                url.set("https://github.com/Aviortheking")
            }
        }

        scm {
            url.set("https://github.com/tcgdex/java-sdk")
            connection.set("scm:git:git://github.com/tcgdex/java-sdk.git")
            developerConnection.set("scm:git:ssh://git@github.com/tcgdex/java-sdk.git")
        }

        issueManagement {
            system.set("GitHub Issues")
            url.set("https://github.com/tcgdex/java-sdk/issues")
        }
    }
}

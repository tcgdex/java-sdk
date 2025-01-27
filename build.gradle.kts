import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "2.1.10"
    id("org.jetbrains.dokka") version "2.0.0"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    `maven-publish`
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
    implementation("com.google.code.gson:gson:2.11.0")

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
val javadocJar = tasks.named<Jar>("javadocJar") {
    from(tasks.named("dokkaJavadoc"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = finalGroup
            artifactId = artifact
            version = finalVersion

            from(components["java"])

            pom {
                name.set("TCGdex SDK")
                description.set("Communicate with the Open Source TCGdex API in Kotlin/Java using the SDK")
                url.set("https://github.com/tcgdex/java-sdk")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/tcgdex/java-sdk/blob/master/LICENSE.txt")
                    }
                }
                developers {
                    developer {
                        id.set("avior")
                        name.set("Avior")
                        email.set("contact@tcgdex.net")
                    }
                }
                scm {
                    connection.set("scm:git@github.com:tcgdex/java-sdk.git")
                    url.set("https://github.com/tcgdex/java-sdk")
                }
            }
        }
    }
    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/tcgdex/java-sdk")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}

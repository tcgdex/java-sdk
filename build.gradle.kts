plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "1.6.20"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    `maven-publish`
}

val artifact = "sdk"
group = "net.tcgdex"
version = "2.0.1"

repositories {
    mavenCentral()
}

dependencies {

    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))
    // Gson
    implementation("com.google.code.gson:gson:2.9.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}


tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            // groupId = group
            artifactId = artifact
            // version = ver

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
}

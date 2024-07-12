plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    //implementation 'io.arrow-kt:arrow-fx-coroutines'
    implementation("io.arrow-kt:arrow-core:1.2.4")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.2.4"  )

    implementation("org.jetbrains.kotlin",  "kotlin-reflect", "1.2.0")
    implementation("com.typesafe.akka",  "akka-actor_2.11", "2.5.11")
    implementation("com.typesafe.akka",  "akka-slf4j_2.11", "2.5.11")
    implementation("com.typesafe.akka",  "akka-stream_2.11","2.5.11")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
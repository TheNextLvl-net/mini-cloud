plugins {
    id("java")
}

group = rootProject.group
version = rootProject.version

java {
    targetCompatibility = JavaVersion.VERSION_19
    sourceCompatibility = JavaVersion.VERSION_19
}

repositories {
    mavenCentral()
    maven("https://repo.thenextlvl.net/releases")
}

dependencies {
    compileOnly("com.google.code.gson:gson:2.10.1")
    compileOnly("org.projectlombok:lombok:1.18.26")
    compileOnly("org.jetbrains:annotations:24.0.0")
    compileOnly("net.thenextlvl.core:annotations:2.0.1")

    annotationProcessor("org.projectlombok:lombok:1.18.26")
}

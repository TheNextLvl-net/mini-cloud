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
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.26")
    compileOnly("net.thenextlvl.core:annotations:1.0.0")
    compileOnly("com.velocitypowered:velocity-api:3.1.1")

    annotationProcessor("org.projectlombok:lombok:1.18.26")
    annotationProcessor("com.velocitypowered:velocity-api:3.1.1")

    implementation(project(":api"))
}
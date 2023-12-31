plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("net.minecrell.plugin-yml.paper") version "0.6.0"
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
    implementation(project(":api"))
    implementation(project(":client"))

    implementation("net.thenextlvl.core:files:1.0.1")

    compileOnly("io.papermc.paper:paper-api:1.20.2-R0.1-SNAPSHOT")
}

tasks.shadowJar {
    minimize()
}

paper {
    name = "MiniCloud"
    author = "NonSwag"
    website = "https://thenextlvl.net"
    main = "minicloud.paper.PaperCloudProvider"
    apiVersion = "1.19"
    foliaSupported = true
}
plugins {
    id("java")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}
dependencies {
    implementation("org.jetbrains:annotations:24.0.0")
}

plugins {
    id("java")
    id("org.openapi.generator") version "6.6.0"
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
    implementation(project(":api"))
    implementation("org.projectlombok:lombok:1.18.26")
    implementation("org.jetbrains:annotations:24.0.0")
    compileOnly("net.thenextlvl.core:annotations:1.0.0")
}

tasks.openApiGenerate {
    generatorName.set("java")
    library.set("okhttp-gson")
    inputSpec.set("$rootDir/api.yaml")
    outputDir.set("$buildDir/generated-client")
    apiPackage.set("minicloud.client.api")
    invokerPackage.set("minicloud.client.invoker")
    modelPackage.set("minicloud.client.model")
    skipValidateSpec.set(true)
    logToStderr.set(true)
    generateAliasAsModel.set(false)
    enablePostProcessFile.set(true)
    configOptions.set(mapOf(
            "outputAsLibrary" to "true",
            "asyncNative" to "true",
            "supportStreaming" to "true"
    ))
}
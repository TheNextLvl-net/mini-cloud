plugins {
    id("java")
    id("org.hidetake.swagger.generator") version "2.19.2"
}

group = "net.thenextlvl.cloud"
version = "1.0.0"

java {
    targetCompatibility = JavaVersion.VERSION_19
    sourceCompatibility = JavaVersion.VERSION_19
}

repositories {
    mavenCentral()
}

dependencies {
    swaggerCodegen("org.openapitools:openapi-generator-cli:3.3.4")
}

swaggerSources {
    register("mini-cloud") {
        setInputFile(file("client/mini-cloud.yaml"))
        code.language = "spring"
        code.outputDir = file("client")
        code.configFile = file("client/config.json")
        code.wipeOutputDir = false
        code.dependsOn(validation)
    }
}
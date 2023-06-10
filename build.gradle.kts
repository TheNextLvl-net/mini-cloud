plugins {
    id("java")
    id("org.hidetake.swagger.generator") version "2.19.2"
}

group = "net.thenextlvl.cloud"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    swaggerCodegen("org.openapitools:openapi-generator-cli:3.3.4")
}

swaggerSources {
    register("easy-cloud") {
        setInputFile(file("api.yaml"))
        code.language = "spring"
        code.wipeOutputDir = true
        code.outputDir = file("swagger")
    }
}
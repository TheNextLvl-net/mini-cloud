plugins {
    id("java")
    id("org.hidetake.swagger.generator") version "2.19.2"
}

group = rootProject.group
version = rootProject.version

java {
    targetCompatibility = JavaVersion.VERSION_19
    sourceCompatibility = JavaVersion.VERSION_19
}

repositories {
    mavenCentral()
}

dependencies {
    swaggerCodegen("org.openapitools:openapi-generator-cli:6.6.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")

    implementation("org.springframework.boot:spring-boot-starter-validation:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    implementation("org.springframework.data:spring-data-commons:3.1.0")

    implementation("org.springdoc:springdoc-openapi-ui:1.7.0")

    implementation("io.springfox:springfox-swagger-ui:3.0.0")
    implementation("io.springfox:springfox-swagger2:3.0.0")

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")

    implementation("org.openapitools:jackson-databind-nullable:0.2.6")

    implementation("com.google.code.findbugs:jsr305:3.0.2")

    implementation("javax.validation:validation-api:2.0.1.Final")
}

swaggerSources {
    register("mini-cloud") {
        setInputFile(file("api.yaml"))
        code.language = "spring"
        code.outputDir = file(".")
        code.configFile = file("config.json")
        code.wipeOutputDir = false
        code.dependsOn("build")
    }
}
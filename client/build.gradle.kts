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
}

dependencies {
    compileOnly("org.springframework.boot:spring-boot-starter-web:2.0.1.RELEASE")
    compileOnly("io.springfox:springfox-swagger2:2.8.0")
    compileOnly("io.springfox:springfox-swagger-ui:2.8.0")
    compileOnly("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.0.1.RELEASE")
    compileOnly("javax.validation:validation-api:2.0.1.Final")
}
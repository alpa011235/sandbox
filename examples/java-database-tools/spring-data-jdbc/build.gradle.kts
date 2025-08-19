dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation(project(":examples:java-database-tools-starter"))

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    compileOnly(libs.mapstruct)
    annotationProcessor(libs.mapstruct.processor)
}

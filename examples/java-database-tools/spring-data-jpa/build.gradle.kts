dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation(project(":examples:java-database-tools-starter"))
    implementation(libs.datasource.proxy)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    compileOnly(libs.mapstruct)
    annotationProcessor(libs.mapstruct.processor)
}

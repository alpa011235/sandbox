dependencies {
    implementation(project(":examples:java-database-tools-starter"))
    implementation(files("libs/log4jdbc4-1.3.jar"))

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    compileOnly(libs.mapstruct)
    annotationProcessor(libs.mapstruct.processor)
}

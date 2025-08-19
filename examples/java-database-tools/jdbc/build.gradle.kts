dependencies {
    implementation(project(":examples:java-database-tools-starter"))
    implementation(libs.log4jdbc.remix)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    compileOnly(libs.mapstruct)
    annotationProcessor(libs.mapstruct.processor)
}

dependencies {
    implementation(project(":examples:java-database-tools-starter"))
    implementation(libs.hibernate.core)
    implementation(libs.p6spy)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    compileOnly(libs.mapstruct)
    annotationProcessor(libs.mapstruct.processor)
}

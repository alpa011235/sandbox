dependencies {
    implementation(libs.mybatis.spring.boot.starter)
    implementation(project(":examples:java-database-tools-starter"))

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    compileOnly(libs.mapstruct)
    annotationProcessor(libs.mapstruct.processor)
}

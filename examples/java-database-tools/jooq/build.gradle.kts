import org.jooq.codegen.GenerationTool
import org.jooq.meta.jaxb.*
import org.jooq.meta.jaxb.Configuration
import org.jooq.meta.jaxb.Target

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation(project(":examples:java-database-tools-starter"))

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    compileOnly(libs.mapstruct)
    annotationProcessor(libs.mapstruct.processor)
}

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath(libs.jooq.codegen)
        classpath(libs.postgresql.driver)
    }
}

tasks.create("generate") {
    val configuration = Configuration()
            .withJdbc(
                    Jdbc()
                            .withDriver("org.postgresql.Driver")
                            .withUrl("jdbc:postgresql://localhost:5432/library")
                            .withUsername("usr")
                            .withPassword("pwd")
            ).withGenerator(
                    Generator()
                            .withDatabase(
                                    Database()
                                            .withInputSchema("public")
                            )
                            .withGenerate(
                                    Generate()
                                            .withPojos(true)
                                            .withDaos(true)
                                            .withPojosEqualsAndHashCode(true)
                                            .withSpringAnnotations(true)
                                            .withFluentSetters(true)
//                                            .withJpaAnnotations(true)
                            )
//                            .withStrategy(
//                                    Strategy()
//                                            .withName("org.jooq.codegen.example.JPrefixGeneratorStrategy")
//                            )
                            .withTarget(
                                    Target()
                                            .withPackageName("edu.sandbox.javadatabasetools.jooq.generated")
                                            .withDirectory("$projectDir/src/main/java/")
                            )
            )

    doLast {
        GenerationTool.generate(configuration)
    }
}

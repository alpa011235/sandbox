import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.the
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel
import org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES

plugins {
    alias(libs.plugins.springframework.boot) apply false
    alias(libs.plugins.spring.dependency.management)
    idea
}

idea {
    project {
        languageLevel = IdeaLanguageLevel(21)
    }
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

allprojects {
    group = "edu.sandbox"

    repositories {
        mavenLocal()
        mavenCentral()
    }

    apply(plugin = "io.spring.dependency-management")
    dependencyManagement {
        dependencies {
            imports {
                mavenBom(BOM_COORDINATES)
            }
            // The versions are hardcoded here because of an issue with the
            // io.spring.dependency-management plugin and Gradle version catalogs.
            // The plugin does not seem to be able to resolve the versions from the
            // catalog at configuration time.
            dependency("org.projectlombok:lombok:1.18.30")
            dependency("org.mapstruct:mapstruct:1.5.5.Final")
            dependency("org.mapstruct:mapstruct-processor:1.5.5.Final")
            dependency("org.springframework.shell:spring-shell-starter:3.1.3")
            dependency("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.2")
            dependency("org.hibernate:hibernate-core:6.3.1.Final")
            dependency("org.lazyluke:log4jdbc-remix:0.2.7")
            dependency("net.ttddyy:datasource-proxy:1.9")
            dependency("p6spy:p6spy:3.9.1")
        }
    }

    configurations.all {
        resolutionStrategy {
            failOnVersionConflict()
        }
    }
}

subprojects {
    plugins.apply(JavaLibraryPlugin::class.java)
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.compilerArgs.addAll(listOf("-Xlint:all,-serial,-processing"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        testLogging.showExceptions = true
        reports {
            junitXml.required.set(true)
            html.required.set(true)
        }
    }
}

tasks {
    val managedVersions by registering {
        doLast {
            project.extensions.getByType<DependencyManagementExtension>()
                    .managedVersions
                    .toSortedMap()
                    .map { "${it.key}:${it.value}" }
                    .forEach(::println)
        }
    }
}

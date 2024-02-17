import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    id("eclipse")
    id("idea")
    id("net.minecraftforge.gradle") version "[6.0.16,6.2)"
}

val forgeVersionRange: String by extra
val minecraftVersion: String by extra
val forgeVersion: String by extra
val modVersion: String by extra

group = "dev.danilppzz.potleaves"
version = modVersion

base.archivesName.set("potleaves")

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

minecraft {
    mappings("official", minecraftVersion)

    copyIdeResources = true

    runs {
        configureEach {
            workingDirectory = project.file("run").path
            property("forge.logging.markers", "REGISTRIES")
            property("forge.logging.console.level", "debug")

            mods {
                create("potleaves") {
                    source(sourceSets.main.get())
                }
            }
        }

        create("client") {
            property("forge.enabledGameTestNamespaces", "potleaves")
        }

        create("server") {
            property("forge.enabledGameTestNamespaces", "potleaves")
            args("--nogui")
        }

        create("data") {
            workingDirectory = project.file("run-data").path
            args("--mod", "potleaves", "--all", "--output", file("src/generated/resources/"), "--existing", file("src/main/resources/"))
        }
    }
}

sourceSets.main.configure {
    resources.srcDir("src/generated/resources")
}

repositories {
}

dependencies {
    minecraft("net.minecraftforge:forge:$minecraftVersion-$forgeVersion")
}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("minecraftVersion" to minecraftVersion,
            "forgeVersionRange" to forgeVersionRange, "modVersion" to modVersion)

    inputs.properties(replaceProperties)

    filesMatching("META-INF/mods.toml") {
        expand(replaceProperties)
    }}

tasks.jar {
    manifest {
        attributes(
                "Specification-Title" to "potleaves",
                "Specification-Vendor" to "Danilppzz",
                "Specification-Version" to modVersion,
                "Implementation-Title" to project.name,
                "Implementation-Version" to modVersion,
                "Implementation-Vendor" to "Danilppzz",
                "Implementation-Timestamp" to LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
        )
    }

    finalizedBy("reobfJar")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
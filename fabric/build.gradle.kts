@file:Suppress("DEPRECATION", "HasPlatformType")

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.fabricmc.loom.task.RemapJarTask

plugins {
    id("com.github.johnrengelman.shadow")
}

architectury {
    platformSetupLoomIde()
    fabric()
}

val minecraftVersion: String by extra
val fabricLoaderVersion: String by extra
val fabricApiVersion: String by extra
val fabricMinecraftVersionRange: String by extra
val modVersion: String by extra
val architecturyVersion: String by extra

val common by configurations.creating
val shadowCommon by configurations.creating

configurations["compileClasspath"].extendsFrom(common)
configurations["runtimeClasspath"].extendsFrom(common)
configurations["developmentFabric"].extendsFrom(common)

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    
    modApi("dev.architectury:architectury-fabric:$architecturyVersion")
    modApi("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion+$minecraftVersion")

    common(project(path = ":common", configuration = "namedElements")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionFabric")) { isTransitive = false }
}

tasks.withType<ProcessResources> {
    val replaceProperties = mapOf("modVersion" to modVersion, "minecraftVersion" to minecraftVersion)

    inputs.properties(replaceProperties)

    filesMatching("fabric.mod.json") {
        expand(replaceProperties)
    }
}

tasks.withType<ShadowJar> {
    exclude(".cache/**")
    exclude("**/potleaves/datagen/**")

    configurations = listOf(shadowCommon)
    archiveClassifier.set("dev-shadow")
}

tasks.withType<RemapJarTask> {
    val shadowTask = tasks.shadowJar.get()
    input.set(shadowTask.archiveFile)
}

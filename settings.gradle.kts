enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://maven.minecraftforge.net/")
        maven(url = "https://maven.architectury.dev/")
        maven(url = "https://maven.fabricmc.net/")
    }
}

include("common", "fabric", "neoforge")
rootProject.name = "PotLeaves"

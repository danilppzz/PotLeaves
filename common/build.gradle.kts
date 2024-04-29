val fabricLoaderVersion: String by extra
val architecturyVersion: String by extra

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    modApi("dev.architectury:architectury:$architecturyVersion")
}

sourceSets.main.get().resources.srcDir("src/main/generated/resources")

architectury {
    common("fabric", "neoforge")
}

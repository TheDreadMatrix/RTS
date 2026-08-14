plugins {
    java
    application
}

sourceSets {
    create("tools") {
        java.srcDir("src/tools/src/main/java")
    }
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.13.2")
    implementation("com.badlogicgames.gdx:gdx:1.13.5")
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:1.13.5")

    implementation("com.badlogicgames.gdx:gdx-tools:1.13.5")

    implementation("com.badlogicgames.gdx:gdx-freetype:1.13.5")
    implementation("com.badlogicgames.gdx:gdx-freetype-platform:1.13.5:natives-desktop")

    runtimeOnly("com.badlogicgames.gdx:gdx-platform:1.13.5:natives-desktop")

    add("toolsImplementation", "com.badlogicgames.gdx:gdx:1.13.5")
    add("toolsImplementation", "com.badlogicgames.gdx:gdx-tools:1.13.5")
}



application {
    mainClass.set("Main")
}

tasks.register<JavaExec>("packTextures") {
    group = "assets"
    description = "Packs PNG textures into a LibGDX TextureAtlas"

    dependsOn("toolsClasses")

    classpath = sourceSets["tools"].runtimeClasspath
    mainClass.set("tools.TexturePackerTool")
}
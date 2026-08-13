plugins {
    java
    application
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
}


tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs("-Dfile.encoding=UTF-8")
}

application {
    mainClass.set("Main")
}

tasks.register<JavaExec>("packTextures") {
    group = "assets"
    description = "Packs PNG textures into a LibGDX TextureAtlas"

    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("com.returntosirandora.tools.TexturePackerTool")
}
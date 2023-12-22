rootProject.name = 'DepTest'
version = "0.2"

plugins {
    id("demo.kotlin-application-conventions")
}

val creationDate by extra { project.findProperty("creationDate") ?: LocalDate.now().toString() }
val javaVersion = JavaVersion.VERSION_11
configure<JavaPluginConvention> {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

kotlinDslPluginOptions {
    jvmTarget.set(javaVersion.toString())
}

dependencies {
    implementation("org.apache.commons:commons-text")
    val acmeVersion = "11.0.15"
    implementation("org.eclipse.jetty:jetty-openid:$acmeVersion")
    implementation("com.google.guava:guava:31.0.1-android")
    testImplementation("io.kotest:kotest-assertions-shared-js:5.0.0")
    testImplementation("io.kotest:kotest-assertions-shared-js:5.0.1")
}

project.plugins.withType(JavaPlugin::class) {
    dependencies {
        "errorprone"("com.google.errorprone:error_prone_core:2.24.0")
    }
}

application {
    mainClass.set("deptestkotlin.app.AppKt")
}
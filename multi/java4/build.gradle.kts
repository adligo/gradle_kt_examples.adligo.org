val top = "root build.gradle.kts file"
println("in the " + top)


plugins {
    application
    eclipse
    java
}

buildscript {
    val pBlock = " buildScript block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.0-alpha5")
    implementation("ch.qos.logback:logback-classic:1.2.9")
    //printAllDependencies(this)
}

fun sharedADeps(dhs : DependencyHandlerScope) {
    dhs.implementation("com.google.code.gson:gson:2.8.9")
}

fun sharedBDeps(dhs : DependencyHandlerScope) {
    sharedADeps(dhs)
    dhs.project(":subA")
    dhs.project(":subB")
}

project(":subA") {
    apply(plugin="java")
    dependencies {
        sharedADeps(this)
    }
}

project(":subA-tests") {
    apply(plugin="java")
    dependencies {
        sharedADeps(this)
        project(":subA")
    }
}

project(":subB") {
    apply(plugin="java")
    dependencies {
        sharedADeps(this)
        project(":subA")
    }
}

project(":subB-tests") {
    apply(plugin="java")
    dependencies {
        sharedBDeps(this)
    }
}

subprojects {
    apply(plugin="java")
}


/**
 * Note this only executes when hw is explicitly called by gradle ie
 * gradle build hw
 * or more simply
 * gradle hw
 */
tasks.register("hw") {
    val pBlock = "hw task block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

println("exit " + top + "\n\n")
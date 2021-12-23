val top = "root build.gradle.kts file"
println("in the " + top)

plugins {
    val pBlock =  " plugin block"
    println("starting " + pBlock)
    println(this)
    application
    eclipse
    java
    println("end " + pBlock + "\n\n")
}

buildscript {
    val pBlock =  " buildScript block"
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

application {
    mainClass.set("org.adligo.javaSingle.App")
}


println("exit " + top + "\n\n")
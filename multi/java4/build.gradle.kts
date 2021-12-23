val top = "root build.gradle.kts file"
println("in the " + top)

fun allPlugins(p: Project) {
  p.apply(plugin="java")
  p.apply(plugin="eclipse")
}

plugins {
  println("plugins is ")
  println(this)
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
  allPlugins(this)
    dependencies {
        sharedADeps(this)
    }
   repositories {
        allRepos(this)
    }
}

project(":subA-tests") {
  allPlugins(this)
    dependencies {
        sharedADeps(this)
        project(":subA")
    }
    repositories {
        allRepos(this)
    }
}

project(":subB") {
  allPlugins(this)
    dependencies {
        sharedADeps(this)
        project(":subA")
    }
   repositories {
        allRepos(this)
    }
}

project(":subB-tests") {
  allPlugins(this)
    dependencies {
        sharedBDeps(this)
    }
    repositories {
        allRepos(this)
    }
}

fun allRepos(r: RepositoryHandler) {
  r.mavenLocal()
  r.mavenCentral()
}

repositories {
    allRepos(this)
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
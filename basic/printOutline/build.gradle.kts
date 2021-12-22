val top = "root build.gradle.kts file"
println("in the " + top)

plugins {
    val pBlock =  " plugin block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

buildscript {
    val pBlock =  " buildScript block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

repositories {
    val pBlock =  " repositories block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

dependencies {
    val pBlock =  " dependencies block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
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
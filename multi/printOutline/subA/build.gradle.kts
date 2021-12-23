val top = "subA/build.gradle.kts file"
println("in the " + top)

plugins {
    val pBlock = " subA plugin block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

buildscript {
    val pBlock = " subA buildScript block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

repositories {
    val pBlock = " subA repositories block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

dependencies {
    val pBlock =  " subA dependencies block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

println("exit " + top)
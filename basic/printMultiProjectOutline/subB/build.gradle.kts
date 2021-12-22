val top = "subB/build.gradle.kts file"
println("in the " + top)

plugins {
    val pBlock = " subB plugin block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

buildscript {
    val pBlock = " subB buildScript block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

repositories {
    val pBlock = " subB repositories block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

dependencies {
    val pBlock = " subB dependencies block"
    println("starting " + pBlock)
    println(this)
    println("end " + pBlock + "\n\n")
}

println("exit " + top)
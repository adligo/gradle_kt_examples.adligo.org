val top = "root settings.gradle.kts file"
println("in the " + top)

rootProject.name = "basicPrintOutline"
println("rootProject.name is now " + rootProject.name)
println(this)
include("subA","subB")
println("exiting " + top)
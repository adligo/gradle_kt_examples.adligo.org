import org.gradle.plugins.ide.eclipse.model.Classpath
import org.gradle.plugins.ide.eclipse.model.EclipseModel
import org.gradle.plugins.ide.eclipse.model.Library
import org.gradle.plugins.ide.eclipse.model.ProjectDependency

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

fun isModule(dep: ProjectDependency): Boolean {
    //entry.kind = "lib"  // Only libraries can be modules
    println("isModule  " + dep.getPath())
    val path = dep.getPath()
    val len = path.length
    return isModule(path.substring(1, len))
}

fun isModule(dep: Library): Boolean {
    //entry.kind = "lib"  // Only libraries can be modules
    println("isModule  " + dep.getPath())
    val path = dep.getPath()
    val len = path.length
    return isModule(path.substring(1, len))
}

fun isModule(projectName: String): Boolean {
  println("isModuleString " + projectName)
//  when(projectName) {
//    "i_ctx.adligo.org" -> return true
//  }
  return true
}

fun onEclipse(eclipse: EclipseModel) {
  //println("onEclipse " + eclipse)
  //println("${eclipse::class.qualifiedName}")
  eclipse.classpath.file {
    //println("onEclipseFile " + this)
    //println("${this::class.qualifiedName}")  
    whenMerged { 
      //this.forEach( println("whenMerged " + $it))
      //println("whenMerged ")
      //println("${this::class.qualifiedName}")
      onEclipseClasspathMerged(this as Classpath)
      //isModule(this)
      
    }
  }
}

fun onEclipseClasspathMerged(classpath: Classpath) {
  classpath.getEntries().forEach { 
    println("\n\neach " + it) 
    println("${it::class.qualifiedName}")
    if (it is ProjectDependency) {
      if (isModule(it as ProjectDependency)) {
        println(it.getPath() + " is a module ")
        it.entryAttributes["module"] = "true"
      }
    } else if (it is Library) {
      if (isModule(it as Library)) {
        println(it.getPath() + " is a module ")
        it.entryAttributes["module"] = "true"
      }    
    }
  }
  //println("onEclipseClasspathMerged " + classpath.getEntries())
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
  eclipse { 
    onEclipse(this)
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
  eclipse { 
    onEclipse(this)
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
  eclipse { 
    onEclipse(this)
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
  eclipse { 
    onEclipse(this)
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
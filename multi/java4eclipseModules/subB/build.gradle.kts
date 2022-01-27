tasks{

  //this added the module path from the classpath,
  //which allows upstream modules to find the required stuff
  compileJava {
    doFirst {
      options.compilerArgs = listOf(
           "--module-path", classpath.asPath)
    }
  }
}
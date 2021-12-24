//gradle -Pprop=foo
println("Hey the prop property is " + project.getProperties().get("prop"))
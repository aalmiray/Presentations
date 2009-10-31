def eventClosure1 = binding.variables.containsKey('eventCopyLibsEnd') ? eventCopyLibsEnd : {jardir->}
eventCopyLibsEnd = { jardir ->
    eventClosure1(jardir)
    if (!isPluginProject) {
        ant.fileset(dir:"${getPluginDirForName('slideware').file}/lib/", includes:"*.jar").each {
            griffonCopyDist(it.toString(), jardir)
        }
    }
}

eventStatsStart = { paths ->
    paths << [name: "Actions", path: "actions", filetype: [".groovy"]]]
    paths << [name: "Slides", path: "slides", filetype: [".groovy"]]]
}

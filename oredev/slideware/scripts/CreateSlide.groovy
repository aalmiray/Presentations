import org.codehaus.griffon.util.GriffonNameUtils

includeTargets << griffonScript("_GriffonInit")
includeTargets << griffonScript("_GriffonCreateArtifacts")

target (default : "Creates a Slide view") {
    depends(checkVersion)

    def targetDir = new File("${basedir}/griffon-app/slides")
    targetDir.mkdirs()
    
    int count = 0
    targetDir.eachFile { file ->
        def m = file.name =~ /Slide(\d+)\.groovy/
        if(m) {
           count = Math.max(count, (m[0][1] as int) + 1)
        }
    }

    def slideName = "Slide${count}"

    createArtifact(
        name: slideName,
        suffix: "",
        type: "Slide",
        path: "griffon-app/slides")

    def artifactFile = "${basedir}/griffon-app/slides/${slideName}.groovy"

    ant.replace(file: artifactFile) {
        replacefilter(token: "@count@", value: count )
    }
}

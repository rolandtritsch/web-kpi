// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("play" % "sbt-plugin" % "2.1.1")

// Add the start script plugin (needed by heroku)
addSbtPlugin("com.typesafe.sbt" % "sbt-start-script" % "0.7.0")
//addSbtPlugin("com.typesafe.startscript" % "xsbt-start-script-plugin" % "0.5.2")

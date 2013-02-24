package webkpi

import sbt._
import sbt.Keys._
import PlayProject._

object WebKpiBuild extends Build {

  val appName         = "WebKPIApp"
  val appVersion      = "1.0"

  val appDependencies = Seq(
    "org.scalaj" % "scalaj-time_2.9.2" % "0.6",
    "com.novus" %% "salat" % "1.9.2-SNAPSHOT",
    "com.codahale" % "jerkson_2.9.1" % "0.5.0"
  )

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    resolvers ++= Seq("Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
                      "repo.codahale.com" at "http://repo.codahale.com"
    )
  )

  // override lazy val settings = super.settings ++ Seq(
  //   name := "webkpi",
  //   organization := "com.gilt",
  //   scalaVersion := "2.10.0"
  // )
}

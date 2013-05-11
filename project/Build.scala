package org.tritsch.scala.webkpi.build

import sbt._
import sbt.Keys._

import play._

import com.typesafe.sbt.SbtStartScript

object WebKpiBuild extends sbt.Build {
  val appName = "web-kpi"
  val appVersion = "1.0"

  val appDependencies = Seq(
    "org.scalaj" % "scalaj-time_2.9.1" % "0.6"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    SbtStartScript.startScriptForClassesSettings: _*
  )
}

package org.tritsch.scala.webkpi.build

import sbt._
import sbt.Keys._
import play._

import org.ensime.sbt.Plugin.Settings._
import org.ensime.sbt.util.SExp._

object WebKpiBuild extends sbt.Build {

  val appName         = "web-kpi-app"
  val appVersion      = "1.0"

  val appDependencies = Seq(
    "com.github.wookietreiber" %% "scala-chart" % "latest.integration",
    "org.scalaj" % "scalaj-time_2.9.1" % "0.6"
  )

  override val settings = super.settings ++ Seq(
    ensimeConfig := sexp(
      key(":compile-deps"), sexp(
        "/Users/rtritsch/.ivy2/cache/org.scala-tools.time/time_2.9.1/jars/time_2.9.1-0.5.jar",
        "/Users/rtritsch/.ivy2/cache/com.github.wookietreiber/scala-chart_2.10/jars/scala-chart_2.10-0.2.0.jar"
      )
    )
  )

  val main = play.Project(appName, appVersion, appDependencies)

}

package webkpi

import sbt._
import sbt.Keys._
import play.Project._

object WebKpiBuild extends Build {
  val appDependencies = Seq(
    "org.scalaj" % "scalaj-time_2.9.2" % "0.6"
  )

  val main = play.Project(
    "WebKPIApp", "1.0", appDependencies
  )

  override lazy val settings = super.settings ++ Seq(
    name := "webkpi",
    organization := "com.gilt",
    scalaVersion := "2.10.0"
  )
}

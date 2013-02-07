package webkpi

import sbt._
import sbt.Keys._
import play.Project._

object WebKpiBuild extends Build {
  val appDependencies = Seq(
  	"com.codahale" % "jerkson_2.9.1" % "0.5.0"
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

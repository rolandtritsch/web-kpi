package webkpi

import sbt._
import sbt.Keys._
import play.Project._

object WebKpiBuild extends Build {
  val appDependencies = Nil

  val main = play.Project(
    "WebKPIApp", "1.0", appDependencies
  )

  override lazy val settings = super.settings ++ Seq(
    name := "webkpi",
    organization := "com.gilt",
    scalaVersion := "2.10.0"
  )
}

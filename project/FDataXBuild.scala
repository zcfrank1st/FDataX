import sbt._
import Keys._

object FDataXBuild extends Build {
  val coreDependencies = Seq(

  )

  val commonDependencies = Seq(
    "org.apache.commons" % "commons-lang3" % "3.4",
    "com.google.guava" % "guava" % "19.0",
    "commons-io" % "commons-io" % "2.5",
    "org.slf4j" % "slf4j-api" % "1.7.21",
    "ch.qos.logback" % "logback-classic" % "1.1.7",
    "org.apache.commons" % "commons-math3" % "3.6.1",
    "com.google.code.gson" % "gson" % "2.7"
  )

  lazy val core = Project(id = "core", base = file("core")) settings(
    version       := "0.1",
    scalaVersion  := "2.11.8",
    libraryDependencies ++= coreDependencies)

  lazy val common = Project(id = "common", base = file("common")) settings(
    version       := "0.1",
    scalaVersion  := "2.11.8",
    libraryDependencies ++= commonDependencies)

  lazy val root = Project(id = "root", base = file(".")) aggregate (core, common)

}
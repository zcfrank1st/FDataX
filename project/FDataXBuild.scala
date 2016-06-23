import sbt._
import Keys._

object FDataXBuild extends Build {
  val coreDependencies = Seq(

  )

  val commonDependencies = Seq(

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
import sbt._
import Keys._

object FDataXBuild extends Build {
  val dependencies = Seq(

  )

  lazy val core = Project(id = "core", base = file("core")) settings(
    version       := "0.1",
    scalaVersion  := "2.11.8",
    libraryDependencies ++= dependencies)

  lazy val root = Project(id = "root", base = file(".")) aggregate "core"

}
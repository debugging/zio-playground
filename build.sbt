import Dependencies._

ThisBuild / scalaVersion     := "2.13.7"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "zio-playground",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "1.0.12",
      "dev.zio" %% "zio-streams" % "1.0.12",
      scalaTest % Test
    )
  )

fork := true  

// Aliases
addCommandAlias("r", "reload")
addCommandAlias("c", "compile")
addCommandAlias("fmt", "all scalafmtSbt scalafmtAll")

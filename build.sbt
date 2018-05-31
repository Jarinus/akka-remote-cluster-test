name := "akka-remote-cluster-test"
mainClass in Compile := Some("net.atos.remotecluster.Main")

// Docker
packageName in Docker := "akka-remote-cluster-test"
dockerBaseImage := "openjdk:jre-alpine"
dockerUsername := Some("jarinus")
dockerUpdateLatest := true

// Versioning
version := "0.1"
scalaVersion := "2.12.6"
val akkaVersion = "2.5.12"

// Dependencies
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-cluster" % akkaVersion)

// Plugins
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(AshScriptPlugin)

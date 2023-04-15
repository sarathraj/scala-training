name := "HelloWorld"
version := "0.1"
scalaVersion := "3.2.1"
//You can ask the compiler to consider warnings as com- pilation errors by enabling a feature flag. To do so, add the following line to your build.sbt file:
//scalacOptions += "-Xfatal-warnings"
libraryDependencies += "dev.zio" %% "zio" % "2.0.5"
//libraryDependencies += "org.typelevel" %% "cats" % "2.2.0"

val Http4sVersion = "0.22.0"

libraryDependencies ++= List(
  "org.http4s"      %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s"      %% "http4s-dsl"          % Http4sVersion,
  "ch.qos.logback"  %  "logback-classic"     % "1.2.3"
)

val CirceVersion = "0.14.1"
libraryDependencies ++= List(
  "io.circe" %% "circe-core" % CirceVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "io.circe" %% "circe-parser" % CirceVersion
)
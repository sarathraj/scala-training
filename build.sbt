name := "HelloWorld"
version := "0.1"
scalaVersion := "3.2.1"
//You can ask the compiler to consider warnings as com- pilation errors by enabling a feature flag. To do so, add the following line to your build.sbt file:
scalacOptions += "-Xfatal-warnings"
libraryDependencies += "dev.zio" %% "zio" % "2.0.5"
//libraryDependencies += "org.typelevel" %% "cats" % "2.2.0"

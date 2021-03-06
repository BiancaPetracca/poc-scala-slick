
name := "poc-frms"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.1",
  "com.h2database" % "h2" % "1.4.193",
  "org.mariadb.jdbc" % "mariadb-java-client" % "1.5.8",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.10",
  "org.scalatest" %% "scalatest"   % "3.0.1"   % "test",
  "org.mockito"   % "mockito-core" % "1.10.19" % "test")
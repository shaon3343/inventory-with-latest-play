name := """inventory-with-latest-play"""
organization := "com.shaon.play"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.apache.poi" % "poi" % "3.10-FINAL",
  "dom4j" % "dom4j" % "1.6.1",
  "org.apache.xmlbeans" % "xmlbeans" % "2.3.0",
  guice,
  javaCore,
  javaJdbc,
  "mysql" % "mysql-connector-java" % "5.1.22",
  "com.typesafe" % "slick_2.10.0-RC1" % "0.11.2",
  "org.mindrot" % "jbcrypt" % "0.3m",
  "com.typesafe.play" %% "play-ebean" % "4.0.0-M1"
)

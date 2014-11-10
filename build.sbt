name := """rabbitmq-streams"""

organization := "com.enelson"

version := "0.1"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.6",
// Change this to another test framework if you prefer
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)


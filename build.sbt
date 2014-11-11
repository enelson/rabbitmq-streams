name := """rabbitmq-streams"""

organization := "com.enelson"

version := "0.1"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.2.1",
  "com.rabbitmq" % "amqp-client" % "3.3.4" intransitive(),
  "com.typesafe.akka" % "akka-actor_2.11" % "2.3.6" intransitive(),
  "com.typesafe.akka" % "akka-slf4j_2.11" % "2.3.6" intransitive(),
  "com.typesafe.akka" % "akka-persistence-experimental_2.11" % "2.3.6" intransitive(),
  "com.typesafe.akka" % "akka-stream-experimental_2.11" % "0.10" intransitive(),
  "org.reactivestreams" % "reactive-streams" % "0.4.0.M2" intransitive(),
  "com.assembla.scala-incubator" % "graph-core_2.11" % "1.9.0" intransitive(),
// Change this to another test framework if you prefer
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)


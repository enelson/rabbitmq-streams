package com.enelson.rabbitmq.streams

import java.io.IOException

import com.rabbitmq.client.{Connection, ConnectionFactory}
import com.typesafe.config.Config

import scala.util.control.Exception._

class RabbitController(mqSettings: Config) {

  val catchIOException = catching(classOf[IOException])
  val connection = createMQChannel(mqSettings.getConfig("connection"))

  def createMQChannel(config: Config): Option[Connection] = {
    val connectionFactory = createConnectionFactory(config)
    catchIOException either connectionFactory.newConnection() match {
      case Left(t) =>
        val hostPortStr = s"[${config.getString("host")}:${config.getInt("port")}]"
        throw new RuntimeException(s"RabbitMQ-Streams Extension - could not connect to RabbitMQ server: $hostPortStr", t)
      case Right(conn) =>
        Some(conn)
    }
  }

  def createConnectionFactory(config: Config): ConnectionFactory = {
    val connectionFactory = new ConnectionFactory()
    connectionFactory.setHost(config.getString("host"))
    connectionFactory.setPort(config.getInt("port"))
    connectionFactory.setUsername(config.getString("username"))
    connectionFactory.setPassword(config.getString("password"))

    connectionFactory
  }

}

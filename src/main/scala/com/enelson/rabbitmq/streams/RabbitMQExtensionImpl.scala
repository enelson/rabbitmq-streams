package com.enelson.rabbitmq.streams

import akka.actor._
import com.typesafe.config.ConfigFactory


object RabbitMQExtension extends ExtensionKey[RabbitMQExtensionImpl]

class RabbitMQExtensionImpl(system: ExtendedActorSystem) extends Extension {

  val defaultConfig = ConfigFactory.parseString(
    """
      |akka {
      |  rabbitmq-streams {
      |    connection {
      |      host="localhost"
      |      port=5672
      |      username="guest"
      |      password="guest"
      |    }
      |  }
      |}
    """.stripMargin)

  protected val rabbitmqController = createRabbitController()

  protected def createRabbitController(): RabbitController = {
    val settings = system.settings.config.withFallback(defaultConfig).getConfig("akka.rabbitmq-streams")
    println(s"Config: $settings")
    new RabbitController(settings)
  }

}


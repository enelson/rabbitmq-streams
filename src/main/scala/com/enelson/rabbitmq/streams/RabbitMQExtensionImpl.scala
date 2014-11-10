package com.enelson.rabbitmq.streams

import akka.actor._


object RabbitMQExtension extends ExtensionKey[RabbitMQExtensionImpl]

class RabbitMQExtensionImpl(system: ExtendedActorSystem) extends Extension {



}


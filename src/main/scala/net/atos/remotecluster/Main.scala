package net.atos.remotecluster

import akka.actor.{ActorSystem, Props}

object Main {
  def main(args: Array[String]): Unit = {
    val system: ActorSystem = ActorSystem(
      "AkkaRemoteClusterTest",
      ConfigParser.parse(args))

    val _ = system.actorOf(Props[TestActor])
  }
}

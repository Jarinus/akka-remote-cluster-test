package net.atos.remotecluster

import akka.actor.Actor

class TestActor extends Actor {
  def receive: Receive = {
    case _ => // No behaviour
  }
}

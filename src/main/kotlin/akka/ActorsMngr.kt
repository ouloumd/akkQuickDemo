package akka

import akka.actor.ActorSystem
import akka.actor.Props

fun main() {

  val actorSystem = ActorSystem.create("shopfloorActors")
  val machinesRef = actorSystem.actorOf(Props.create(Machines::class.java), "machines")

  machinesRef.tell("hello", machinesRef)

  machinesRef.tell(Machines.InitMachine(), machinesRef)

  machinesRef.tell(Machines.SendInfo(), machinesRef)

  machinesRef.tell(Machines.StopMachine(), machinesRef)
}
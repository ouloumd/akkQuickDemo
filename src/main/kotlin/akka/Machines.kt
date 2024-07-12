package akka

import akka.actor.AbstractLoggingActor
import akka.actor.PoisonPill
import akka.actor.Props
import akka.japi.pf.ReceiveBuilder
import java.time.Instant
import kotlin.random.Random

class Machines : AbstractLoggingActor() {

  interface MachinesMessage
  class InitMachine(val number: Int = 10) : MachinesMessage
  class SendInfo : MachinesMessage
  class StopMachine : MachinesMessage

  override fun createReceive(): Receive =

    ReceiveBuilder()

      .match(String::class.java) {

        log().info("Machines received String : ${it}\n")

      }.match(InitMachine::class.java) {

        log().info("Initialise Machines Actor")

        repeat(it.number) { num ->
          val actorRef = context().actorOf(
            Props.create(
              Machine::class.java,
              num.toString(),
              "Machine $num",
              "SimpleMachine"
            ), num.toString()
          )
          actorRef.tell(Machine.TalkToMachine("hello Machine $num"), actorRef)
        }

      }.match(SendInfo::class.java) {

        log().info("Machines Sending Info to Machines Actors\n")

        val start = Instant.now()
        var cpt = 0
        while (start.plusSeconds(10) > Instant.now()) {

          val i = Random.nextInt(0, 9)
          log().info("msg ${cpt} to -> ${i}")
          val actorRef = context().actorSelection(i.toString())
          actorRef.tell(Machine.TalkToMachine("hello Machine ${it}, you received message $cpt"), actorRef.anchor())
          cpt += 1
        }

      }.match(StopMachine::class.java) {

        log().info("Machines Stoping all machines Actors\n")

        repeat(10) { num ->
          val actorRef = context().actorSelection(num.toString())
          actorRef.tell(PoisonPill.getInstance(), actorRef.anchor())
        }

     }.build()
}
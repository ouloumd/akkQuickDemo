package akka

import akka.actor.AbstractLoggingActor
import akka.actor.PoisonPill
import akka.japi.pf.ReceiveBuilder
import java.io.File
import java.io.FileWriter

class Machine (val idd: String, val name: String, val type: String) : AbstractLoggingActor() {

  var fileWriter: FileWriter = FileWriter(File("./${idd}.txt"))
  class TalkToMachine(val message: String)

  init {
    log().info("Machine Actor created : ${idd}\n")
    fileWriter.write("hello i'm a machine my id is : ${idd}\n")
  }
  override fun createReceive(): Receive = ReceiveBuilder()

    .match(Machine::class.java) {

        log().info("Machine Actor created : ${it}\n")

    }
    .match(String::class.java) {

      log().info("Machine recieved string : ${it}\n")

    }
    .match(TalkToMachine::class.java) {

      log().info("Machine recieved TalkMeaasage : ${it}\n")
      fileWriter.write("hello i'm a machine ${idd} received message : ${it.message}\n")

    }
    .match(PoisonPill::class.java) {

     fileWriter.write("I'm machine $idd, tchiao!\n")
     fileWriter.flush()
     fileWriter.close()
     context().stop(self())

    }
  .build()
}
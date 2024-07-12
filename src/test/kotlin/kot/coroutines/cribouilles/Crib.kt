package kot.coroutines.cribouilles

import org.junit.jupiter.api.Test

class Crib {
    @Test
    fun main() {
        val strNull: String? = null
        val str: String? = "titi"

        println(strNull?:"toto")
        println(str?:"toto")

    }
}
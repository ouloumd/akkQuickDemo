package arrows

import arrow.fx.coroutines.parZip

class ParZip {

  fun getLongWorkingComputattion(): Int =  1

  fun getLongWorkingComputattion2(): String = "a"

  suspend fun main(): String = parZip(
      { getLongWorkingComputattion() },
      { getLongWorkingComputattion2() }
    ) { a, b -> "${a}-${b}" }
}
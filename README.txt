Very simple basic example of how to build an Actors System.

Uses Akka, which is :
  "a toolkit and runtime for building highly concurrent,
   distributed,
   and fault-tolerant event-driven applications on the JVM." (ia gen)

Uses Kotlin which is good though it does not fully embrace functional programming.
(no for comprehension, no full structural pattern matching, no built-in try monad...)

Uses gradle which I don't like.

This few simple example, however, shows that :

    1.  The Actor System is very performant. (tens of thousands of messages per second)
    2.  Not even an issue raised while writing intensively and concurrently in many files.

 The example is a simple one, but it shows the power of the Actor System.

 TODO :
 Phase 1 explore :
    Unit tests
    Simulate errors
 Phase 2 POC :
     Add spring boot
     Database stuff (r2dbc)
     Plug biz logic (for parrallel processing)

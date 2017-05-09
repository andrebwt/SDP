package singleton

object TestLazyInitialise extends App {

  SingletonLazy.instance.doStuff
  SingletonLazy.instance.doStuff
  SingletonLazy.instance.doStuff
}

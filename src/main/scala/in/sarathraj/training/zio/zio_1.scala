//// Effects
//
//
//class MYIO[A](unsafeRun: () => A):
//   def map[B](f: A=>B):MYIO[B] = MYIO(() => f(unsafeRun()))
//   def flatmap[B](f:A=>MYIO[B]):MYIO[B] = MYIO(() => f(unsafeRun()).unsafeRun())
//
// //object Effects{
//
//    //not all expressions are refrencial transparency
//    // 1. measure the ccurrent time of system
//    // 2.measur the duration of the computation
//
//
//
//
// //}
# Quick inheritance/polymorphism quiz
## Polymorphism
  1. How does the runtime know which version (form) of a method to dispatch to when it is called on an object?
    * Magic?
    * Something else (maybe data) where does it store this?
  2. When does the Java system of tools (the compiler, runtime, and standard library) know which version of a polymorphic method to call?
    * compile time
    * run time
    * it depends. On what?
  3. What would we do if we wanted different code to run in different situations but Java (in an alternate universe or C in this universe) didn't have a built in polymorphism system?

## Inheritance
  1. If `class A` defines a method called `callMe` and `class B` extends `class A` and overrides `callMe`, who's version does this code call? `B b = new B(); b.callMe();`
  2. Who's version does this code call? `A a = new B(); a.callMe();`

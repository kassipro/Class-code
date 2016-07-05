# Counting
## with ties to Recursion and polymorphism

### Polymorphism
> Poly morph ism => has many forms

In programming, we can have *polymorphic* methods. This is some job that needs to be done different ways depending on the situation.

Example:
> Scene: Two people on a roadtrip through the desert, cloudless, a bird circles on a draft. They are running on empty.<br>
> The driver pulls into a gas station. "I'll get us a couple of cold drinks, could you fill it up?"<br>
> "Sure thing."

Does the passenger use gasoline or diesel fuel? That depends, of course, on what kind of fuel their vehicle takes.

Does the passenger pay at the pump or walk in to talk with the cashier? That depends, of course, on whether this gas station has pay-at-pump card readers, and whether the card reader is currently functional, and whether the passenger wants to pay with a card or cash.

The job of refueling the vehicle is polymorphic on:
* type of vehicle
* type of payment accepted at the station
* current working state of card readers if any
* and passenger payment preferences

#### Polymorphism in Java
Java provides polymorphism for methods based on inheritance hierarchies. This is also called *dynamic dispatch* because when you call a method on an object, the runtime system looks up the right form of the method for that object and dispatches (jumps) to it.

`Equals` and `toString` are defined on `Object`, and all classes inherit from `Object`, so you can call `toString` on any object. If you don't want the form of `toString` defined in `Object`, you can override it by defining a different form for your class.

Now when you call `toString` on an instance of your class, the runtime will dispatch to the new form (because you overrode the original form). It will dispatch to this new version of `toString` for any classes that inherit from your class (unless of course they in turn override your version).

```
Method versions flow from parent to child, until overridden
       A
      / \
     /   \
    B     A____
   / \     \   \
  C   B     A   D
 /   / \   / \   \
C   B   B A   A   D
```

If you need to perform different actions based on the value of arguments (eg if the int is negative do this, else do that) you just need to write logic conditions. Polymorphism in Java only dispatches based on the class of the object you are calling the method on.

```java
myObject.operateOn("the", -3)
```
At runtime, the JVM will look up the type of `myObject` and dispatch to the right form of the `operateOn` method.

##### Interfaces and Abstract classes
If an abstract class has an abstract method, then all non-abstract classes inheriting from it will have a definition of that method. This is a lot like an interface, which tells you that any class implementing the interface will have a definition for the interface methods.

In this way interfaces are like abstract classes where all methods are abstract (not defined). Therefore all implementing classes must "override" these methods. Dynamic dispatch works the same way with these "abstract" hierarchies (look up the type, dispatch to the most specific overriding version).

# Overview of AOP and Cross Cutting Concerns

AOP stands for Aspect Oriented Programming, instead of concerning ourselves with objects, we focus on Aspects, which modularize particular concerns which can present across multiple classes, known as cross cutting concerns

Examples:
- Database access
- Data entities
- error handling
- logging

AOP and Cross Cutting Concerns help reduce code redundancy by transfering responsibility of these problems to aspects

## AOP Terminology

Aspect: a representation of a concern which cuts across multiple classes

Weaving: the process of linking aspects with other objects, such as beans, to create advised objects. This can be done at compile time (such as when using the AspectJ compiler), load time or runtime. Spring performs weaving at runtime

Join Point: a specific moment during executing of a program, such as the invocation of a method, where an action takes place

Advice: action taken by an aspect at a specific join point

Pointcut: a definition of which methods our application advice ought to be into or around, for example when a method of a certain name is executed. By defualt, spring used AspectJ pointcut expression language

Introduction: declaration of new interfaces and corresponding implementations in subclasses of any advised object. Introductions use the `@DeclareParents` annotation with the defaultImpl attribute to define a concrete class for the bean definition

# AspectJ

@AspectJ refers to a style of declaring aspects through the use of regular Java classes with annotations. @AspectJ style was introduced in AspectJ 5 release of the AspectJ project. Note that Spring interprets the same annotations as AspectJ 5, using a library supplied by AspectJ, however Spring AOP's runtime is not dependent on the AspectJ compiler or weaver

To utilize AspectJ aspects in a Spring configuration, you need to enable support for configuring the Spring AOP based AspectJ aspects and autoproxying beans which are advised by those aspects.

Autoproxying means that spring will automatically generate a proxy to interpret method invocations when a bean is advised by one or more apsects to ensure the advise is executed

AspectJ configurations can be enabled using either XML or Java-based spring configureation. In either case, you will need to make sure that the AspectJ aspectweaver.jar is in your applications classpath
(version 1.6.8 or later is required for Spring 4.0.x+)

# Spring AOP:
the spring module that utilizes AspectJ to easily implement AOP principles in Java

# Cross Cutting Concerns:
parts of a program that rely on, or must affect many other part of the system

# Advice:

Like mentioned above, advice is a specific action taken, defined as a method, at a particular point during execution of a program

There are 5 types of advice:

- Before: advice that will execute before a join point, but does not have the capability to halt the normal execution of the proceeding join point (unless an exception is thrown)
- After Returning: advice that will execute after a join point completes without throwing an exception
- After Throwing: advice that will execute after a join point throws an exception
- After: Advice that will execution regardless of the outcome of the join point
- Around: Advice that will execute before and after the join point. It is the most general, but also the most powerful. It can perform custom behavior before and after a join point, and can be responisble for choosing whether or not to proceed to the join point.

In general, it is recommended to use the least powerful type of advice for any particular task. For instance, if you only need to update a cache with a value returned from a method, it is best to use the After Returning advice

# Pointcut and JointPoints

Pointcuts determine Joinpoints, because they define which methods in out application ought to be injected into or around

Joinpoints are the specific moment during execution of a program in which the advice is taken

Pointcuts are comprised of a name, and any parameters, and keep in mind these determine EXACTLY which method execution we are interested in

To create a pointcut we use @Pointcut annotation with regular method signatures, these include:

- execution
- within
- this
- target
- args
- @target
- @args
- @within
- @annotation

Execution is the most widely used, and you can use patterns with wildcard to specify the join points

```java
execution(?modifiers-pattern ret-type-patter ?declaring-type-pattern name-pattern(param-pattern) ?throws pattern)
```
# mkdocer

Utils which create markdown docs from code comments documentation such as [javaDoc](http://www.oracle.com/technetwork/articles/java/index-137868.html) or [appledoc](http://gentlebytes.com/appledoc/). Now available next languages:

* ActionScript
* Java
* Kotlin
* ObjectiveC

# Implementation

For generation documentation you should run next command line:

```
java -jar docer.jar /PATH/TO/PROJECT/ /OUTPUT/PATH/ OS
```

Where OS (optional param) is one of:

* Andorid
* Ios

If OS is specified then docer will scan proguard files for android or xcodeProj for iOS and add to docs only public classes/headers

Reference:
	- Book: Functional Programming in Java - Java 8 by Venkat Subramaniam
	- http://zeroturnaround.com/rebellabs/java-8-revealed-lambdas-default-methods-and-bulk-data-operations/

Features Covered:
	
* Lambdas, are the "Function Key" to free us from the hassles of imperative programming.

* Method References, help remove the mundane parameters routing.

* Predicate & Functions

* Comparator Interface, in Java 8 this has turned into a functional interface.

* Functional Interfaces


************************Important Interfaces Added in Java 8************************

- java.util.stream: A stream is a sequence of elements. Unlike a collection, it is not a data structure that stores elements. 
				    Instead, a stream carries values from a source, such as collection, through a pipeline. 
				    A pipeline is a sequence of stream operations, which in this example is filter- map-forEach. 
				    In addition, aggregate operations typically accept lambda expressions as parameters, enabling you to customize how they behave.
				    
- java.util.stream.Collectors
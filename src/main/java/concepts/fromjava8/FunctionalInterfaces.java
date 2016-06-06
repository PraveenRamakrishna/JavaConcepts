package concepts.fromjava8;


/**
 * Consumer<T> - performs an action on type T without returning a result.
 * Supplier<T> - returns an instance of type T, no input required.
 * Predicate<T> - consumes an instance of type T as a parameter and produces boolean value.
 * Function<T,R> - takes instance of type T as a parameter and produces an instance of type R as a result.
 */
public class FunctionalInterfaces {
	
	

}

@FunctionalInterface
interface Action {
	void run(String param);
  //void stop(String param); When Uncommented - The compiler throw an error: java: Unexpected @FunctionalInterface annotation ...
  
  //NOTE: But the following will compile just fine:	
  //default void stop(String param){}
}

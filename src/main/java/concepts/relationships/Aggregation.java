package concepts.relationships;

/**
 * Aggregation is a specialised form of Association where all objects have their
 * own lifecycle but there is ownership and child objects can not belong to
 * another parent object.
 * UML Representation: Car------<>Engine
 */

public class Aggregation {
	Engine engine = new Engine(0, 0);
	Car car = new Car(engine);
}

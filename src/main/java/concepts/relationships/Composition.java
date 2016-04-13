package concepts.relationships;

/**
 * Composition is again specialised form of Aggregation and we can call this as
 * a “death” relationship. It is a strong type of Aggregation. Child object does
 * not have it's lifecycle and if parent object is deleted all child objects
 * will also be deleted
 * UML Representation: Car-------<Filled>Engine
 */
public class Composition {
	Car car = new Car(0, 0);
}
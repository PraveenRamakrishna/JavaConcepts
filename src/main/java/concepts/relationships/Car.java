package concepts.relationships;

public class Car {
	private Engine engine;
	
	public Car(Engine engine) {
		// the engine object is created outside and is passed as argument to Car constructor
		// When this Car object is destroyed, the engine is still available to objects other than Car
		// If the instance of Car is garbage collected the associated instance of Engine may not be garbage collected (if it is still referenced by other objects)
		this.engine = engine;
	}
	
	public Car(int engineCapacity, int engineSerialNumber) {
		// we create the engine using parameters passed in Car constructor
		// only the Car instance has access to the engine instance
		// when Car instance is garbage collected, the engine instance is garbage collected too
		engine = new Engine(engineCapacity, engineSerialNumber);
	}

	public int getEngineSerialNumber() {
		return engine.getEngineSerialNumber();
	}

	public int getEngineCapacity() {
		return engine.getEngineCapacity();
	}


	public Engine getEngine() {
		return engine;
	}
}
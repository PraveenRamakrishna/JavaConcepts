package concepts.oops.polymorphism;

/**
 * Polymorphism is an Oops concept which advice use of common interface instead
 * of concrete implementation while writing code. When we program for interface
 * our code is capable of handling any new requirement or enhancement arise in
 * near future due to new implementation of our common interface. if we don't
 * use common interface and rely on concrete implementation, we always need to
 * change and duplicate most of our code to support new implementation With
 * 
 * Polymorphism you can write a code that doesn't have to change when you
 * introduce new subclasses types into program
 * 
 * Where to use Polymorphism in code??
 */
public class SeriousPolymorphism {

	public static void main(String[] args) {
		/**
		 * Variable names: Always use Super type while you are storing reference
		 * returned from any Factory method in Java, This gives you flexibility
		 * to accommodate any new implementation
		 */
	    Bicycle bike = new Bicycle(20, 10, 1);
	    Bicycle mountainBike = new MountainBike(20, 10, 5, "Dual");
	    Bicycle roadBike = new RoadBike(40, 20, 8, 23);
	    
	    printDescription(bike);
	    printDescription(mountainBike);
	    printDescription(roadBike);
	}

	/**
	 * Method argument: Always use super type in method argument that will give you leverage to
	 * pass any implementation while invoking method. if you have used concrete
	 * implementation e.g. CommodityTradingSystem or DMATradingSystem then that
	 * code will require frequent changes
	 */
	private static void printDescription(Bicycle bicycle) {
		System.out.println(bicycle.getDescription());
	}
}

class Bicycle {
	int cadence;
	int speed;
	int gear;

	public Bicycle() {
		super();
	}

	public Bicycle(int cadence, int speed, int gear) {
		super();
		this.cadence = cadence;
		this.speed = speed;
		this.gear = gear;
	}

	/**
	 * Return type of method: Return type of any method is another place where
	 * you should be using interface to take advantage of Polymorphism in Java.
	 */
	public String getDescription() {
		return "\nBike is " + "in gear " + this.gear + " with a cadence of " + this.cadence + " and travelling at a speed of " + this.speed + ".";
	}
}

class MountainBike extends Bicycle {
	private String suspension;

	public MountainBike(int startCadence, int startSpeed, int startGear, String suspensionType) {
		super(startCadence, startSpeed, startGear);
		this.setSuspension(suspensionType);
	}

	public String getSuspension() {
		return this.suspension;
	}

	public void setSuspension(String suspensionType) {
		this.suspension = suspensionType;
	}

	@Override
	public String getDescription() {
		return super.getDescription()+"\n The " + "MountainBike has a" + getSuspension() + " suspension.";
	}
}

class RoadBike extends Bicycle {
	private int tireWidth;

	public RoadBike(int startCadence, int startSpeed, int startGear, int newTireWidth) {
		super(startCadence, startSpeed, startGear);
		this.setTireWidth(newTireWidth);
	}

	public int getTireWidth() {
		return this.tireWidth;
	}

	public void setTireWidth(int newTireWidth) {
		this.tireWidth = newTireWidth;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + "\n The RoadBike" + " has " + getTireWidth() + " MM tires.";
	}
}
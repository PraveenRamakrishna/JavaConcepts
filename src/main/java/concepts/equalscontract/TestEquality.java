package concepts.equalscontract;

public class TestEquality {
	
	public static void main (String[] args){
		ColorPoint  colorPoint  = new ColorPoint(1, 1, "test");
		ColorPoint colorPoint2 = new ColorPoint(1, 1, "test");
		System.out.println(colorPoint.equals(colorPoint2));
	}

}

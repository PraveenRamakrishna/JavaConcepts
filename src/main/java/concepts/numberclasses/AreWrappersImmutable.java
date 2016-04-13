package concepts.numberclasses;

public class AreWrappersImmutable {

	public static void main(String[] args) {
		Integer isAgeImmutable = new Integer(10);
		String isNameImmutable = new String("ABC");
		Double isSalaryImmutable = new Double(100.0);
		
		printValues( isAgeImmutable, isNameImmutable,isSalaryImmutable);
		
		System.out.println("Is Original Values tampered..?: Integer: "+isAgeImmutable+" String: "+
		isNameImmutable+" Double: "+isSalaryImmutable);
		
	}
	
	static void printValues(Integer isAgeImmutable, String isNameImmutable,Double isSalaryImmutable){
		isAgeImmutable = 20;		
		isNameImmutable = "ABCD";
		isSalaryImmutable = 200.0;
		System.out.println("I am tampering orginal values: Integer: "+isAgeImmutable+" String: "+
		isNameImmutable+" Double: "+isSalaryImmutable);
	}
	
	

}


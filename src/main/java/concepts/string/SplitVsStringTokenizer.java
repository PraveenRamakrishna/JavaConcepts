package concepts.string;

public class SplitVsStringTokenizer {

	public static void main(String[] args) {
		
		String[] array = "PRAVEEN|RAMAKRISHNA".split("\\|");
		for (String string : array) {
			System.out.println(string);
		}
	}

}

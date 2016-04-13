package concepts.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * NOTE: In order to enable assert, please do pass -ea as VM argument 	
 */

public class UnderstandGeneralPurposeMapImplementation {

	private static Map<String, Integer> map;

	private static final int MAX_ENTRIES = 3;
	
	public static void main(String[] args) {

		frequencyCounterUsingMapImplementations();
		
		tryRemoveEldestElement();	

	}

	private static void frequencyCounterUsingMapImplementations() {
		System.out.println("Key in sentance / words to count frequeny: ");
		Scanner sentanceScanner = new Scanner(System.in);
		String[] words = sentanceScanner.nextLine().split("\\s");
		
		System.out.println("Option: 1. Just Frequency Table \n 2. Frequency Table in Alphabetical Order \n 3. Frequenct Table in Order of Insertion ");
		Scanner optionScanner = new Scanner(System.in);
			switch(optionScanner.nextInt()){
				case 1: 
					map = new HashMap<String, Integer>();
					break;
				case 2:
					map = new TreeMap<String, Integer>();
					break;
				case 3:
					map = new LinkedHashMap<String, Integer>();
					break;
				default:
					map = new HashMap<String, Integer>();
			}
		
		for (int i = 0; i < words.length; i++) {
			Integer frequency = map.get(words[i]);
			map.put(words[i], null == frequency ? 1 : frequency + 1);
		}
		
		System.out.println("Distinct Words:" + map.size());
		System.out.println("Frequency Table: " + map.toString());
	}

	private static void tryRemoveEldestElement() {
		map = new LinkedHashMap<String, Integer>() {
			@Override
			protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
				return map.size() > MAX_ENTRIES;
			};
		};
		map.put("2010", 2010);
		map.put("1990", 1990);
		map.put("1980", 1980);
		map.put("2000", 2000);
		map.put("2020", 2020);
		//eldest entry is based on Insertion order, not based on data.
		assert "{1980=1980, 2000=2000, 2020=2020}".equals(map.toString());
	}
	
}

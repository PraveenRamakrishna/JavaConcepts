package concepts.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods<E> {
	public  List<E> toList(E[] arr) {
		List<E> list = new ArrayList<E>();
		for (E elt : arr) 
			list.add(elt);
		return list;
	}
}

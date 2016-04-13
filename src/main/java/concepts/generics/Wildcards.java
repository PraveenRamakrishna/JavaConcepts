package concepts.generics;

import java.util.List;


/**
 * 
 * List<? extends Shape> is an example of a bounded wildcard.
 *
 */
abstract class Shape {
    public abstract void draw(Canvas c);
}

class Circle extends Shape {
	private int x, y, radius;
    public void draw(Canvas c) {
    }
}

class Rectangle extends Shape {
    private int x, y, width, height;
    public void draw(Canvas c) {
    }
}


class Canvas {
    public void draw(Shape s) {
        s.draw(this);
   }
   
    /**
     * List<? extends Shape> is an example of a bounded wildcard. 
     * The ? stands for an unknown type, just like the wildcards we saw earlier. 
     * However, in this case, we know that this unknown type is in fact a subtype of Shape. 
     * (Note: It could be Shape itself, or some subclass; it need not literally extend Shape.) 
     * We say that Shape is the upper bound of the wildcard.
     */
    public void drawAll(List<? extends Shape> shapes) {
	    for (Shape s: shapes) {
	        s.draw(this);
	   }
   }
}

public class Wildcards {
	
}

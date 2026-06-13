public class ShapeDemo {
    
    public static void printAreas(Shape[] shapes) {
        System.out.println("\n=== POLYMORPHIC AREA CALCULATION ===");
        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("Shape %d (%s): Area = %.2f%n",
                    i + 1, shapes[i].getClass().getSimpleName(), shapes[i].getArea());
        }
    }
    
    public static Shape largest(Shape[] shapes) {
        if (shapes.length == 0) return null;
        Shape largest = shapes[0];
        for (Shape s : shapes) {
            if (s.getArea() > largest.getArea()) {
                largest = s;
            }
        }
        return largest;
    }
    
    public static void main(String[] args) {
        System.out.println("=== SHAPE HIERARCHY DEMONSTRATION ===\n");
        
        try {
            System.out.println("--- CREATING SHAPES ---");
            Circle circle = new Circle(5.0);
            Rectangle rectangle = new Rectangle(4.0, 6.0);
            Triangle triangle = new Triangle(3.0, 4.0, 5.0);
            Circle smallCircle = new Circle(2.5);
            Rectangle square = new Rectangle(5.0, 5.0);
            Triangle equilateral = new Triangle(6.0, 6.0, 6.0);
            
            System.out.println(circle);
            System.out.println(rectangle);
            System.out.println(triangle);
            System.out.println(smallCircle);
            System.out.println(square);
            System.out.println(equilateral);
            
            System.out.println("\n--- RESIZE DEMONSTRATION ---");
            System.out.println("Before resize: " + circle);
            circle.resize(2.0);
            System.out.println("After resize x2: " + circle);
            
            Shape[] shapes = {circle, rectangle, triangle, smallCircle, square, equilateral};
            printAreas(shapes);
            
            System.out.println("\n--- LARGEST SHAPE ---");
            System.out.println("Largest area: " + largest(shapes));
            
            System.out.println("\n--- EXCEPTION HANDLING ---");
            System.out.println("Attempting invalid triangle (1, 1, 5):");
            try {
                Triangle bad = new Triangle(1.0, 1.0, 5.0);
            } catch (InvalidShapeException e) {
                System.out.println("Caught: " + e.getMessage());
            }
            
            System.out.println("\nAttempting invalid circle (radius = -3):");
            try {
                Circle bad = new Circle(-3.0);
            } catch (InvalidShapeException e) {
                System.out.println("Caught: " + e.getMessage());
            }
            
            System.out.println("\nAttempting invalid resize (factor = -2):");
            try {
                rectangle.resize(-2.0);
            } catch (InvalidShapeException e) {
                System.out.println("Caught: " + e.getMessage());
            }
            
        } catch (InvalidShapeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("\n=== THEORETICAL EXPLANATIONS ===");
        System.out.println("\n1. Dynamic Binding (Polymorphism):");
        System.out.println("   In printAreas(), shapes[i].getArea() calls different methods");
        System.out.println("   based on actual object type at RUNTIME.");
        System.out.println("   Circle uses πr², Rectangle uses width×height, Triangle uses Heron's formula.");
        
        System.out.println("\n2. Why Shape is Abstract:");
        System.out.println("   - getArea(), getPerimeter(), resize() cannot be implemented generically");
        System.out.println("   - Serves as a contract/blueprint for all subclasses");
        System.out.println("   - A generic 'Shape' without dimensions doesn't exist in reality");
        
        System.out.println("\n3. What happens with new Shape():");
        System.out.println("   Compiler Error: 'Shape is abstract; cannot be instantiated'");
        
        System.out.println("\n4. Checked Exception:");
        System.out.println("   InvalidShapeException is CHECKED (extends Exception)");
        System.out.println("   Reason: Invalid dimensions are recoverable errors where");
        System.out.println("   the caller should be forced to handle them.");
        
        System.out.println("\n=== DEMONSTRATION COMPLETE ===");
    }
}
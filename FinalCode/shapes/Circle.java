public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) throws InvalidShapeException {
        this("white", false, radius);
    }
    
    public Circle(String color, boolean filled, double radius) throws InvalidShapeException {
        super(color, filled);
        if (radius <= 0) {
            throw new InvalidShapeException("Radius must be positive: " + radius);
        }
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive: " + factor);
        }
        radius *= factor;
    }
    
    public double getRadius() { return radius; }
    
    @Override
    public String toString() {
        return String.format("Circle[radius=%.2f, color=%s, area=%.2f]",
                radius, color, getArea());
    }
}
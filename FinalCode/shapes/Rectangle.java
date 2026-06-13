public class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) throws InvalidShapeException {
        this("white", false, width, height);
    }
    
    public Rectangle(String color, boolean filled, double width, double height) 
            throws InvalidShapeException {
        super(color, filled);
        if (width <= 0 || height <= 0) {
            throw new InvalidShapeException("Width and height must be positive: " + width + ", " + height);
        }
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    @Override
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive: " + factor);
        }
        width *= factor;
        height *= factor;
    }
    
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    
    @Override
    public String toString() {
        return String.format("Rectangle[%.2fx%.2f, color=%s, area=%.2f]",
                width, height, color, getArea());
    }
}
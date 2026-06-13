public abstract class Shape {
    protected String color;
    protected boolean filled;
    
    public Shape() {
        this.color = "white";
        this.filled = false;
    }
    
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void resize(double factor) throws InvalidShapeException;
    
    @Override
    public String toString() {
        return String.format("Shape[color=%s, filled=%s, area=%.2f, perimeter=%.2f]",
                color, filled, getArea(), getPerimeter());
    }
}
import java.util.Arrays;

public class Triangle extends Shape {
    private double side1, side2, side3;
    
    public Triangle(double side1, double side2, double side3) throws InvalidShapeException {
        this("white", false, side1, side2, side3);
    }
    
    public Triangle(String color, boolean filled, double s1, double s2, double s3) 
            throws InvalidShapeException {
        super(color, filled);
        
        if (s1 <= 0 || s2 <= 0 || s3 <= 0) {
            throw new InvalidShapeException("All sides must be positive: " + s1 + ", " + s2 + ", " + s3);
        }
        
        if (s1 + s2 <= s3 || s1 + s3 <= s2 || s2 + s3 <= s1) {
            throw new InvalidShapeException("Triangle inequality violated: " + s1 + ", " + s2 + ", " + s3);
        }
        
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }
    
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public void resize(double factor) throws InvalidShapeException {
        if (factor <= 0) {
            throw new InvalidShapeException("Resize factor must be positive: " + factor);
        }
        side1 *= factor;
        side2 *= factor;
        side3 *= factor;
    }
    
    public boolean isRightAngled() {
        double[] sides = {side1, side2, side3};
        Arrays.sort(sides);
        return Math.abs(Math.pow(sides[2], 2) - (Math.pow(sides[0], 2) + Math.pow(sides[1], 2))) < 0.0001;
    }
    
    @Override
    public String toString() {
        String type = isRightAngled() ? "Right" : "Scalene";
        return String.format("Triangle[%s(%.1f,%.1f,%.1f), area=%.2f]",
                type, side1, side2, side3, getArea());
    }
}
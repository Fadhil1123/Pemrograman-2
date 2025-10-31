package Modul5;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double r, double w){
        super("Prak.Rectangle");
        length=r;
        width=w;
    }

    public double area(){
        return length * width;
    }

    public String toString(){
        return super.toString() + " of radius " + length + " " + width;
    }
}

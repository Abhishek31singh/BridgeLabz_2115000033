class Circle{
    double radius;
    Circle(double radius){
        System.out.println("The radius given by user "+radius);
        
    }
    Circle(){
        this(3.25);
        this.radius = 0.0;
        System.out.println("Default constructor called with radius "+radius);
    }
}
public class ConstructorChaining {
    public static void main(String[] args) {
        
        new Circle();
    }
}

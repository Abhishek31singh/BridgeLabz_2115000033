class Student{
    public int rollNumber;
    protected String name;
    private double cgpa;
    Student(int rollNumber, String name, double cgpa){
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }
    public double getCGPA(){
        return cgpa;
    }
    public void setCGPA(double cgpa){
        this.cgpa = cgpa;
    }

    public void modifyCGPA(double newCGPA){
        cgpa = newCGPA;
    }

    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }
}

class PostgraduateStudent extends Student{
    public PostgraduateStudent(int rollNumber, String name, double cgpa) {
        super(rollNumber, name, cgpa);
    }
        public void displayPGDetails() {
            System.out.println("Postgraduate Student:");
            System.out.println("Roll Number: " + rollNumber);  
            System.out.println("Name: " + name);      
        }
    
} 
public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student student = new Student(101, "Alice", 8.5);
        student.displayDetails();
        student.setCGPA(9.2);
        System.out.println("Updated CGPA: " + student.getCGPA());
        PostgraduateStudent pgStudent = new PostgraduateStudent(201, "Bob", 9.0);
        pgStudent.displayPGDetails();
    }
}

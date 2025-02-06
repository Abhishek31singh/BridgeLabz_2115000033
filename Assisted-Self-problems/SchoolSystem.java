class Course {
    private String courseName;
    private Student student1, student2;
    public Course(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseName() {
        return courseName;
    }
    public void enrollStudent(Student student) {
        if (student1 == null) {
            student1 = student;
        } else if (student2 == null) {
            student2 = student;
        } else {
            System.out.println("Course " + courseName + " is full!");
        }
    }
    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName + " | Enrolled Students:");
        if (student1 != null) System.out.println("  - " + student1.getName());
        if (student2 != null) System.out.println("  - " + student2.getName());
    }
}

class Student {
    private String name;
    private Course course1, course2;
    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void enrollInCourse(Course course) {
        if (course1 == null) {
            course1 = course;
            course.enrollStudent(this);
        } else if (course2 == null) {
            course2 = course;
            course.enrollStudent(this);
        } else {
            System.out.println(name + " cannot enroll in more courses!");
        }
    }
    public void showEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        if (course1 != null) System.out.println("  - " + course1.getCourseName());
        if (course2 != null) System.out.println("  - " + course2.getCourseName());
    }
}
class School {
    private String schoolName;
    private Student student1, student2;
    public School(String schoolName) {
        this.schoolName = schoolName;
    }
    public void addStudent(Student student) {
        if (student1 == null) {
            student1 = student;
        } else if (student2 == null) {
            student2 = student;
        } else {
            System.out.println("School " + schoolName + " is full!");
        }
    }
    public void showAllStudents() {
        System.out.println("School: " + schoolName + " | Students:");
        if (student1 != null) System.out.println("  - " + student1.getName());
        if (student2 != null) System.out.println("  - " + student2.getName());
    }
}
public class SchoolSystem {
    public static void main(String[] args) {
        School school = new School("Greenwood High");
        Student alice = new Student("Alice");
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        alice.enrollInCourse(math);
        alice.enrollInCourse(science);
    
        school.addStudent(alice);
     
        school.showAllStudents();
        alice.showEnrolledCourses();
       
        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}

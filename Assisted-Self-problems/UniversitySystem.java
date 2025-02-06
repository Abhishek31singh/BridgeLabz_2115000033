class Faculty {
    private String name;
    public Faculty(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class Department {
    private String deptName;
    public Department(String deptName) {
        this.deptName = deptName;
    }
    public String getDeptName() {
        return deptName;
    }
}
class University {
    private String universityName;
    private Department dept1, dept2; 
    public University(String universityName, String dept1Name, String dept2Name) {
        this.universityName = universityName;
        this.dept1 = new Department(dept1Name);
        this.dept2 = new Department(dept2Name);
    }

    public void showUniversityDetails() {
        System.out.println("University: " + universityName);
        System.out.println("  Department: " + dept1.getDeptName());
        System.out.println("  Department: " + dept2.getDeptName());
    }
    public void shutdown() {
        System.out.println("Shutting down " + universityName + "... All departments are deleted.");
        this.dept1 = null;
        this.dept2 = null;
    }
}
public class UniversitySystem {
    public static void main(String[] args) {
        University uni = new University("Harvard University", "Computer Science", "Physics");
        Faculty profAlice = new Faculty("Dr. Alice");
        Faculty profBob = new Faculty("Dr. Bob");
        uni.showUniversityDetails();
        System.out.println("Faculty Members:");
        System.out.println("  - " + profAlice.getName());
        System.out.println("  - " + profBob.getName());
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("   Employee: " + name);
    }
}
class Department {
    private String deptName;
    private Employee employee; 
    public Department(String deptName, String employeeName) {
        this.deptName = deptName;
        this.employee = new Employee(employeeName);
    }
    public void showDetails() {
        System.out.println(" Department: " + deptName);
        employee.showDetails();
    }
}
class Company {
    private String companyName;
    private Department dept1, dept2;
    public Company(String companyName, String dept1Name, String emp1Name, String dept2Name, String emp2Name) {
        this.companyName = companyName;
        this.dept1 = new Department(dept1Name, emp1Name);
        this.dept2 = new Department(dept2Name, emp2Name);
    }

    public void showCompanyDetails() {
        System.out.println("Company: " + companyName);
        dept1.showDetails();
        dept2.showDetails();
    }
    public void shutdown() {
        System.out.println("Shutting down " + companyName + "... All departments and employees removed.");
        this.dept1 = null;
        this.dept2 = null;
    }
}
public class CompanySystem {
    public static void main(String[] args) {
        Company myCompany = new Company("TechCorp", "IT", "Alice", "HR", "Bob");
        myCompany.showCompanyDetails();
        myCompany.shutdown();
    }
}

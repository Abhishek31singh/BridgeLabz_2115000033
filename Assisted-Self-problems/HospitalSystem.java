class Doctor {
    private String name;
    private Patient patient1, patient2;
    public Doctor(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void consult(Patient patient) {
        if (patient1 == null) {
            patient1 = patient;
        } else if (patient2 == null) {
            patient2 = patient;
        } else {
            System.out.println("Doctor " + name + " cannot take more patients!");
            return;
        }
        patient.addDoctor(this);
        System.out.println("Consultation: Dr. " + name + " is consulting " + patient.getName());
    }
    public void showPatients() {
        System.out.println("Dr. " + name + " is seeing the following patients:");
        if (patient1 != null) System.out.println("  - " + patient1.getName());
        if (patient2 != null) System.out.println("  - " + patient2.getName());
    }
}
class Patient {
    private String name;
    private Doctor doctor1, doctor2;
    public Patient(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void addDoctor(Doctor doctor) {
        if (doctor1 == null) {
            doctor1 = doctor;
        } else if (doctor2 == null) {
            doctor2 = doctor;
        } else {
            System.out.println(name + " cannot consult more doctors!");
        }
    }
    public void showDoctors() {
        System.out.println(name + " has consulted with:");
        if (doctor1 != null) System.out.println("  - Dr. " + doctor1.getName());
        if (doctor2 != null) System.out.println("  - Dr. " + doctor2.getName());
    }
}
class Hospital {
    private String hospitalName;
    private Doctor doctor1, doctor2;
    private Patient patient1, patient2;
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    public void addDoctor(Doctor doctor) {
        if (doctor1 == null) {
            doctor1 = doctor;
        } else if (doctor2 == null) {
            doctor2 = doctor;
        } else {
            System.out.println("Hospital " + hospitalName + " has enough doctors!");
        }
    }
    public void addPatient(Patient patient) {
        if (patient1 == null) {
            patient1 = patient;
        } else if (patient2 == null) {
            patient2 = patient;
        } else {
            System.out.println("Hospital " + hospitalName + " has enough patients!");
        }
    }
    public void showHospitalDetails() {
        System.out.println("Hospital: " + hospitalName);
        if (doctor1 != null) System.out.println("  Doctor: " + doctor1.getName());
        if (doctor2 != null) System.out.println("  Doctor: " + doctor2.getName());
        if (patient1 != null) System.out.println("  Patient: " + patient1.getName());
        if (patient2 != null) System.out.println("  Patient: " + patient2.getName());
    }
}
public class HospitalSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");
        Doctor drSmith = new Doctor("Smith");
        Doctor drJones = new Doctor("Jones");
        Patient alice = new Patient("Alice");
        Patient bob = new Patient("Bob");
        hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);
        hospital.addPatient(alice);
        hospital.addPatient(bob);
        drSmith.consult(alice);
        drSmith.consult(bob);
        drJones.consult(alice);
        hospital.showHospitalDetails();
        drSmith.showPatients();
        drJones.showPatients();
        alice.showDoctors();
        bob.showDoctors();
    }
}

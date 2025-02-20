import java.util.*;

class InsurancePlan {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePlan(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Name: " + policyholderName + ", Expiry: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePlan that = (InsurancePlan) obj;
        return policyNumber.equals(that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}

class PolicyManager {
    private Set<InsurancePlan> hashSetPolicies;
    private Set<InsurancePlan> linkedHashSetPolicies;
    private Set<InsurancePlan> treeSetPolicies;

    public PolicyManager() {
        hashSetPolicies = new HashSet<>();
        linkedHashSetPolicies = new LinkedHashSet<>();
        treeSetPolicies = new TreeSet<>(Comparator.comparing(InsurancePlan::getExpiryDate));
    }

    public void addPolicyToHashSet(InsurancePlan policy) {
        hashSetPolicies.add(policy);
    }

    public void addPolicyToLinkedHashSet(InsurancePlan policy) {
        linkedHashSetPolicies.add(policy);
    }

    public void addPolicyToTreeSet(InsurancePlan policy) {
        treeSetPolicies.add(policy);
    }

    public void displayPolicies(Set<InsurancePlan> set) {
        for (InsurancePlan policy : set) {
            System.out.println(policy);
        }
    }

    public Set<InsurancePlan> getPoliciesExpiringSoon() {
        Set<InsurancePlan> expiringSoon = new HashSet<>();
        Date today = new Date();
        long thirtyDaysInMilliSec = 30L * 24 * 60 * 60 * 1000;
        for (InsurancePlan policy : treeSetPolicies) {
            if (policy.getExpiryDate().getTime() - today.getTime() <= thirtyDaysInMilliSec) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public Set<InsurancePlan> getPoliciesByCoverageType(String coverageType) {
        Set<InsurancePlan> filteredPolicies = new HashSet<>();
        for (InsurancePlan policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    public Set<InsurancePlan> getDuplicatePolicies() {
        Set<InsurancePlan> duplicates = new HashSet<>();
        Set<String> policyNumbers = new HashSet<>();
        for (InsurancePlan policy : hashSetPolicies) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public void comparePerformance() {
        long startTime, endTime;
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            addPolicyToHashSet(new InsurancePlan("P" + i, "Name" + i, new Date(System.currentTimeMillis() + 100000L), "Health", 100.0));
        }
        endTime = System.nanoTime();
        System.out.println("HashSet add time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            addPolicyToLinkedHashSet(new InsurancePlan("P" + i, "Name" + i, new Date(System.currentTimeMillis() + 100000L), "Health", 100.0));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            addPolicyToTreeSet(new InsurancePlan("P" + i, "Name" + i, new Date(System.currentTimeMillis() + 100000L), "Health", 100.0));
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet add time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (InsurancePlan policy : hashSetPolicies) {
            policy.getPolicyNumber();
        }
        endTime = System.nanoTime();
        System.out.println("HashSet search time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (InsurancePlan policy : linkedHashSetPolicies) {
            policy.getPolicyNumber();
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet search time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (InsurancePlan policy : treeSetPolicies) {
            policy.getPolicyNumber();
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet search time: " + (endTime - startTime) + " ns");
    }

    public Set<InsurancePlan> getHashSetPolicies() {
        return hashSetPolicies;
    }
}

public class InsurancePolicyApp {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date expiryDate1 = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 20);
        Date expiryDate2 = calendar.getTime();

        InsurancePlan policy1 = new InsurancePlan("P001", "Rahul", expiryDate1, "Health", 200.0);
        InsurancePlan policy2 = new InsurancePlan("P002", "Ronak", expiryDate2, "Auto", 150.0);
        InsurancePlan policy3 = new InsurancePlan("P003", "Ram", expiryDate1, "Home", 180.0);
        InsurancePlan policy4 = new InsurancePlan("P001", "Rahul", expiryDate1, "Health", 200.0);

        manager.addPolicyToHashSet(policy1);
        manager.addPolicyToHashSet(policy2);
        manager.addPolicyToHashSet(policy3);
        manager.addPolicyToHashSet(policy4);

        manager.addPolicyToLinkedHashSet(policy1);
        manager.addPolicyToLinkedHashSet(policy2);
        manager.addPolicyToLinkedHashSet(policy3);
        manager.addPolicyToLinkedHashSet(policy4);

        manager.addPolicyToTreeSet(policy1);
        manager.addPolicyToTreeSet(policy2);
        manager.addPolicyToTreeSet(policy3);
        manager.addPolicyToTreeSet(policy4);

        System.out.println("All policies in HashSet:");
        manager.displayPolicies(manager.getHashSetPolicies());

        System.out.println("\nPolicies expiring soon:");
        manager.displayPolicies(manager.getPoliciesExpiringSoon());

        System.out.println("\nHealth coverage policies:");
        manager.displayPolicies(manager.getPoliciesByCoverageType("Health"));

        System.out.println("\nDuplicate policies:");
        manager.displayPolicies(manager.getDuplicatePolicies());

        System.out.println("\nPerformance Comparison:");
        manager.comparePerformance();
    }
}

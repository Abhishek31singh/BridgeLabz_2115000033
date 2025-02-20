import java.util.*;
import java.time.*;

public class InsurancePolicyManagement {
    public static void main(String[] args) {
        PolicyManage policyManager = new PolicyManage();

        policyManager.addPolicy("P001", new InsurancePolicy("John Doe", LocalDate.of(2023, 3, 15)));
        policyManager.addPolicy("P002", new InsurancePolicy("Alice Smith", LocalDate.of(2023, 5, 20)));
        policyManager.addPolicy("P003", new InsurancePolicy("John Doe", LocalDate.of(2023, 2, 10)));

        System.out.println("Policy with P001: " + policyManager.getPolicy("P001"));
        System.out.println("Policies expiring within 30 days: " + policyManager.getExpiringPolicies());
        System.out.println("Policies for John Doe: " + policyManager.getPoliciesByHolder("John Doe"));

        policyManager.removeExpiredPolicies();
        System.out.println("Policies after removing expired: " + policyManager.getAllPolicies());
    }
}

class InsurancePolicy {
    private String policyholderName;
    private LocalDate expiryDate;

    public InsurancePolicy(String policyholderName, LocalDate expiryDate) {
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policyholder: " + policyholderName + ", Expiry Date: " + expiryDate;
    }
}

class PolicyManage {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
    private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private Map<LocalDate, List<InsurancePolicy>> expirySortedMap = new TreeMap<>();

    public void addPolicy(String policyNumber, InsurancePolicy policy) {
        policyMap.put(policyNumber, policy);
        orderedPolicyMap.put(policyNumber, policy);
        expirySortedMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public InsurancePolicy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<InsurancePolicy> getExpiringPolicies() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalDate next30Days = currentDate.plusDays(30);

        for (InsurancePolicy policy : policyMap.values()) {
            if (!policy.getExpiryDate().isBefore(currentDate) && policy.getExpiryDate().isBefore(next30Days)) {
                expiringPolicies.add(policy);
            }
        }

        return expiringPolicies;
    }

    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        List<InsurancePolicy> policiesByHolder = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                policiesByHolder.add(policy);
            }
        }

        return policiesByHolder;
    }

    public void removeExpiredPolicies() {
        LocalDate currentDate = LocalDate.now();
        Iterator<Map.Entry<String, InsurancePolicy>> iterator = policyMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, InsurancePolicy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(currentDate)) {
                iterator.remove();
            }
        }
    }

    public Map<String, InsurancePolicy> getAllPolicies() {
        return policyMap;
    }
}

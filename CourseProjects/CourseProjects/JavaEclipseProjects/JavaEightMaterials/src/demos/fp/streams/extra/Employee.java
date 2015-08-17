package demos.fp.streams.extra;

import java.util.Arrays;
import java.util.List;

public class Employee {
    public Employee(String name, int salaryBand, Department department, Address ... addresses) {
        this.name = name;
        this.salaryBand = salaryBand;
        this.department = department;
        this.addresses = Arrays.asList(addresses);
    }
    public String getName() {
        return name;
    }
    public int getSalaryBand() {
        return salaryBand;
    }
    public Department getDepartment() {
        return department;
    }
    public List<Address> getAddresses() {
        return addresses;
    }
    public String toString() {
        return name;
    }
    private String name;
    private int salaryBand;
    private Department department;
    private List<Address> addresses;
}

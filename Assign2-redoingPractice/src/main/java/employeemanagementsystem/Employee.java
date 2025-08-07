package employeemanagementsystem;

import java.util.Objects;

public abstract class Employee {
    protected String name;
    protected int id;
    protected double baseSalary;

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public Employee() {
        this.name = "";
        this.id = 0;
        this.baseSalary = 0.0;
    }

    public abstract double calculateSalary();

    public static  void displayDetails() {
        return toString();
    }

    @Override
    public String toString() {
        return
                "Employee name:  " + name +
                        " Employee id " + id +
                        "Base Salary " + baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(baseSalary, employee.baseSalary) == 0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, baseSalary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}


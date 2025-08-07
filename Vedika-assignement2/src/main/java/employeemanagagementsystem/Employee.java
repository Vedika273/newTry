package employeemanagagementsystem;

import java.util.Objects;

public abstract class Employee {
    private String name;
    private int id;
    private double baseSalary;

    public Employee() {
        this.name = " ";
        this.id = 0;
        this.baseSalary = 0;
    }

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    /**
     * method to calculate the salary of an employee
     * @return the salary of an employee
     */
    public abstract double calculateSalary();

    /** concrete method to display employee details
     */
    public void displayDetails() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n " + "ID: " + id + "\n" + ", Base Salary: " + baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(baseSalary, employee.baseSalary) == 0 && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, baseSalary);
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

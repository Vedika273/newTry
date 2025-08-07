package employeemanagagementsystem;

import java.util.Objects;

public class PartTimeEmployee extends Employee{

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee() {
        super();
        this.hourlyRate = 0;
        this.hoursWorked = 0;
    }

    public PartTimeEmployee(String name, int id, double baseSalary, int hoursWorked, double hourlyRate) {
        super(name, id, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Calculates the salary
     * @return the Salary
     */
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + " Hours worked: " + hoursWorked + "\n" + "Hourly Rate : " + hourlyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PartTimeEmployee that = (PartTimeEmployee) o;
        return hoursWorked == that.hoursWorked && Double.compare(hourlyRate, that.hourlyRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hoursWorked, hourlyRate);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}

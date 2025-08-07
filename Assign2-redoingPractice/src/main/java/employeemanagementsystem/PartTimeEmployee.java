package employeemanagementsystem;

import java.util.Objects;

public class PartTimeEmployee extends Employee{

    int hoursWorked;
    double hourlyRate;


    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public PartTimeEmployee() {
        super();
        this.hoursWorked = 0;
        this.baseSalary = 0.0;
    }

    public PartTimeEmployee(int hoursWorked, double baseSalary) {
        this.hoursWorked = 0;
        this.baseSalary = 0.0;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "hoursWorked=" + hoursWorked +
                ", hourlyRate=" + hourlyRate +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", baseSalary=" + baseSalary +
                '}' + super.toString();
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

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}

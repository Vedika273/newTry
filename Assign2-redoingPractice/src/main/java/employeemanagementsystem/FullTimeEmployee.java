package employeemanagementsystem;

import java.util.Objects;

public class FullTimeEmployee extends Employee implements BonusEligible{

    private int performanceRating ;
    @Override
    public double calculateSalary() {
        return baseSalary + performanceRating;
    }

    public FullTimeEmployee() {
        super();
        this.performanceRating = 0;
    }

    public FullTimeEmployee(String name, int id, double baseSalary, int performanceRating) {
        super(name, id, baseSalary);
        this.performanceRating = performanceRating;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "performanceRating=" + performanceRating +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", baseSalary=" + baseSalary +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FullTimeEmployee that = (FullTimeEmployee) o;
        return performanceRating == that.performanceRating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), performanceRating);
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int performanceRating) {
        this.performanceRating = performanceRating;
    }

    @Override
    public double calcBonus() {
        if (performanceRating >= 8 ) {
            return 0.10;
        } else {
            return 0.05;
        }
    }
}


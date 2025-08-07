package employeemanagagementsystem;

import java.util.Objects;

public class FullTimeEmployee extends Employee implements BonusEligible {

    private int performanceRating;

    public FullTimeEmployee() {
        super();
        this.performanceRating = 0;
    }

    public FullTimeEmployee(String name, int id , double baseSalary, int performanceRating) {
        super(name, id, baseSalary);
        this.performanceRating = performanceRating;
    }

    /**
     * Calculate the Bonus
     * @return the performance Bonus value
     */
    @Override
    public double calcBonus() {
        if (performanceRating >= 8) {
            return getBaseSalary() *0.10;
        } else {
            return getBaseSalary() * 0.05;
        }
    }

    /**
     * Calculates the new Salary including the bonus
     * @return the Salary after added bonus
     */
    @Override
    public double calculateSalary() {
        double performanceBonus = calcBonus();
        return getBaseSalary() + performanceBonus;
    }

    @Override
    public String toString() {
        return super.toString() +  "\n " + "PerformanceRating : " + performanceRating;
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
}

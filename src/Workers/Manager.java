package Workers;

public class Manager extends Employee {
    private double bonusPercentage = 0;

    public Manager(String name, double baseSalary){
        super(name, baseSalary);
    }

    public double getSalaryAfterIncrease(){
        double salaryIncrease = getBaseSalary() * this.bonusPercentage;
        return getBaseSalary() + salaryIncrease;
    }

    public void setBonusPercentage(double bonusPercentage){
        this.bonusPercentage = bonusPercentage;
    }
}

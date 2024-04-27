package Workers;

public abstract class Employee {
    private String name;
    private double baseSalary;

    Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }
}

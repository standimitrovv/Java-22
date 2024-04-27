import Exceptions.InsufficientPaperAmountException;
import Workers.Employee;
import Workers.Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PrintingHouse {
    private List<Employee> employees;
    private List<Publication> printedPublications;
    private List<PrintingMachine> printingMachines;

    private final double REVENUE_THRESHOLD = 30;
    private final double MANAGERS_PERCENTAGE_INCREASE = 0.03;
    private final int DISCOUNT_THRESHOLD = 20;
    private final double DISCOUNT_PERCENTAGE = 0.05;

    PrintingHouse(){
        employees = new ArrayList<Employee>();
        printedPublications = new ArrayList<Publication>();
        printingMachines = new ArrayList<PrintingMachine>();
    }

    public void writeDataToFile(String fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write("Printed Publications: " + getPrintedPublications());
            writer.newLine();

            writer.write("Revenue: " + calculateRevenue());
            writer.newLine();

            writer.write("Expenses: " + calculateExpenses());
            writer.newLine();
            System.out.println("The printed publications, revenue, and expenses were written in the file successfully!" + "\n");
        }catch (IOException e){
            System.out.println("An unexpected error occurred while writing to file" + "\n");
        }
    }

    public void readDataFromFile(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e){
            System.out.println("An unexpected error occurred while reading from file" + "\n");
        }
    }

    public void printPublication(Publication publication)  {

        for(PrintingMachine printingMachine: getPrintingMachines()){
            try {
                printingMachine.printPublication(publication);
                addPrintedPublication(publication);
                return;
            } catch (InsufficientPaperAmountException e) {
                System.out.println(e);
                System.out.println("The '" + publication.getTitle() + "' publication was not printed." + "\n");
            }
        }
    }

    public double calculateExpenses(){
        return calculateSalaryExpenses() + calculatePaperExpenses();
    }

    private double calculateSalaryExpenses(){
        double sum = 0;
        for(Employee emp : getEmployees()){
            sum += emp.getBaseSalary();

            if(emp instanceof Manager && calculateRevenue() > REVENUE_THRESHOLD){
                Manager manager = (Manager) emp;
                manager.setBonusPercentage(MANAGERS_PERCENTAGE_INCREASE);
                sum += manager.getSalaryAfterIncrease();
            }
        }

        return sum;
    }

    private double calculatePaperExpenses(){
        double sum = 0;
        for(Publication p : getPrintedPublications()){
            sum += p.getPrice();
        }
        return sum;
    }

    public double calculateRevenue() {
        double revenue = 0;

        for(Publication publication: getPrintedPublications()){
            int amountOfPrintedPublications = getPrintedPublications().size();

            if(amountOfPrintedPublications <= DISCOUNT_THRESHOLD){
                revenue = amountOfPrintedPublications * publication.getPrice();
            } else {
                int discountedQuantity = amountOfPrintedPublications - DISCOUNT_THRESHOLD;
                revenue = (DISCOUNT_THRESHOLD * publication.getPrice()) + (discountedQuantity * publication.getPrice() * (1 - DISCOUNT_PERCENTAGE));
            }
        }

        return revenue;
    }

    public void addEmployee(Employee employee){
        getEmployees().add(employee);
    }

    public void addPrintingMachine(PrintingMachine printingMachine){
        getPrintingMachines().add(printingMachine);
    }

    private void addPrintedPublication(Publication publication) {
        getPrintedPublications().add(publication);
    }

    private List<Employee> getEmployees(){
        return this.employees;
    }

    public List<Publication> getPrintedPublications(){
        return this.printedPublications;
    }

    private List<PrintingMachine> getPrintingMachines(){
        return this.printingMachines;
    }
}

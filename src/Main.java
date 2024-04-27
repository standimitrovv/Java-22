import Paper.*;
import Workers.MachineOperator;
import Workers.Manager;

public class Main {
    public static void main(String[] args) {
        final String fileName = "randomTextFile.txt";

        PrintingHouse printingHouse = new PrintingHouse();

        MachineOperator machineOperator1 = new MachineOperator("Peter", 1000);
        MachineOperator machineOperator2 = new MachineOperator("George", 1000);
        Manager manager1 = new Manager("Greg", 2000);
        printingHouse.addEmployee(machineOperator1);
        printingHouse.addEmployee(machineOperator2);
        printingHouse.addEmployee(manager1);

        PrintingMachine machine1 = new PrintingMachine(30, true);
        PrintingMachine machine2 = new PrintingMachine(20, false);
        printingHouse.addPrintingMachine(machine1);
        printingHouse.addPrintingMachine(machine2);

        Publication publication1 = new Publication("GQ", 30, new Paper(PaperType.GLOSSY, PaperSize.A4));
        Publication publication2 = new Publication("The Wall Street Journal", 15, new Paper(PaperType.NEWSPAPER, PaperSize.A2));
        Publication publication3 = new Publication("Forbes 30 under 30", 20, new Paper(PaperType.REGULAR, PaperSize.A3));
        printingHouse.printPublication(publication1);
        printingHouse.printPublication(publication2);
        printingHouse.printPublication(publication3);

        double expenses = printingHouse.calculateExpenses();
        double revenue = printingHouse.calculateRevenue();
        System.out.println("Expenses: " + expenses);
        System.out.println("Revenue: " + revenue);

        printingHouse.writeDataToFile(fileName);
        printingHouse.readDataFromFile(fileName);
    }
}
package Workers;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @org.junit.jupiter.api.Test
    void getSalaryAfterIncrease() {
        Manager manager = new Manager("Peter", 2000);
        manager.setBonusPercentage(0.03);
        double salaryAfterIncrease = manager.getSalaryAfterIncrease();
        double expectedSalaryAfterIncrease = 2060;
        assertEquals(expectedSalaryAfterIncrease, salaryAfterIncrease);
    }
}
package student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class SalaryEmployeeTest {
    private SalaryEmployee employee;

    @BeforeEach
    public void setUp() {
        employee = new SalaryEmployee("Echo", "12345", 120000.0, 5000.0, 1500.0, 100.0);
    }

    @Test
    public void testRunPayroll() {
        double hoursWorked = 40;
        IPayStub payStub = employee.runPayroll(hoursWorked);

        assertNotNull(payStub);

        double expectedGrossPay = (double) 120000 / 24;
        double expectedTaxes = (expectedGrossPay - 100.0) * 0.2265;
        double expectedNetPay = expectedGrossPay - expectedTaxes - 100.0;

        assertEquals(expectedNetPay, payStub.getPay(), 0.01);
        assertEquals(expectedTaxes, payStub.getTaxesPaid(), 0.01);
    }


    @Test
    public void testToCSV() {
        String expectedCSV = "SALARY,Echo,12345,120000.0,100.0,5000.0,1500.0";
        assertEquals(expectedCSV, employee.toCSV());
    }
}
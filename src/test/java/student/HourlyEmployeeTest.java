package student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class HourlyEmployeeTest {
    private HourlyEmployee employee;

    @BeforeEach
    public void setUp() {
        employee = new HourlyEmployee("Echo", "12345", 20.0, 5000.0, 1500.0, 100.0);
    }

    @Test
    public void testRunPayroll_RegularHours() {
        double hoursWorked = 40;
        IPayStub payStub = employee.runPayroll(hoursWorked);

        assertNotNull(payStub);

        double expectedGrossPay = 40 * 20.0;
        double expectedTaxes = (expectedGrossPay - 100.0) * 0.2265;
        double expectedNetPay = expectedGrossPay - expectedTaxes - 100.0;

        assertEquals(expectedNetPay, payStub.getPay(), 0.01);
        assertEquals(expectedTaxes, payStub.getTaxesPaid(), 0.01);
    }

    @Test
    public void testRunPayroll_OvertimeHours() {
        double hoursWorked = 45;
        IPayStub payStub = employee.runPayroll(hoursWorked);

        assertNotNull(payStub);
        double expectedGrossPay = 40 * 20.0 + 5 * 1.5 * 20.0;
        double expectedTaxes = (expectedGrossPay - 100.0) * 0.2265;
        double expectedNetPay = expectedGrossPay - 100.0 - expectedTaxes;

        assertEquals(expectedNetPay, payStub.getPay(), 0.01);
        assertEquals(expectedTaxes, payStub.getTaxesPaid(), 0.01);
    }

    @Test
    public void testRunPayroll_NegativeHours() {
        double hoursWorked = -1;
        IPayStub payStub = employee.runPayroll(hoursWorked);
        assertNull(payStub);
    }

    @Test
    public void testToCSV() {
        String expectedCSV = "HOURLY,Echo,12345,20.0,100.0,5000.0,1500.0";
        assertEquals(expectedCSV, employee.toCSV());
    }
}
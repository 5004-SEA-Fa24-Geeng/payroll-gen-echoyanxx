package student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {
    @Test
    public void testBuildHourlyEmployeeFromCSV() {
        String csv = "HOURLY,Echo,12345,20.0,100.0,5000.0,1500.0";
        IEmployee employee = Builder.buildEmployeeFromCSV(csv);

        assertNotNull(employee);
        assertInstanceOf(HourlyEmployee.class, employee);

        HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
        assertEquals("Echo", hourlyEmployee.getName());
        assertEquals(5000.0, hourlyEmployee.getYTDEarnings(), 0.001);
        assertEquals(1500.0, hourlyEmployee.getYTDTaxesPaid(), 0.001);
        assertEquals(100.0, hourlyEmployee.getPretaxDeductions(), 0.001);
    }

    @Test
    public void testBuildSalaryEmployeeFromCSV() {
        String csv = "SALARY,Echo,67890,50000.0,200.0,25000.0,5000.0";
        IEmployee employee = Builder.buildEmployeeFromCSV(csv);

        assertNotNull(employee);
        assertInstanceOf(SalaryEmployee.class, employee);

        SalaryEmployee salaryEmployee = (SalaryEmployee) employee;
        assertEquals("Echo", salaryEmployee.getName());
        assertEquals(25000.0, salaryEmployee.getYTDEarnings(), 0.001);
        assertEquals(5000.0, salaryEmployee.getYTDTaxesPaid(), 0.001);
        assertEquals(200.0, salaryEmployee.getPretaxDeductions(), 0.001);
    }

    @Test
    public void testBuildTimeCardFromCSV() {
        String csv = "12345,40";
        ITimeCard timeCard = Builder.buildTimeCardFromCSV(csv);

        assertNotNull(timeCard, "TimeCard should not be null");
        assertEquals("12345", timeCard.getEmployeeID());
        assertEquals(40, timeCard.getHoursWorked());
    }
}
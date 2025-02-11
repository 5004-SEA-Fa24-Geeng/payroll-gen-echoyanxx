package student;

/**
 * Represents a salaried employee, including their personal details,
 * earnings, and tax deductions.
 */
public class SalaryEmployee implements IEmployee {

    /**
     * The name of the employee.
     */
    private final String name;

    /**
     * The unique ID of the employee.
     */
    private final String id;

    /**
     * The salary-based pay rate of the employee.
     */
    private final double payRate;

    /**
     * The pre-tax deductions applicable to the employee.
     */
    private final double pretaxDeductions;

    /**
     * The employment type, set as "SALARY".
     */
    private final String type;
    /**
     * the tax rate.
     */
    private final double taxRate = 0.2265;
    /**
     * The year-to-date earnings of the employee.
     */
    private double ytdEarnings;
    /**
     * The year-to-date taxes paid by the employee.
     */
    private double ytdTaxesPaid;

    /**
     * Constructs a new SalaryEmployee object with the specified details.
     *
     * @param name             The name of the employee.
     * @param id               The unique identifier of the employee.
     * @param payRate          The salary-based pay rate.
     * @param ytdEarnings      The year-to-date earnings of the employee.
     * @param ytdTaxesPaid     The year-to-date taxes paid by the employee.
     * @param pretaxDeductions The pre-tax deductions for the employee.
     */
    public SalaryEmployee(
            String name, String id, double payRate,
            double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {

        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
        this.type = "SALARY";
    }

    /**
     * Gets the employee's name.
     *
     * @return the name of the employee
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the employee's ID.
     *
     * @return the ID of the employee
     */
    @Override
    public String getID() {
        return this.id;
    }

    /**
     * Gets the employee's pay rate.
     *
     * @return the pay rate of the employee
     */
    @Override
    public double getPayRate() {
        return this.payRate;
    }

    /**
     * Gets the employee's Type as a string.
     * <p>
     * Either "HOURLY" or "SALARY" depending on the type of employee.
     * <p>
     * You may want to consider using an enum to store
     * the type, and using .name() to get the string representation.
     *
     * @return the type of the employee as a string
     */
    @Override
    public String getEmployeeType() {
        return this.type;
    }

    /**
     * Gets the YTD earnings of the employee.
     *
     * @return the YTD earnings of the employee
     */
    @Override
    public double getYTDEarnings() {
        return this.ytdEarnings;
    }

    /**
     * Gets the YTD taxes paid by the employee.
     *
     * @return the YTD taxes paid by the employee
     */
    @Override
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    }

    /**
     * Gets pretax deductions for the employee. Yes, on a normal paycheck this varies as either set
     * amounts or percents, and often more than one type of deduction.
     * <p>
     * For now, you can just assume a single pretax deduction as a whole dollar amount.
     *
     * @return the pretax deductions for the employee
     */
    @Override
    public double getPretaxDeductions() {
        return this.pretaxDeductions;
    }

    /**
     * Runs the employee's payroll.
     * <p>
     * This will calculate the pay for the current pay, update the YTD earnings, and update the
     * taxes paid YTD.
     * <p>
     * taxes are calculated as 1.45% for medicare, 6.2% for social security, and 15% for
     * withholding. or 22.65% total. They are calculated on the net pay (after pretax deductions).
     * <p>
     * For hourly employees, the pay is calculated as payRate * hoursWorked for the first 40 hours,
     * then payRate * 1.5 * (hoursWorked - 40) for overtime.
     * <p>
     * For salary employees, it is pay rate divided by 24 for two payments every month.
     * <p>
     * If either type of employee has < 0 hours, they are skipped this payroll period.
     * (suggestion return null, and skip adding nulls to your pays tub list)
     * <p>
     * Final net pay is calculated as pay - pretaxDeductions - taxes.
     * <p>
     * All numbers (across all methods) are rounded to the nearest cent. (2 decimal places)
     * <p>
     * SUGGESTION: You may want to use BigDecimal for the calculations to avoid floating point errors.
     * SUGGESTION: You may want to create an protected abstract calculateGrossPay(double hoursWorked)
     * method to calculate the gross pay for the pay period, as runPayroll is exactly
     * the same for both SalaryEmployee and HourlyEmployee, but calculateGrossPay is different.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return the pay stub for the current pay period
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        double grossPay;

        grossPay = this.payRate / 24; // 6250
        double taxes = (grossPay - this.pretaxDeductions) * taxRate;  // 1302.375
        double netPay = grossPay - this.pretaxDeductions - taxes; // 4,447.625
        this.ytdEarnings += netPay; // 16,447.625
        this.ytdTaxesPaid += taxes;

        return new PayStub(this.name, netPay, taxes, this.ytdEarnings, this.ytdTaxesPaid);
    }


    /**
     * Converts the employee to a CSV string.
     * <p>
     * Format of the String s as follows:
     * <p>
     * employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid
     * <p>
     * employee_type has the options for HOURLY or SALARY.
     * <p>
     * You do not have to worry about commas in the name or any other field.
     *
     * @return the employee as a CSV string
     */
    @Override
    public String toCSV() {
        String[] words = {this.type, this.name, this.id, String.valueOf(this.payRate),
                String.valueOf(this.pretaxDeductions),
                String.valueOf(this.ytdEarnings), String.valueOf(this.ytdTaxesPaid)};
        return String.join(",", words);
    }
}


package student;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Represents a pay stub for an employee, including earnings and tax details.
 */
public class PayStub implements IPayStub {
    /** The net pay after tax deductions. */
    private final double netPay;
    /** The total amount of taxes deducted. */
    private final double taxes;
    /** The name of the employee. */
    private final String name;
    /** The year-to-date earnings of the employee. */
    private final double ytdEarning;
    /** The year-to-date taxes paid by the employee. */
    private final double ytdTaxPay;
    /**
     * Constructs a PayStub object with the given details.
     *
     * @param name       The name of the employee.
     * @param netPay     The net pay after deductions.
     * @param taxes      The total taxes deducted.
     * @param ytdEarning The year-to-date earnings.
     * @param ytdTaxPay  The year-to-date tax payments.
     */
    public PayStub(String name, double netPay, double taxes, double ytdEarning, double ytdTaxPay) {
        this.name = name;
        this.netPay = netPay;
        this.taxes = taxes;
        this.ytdEarning = ytdEarning;
        this.ytdTaxPay = ytdTaxPay;
    }

    private static String round(double value) {
        // If the number ends in .00, use 1 decimal place, otherwise use 2
        double tenTimes = 10 * value;
        DecimalFormat df = (tenTimes == (int) tenTimes) ? new DecimalFormat("#.0") : new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(value);
    }

    /**
     * Gets the pay for the current pay period.
     *
     * @return the pay for the current pay period
     */
    @Override
    public double getPay() {
        return this.netPay;
    }

    /**
     * Gets the taxes paid for the current pay period.
     *
     * @return the taxes paid for the current pay period
     */
    @Override
    public double getTaxesPaid() {
        return this.taxes;
    }

    /**
     * Converts the PayStub object to a CSV string.
     * <p>
     * Format of the CSV string is: "employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid"
     *
     * @return the CSV string
     */
    @Override
    public String toCSV() {
        // Create a DecimalFormat instance with two decimal places
        DecimalFormat df = new DecimalFormat("#.0#");

        // Format the double value
        String roundedYtdEarnings = df.format(this.ytdEarning);
        String roundedTaxes = df.format(this.taxes);

        df.setRoundingMode(RoundingMode.HALF_UP);
        String roundedNetPay = df.format(this.netPay);

        String[] words = {this.name, roundedNetPay, roundedTaxes,
                roundedYtdEarnings, round(this.ytdTaxPay)};
        return String.join(",", words);
    }
}

package student;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PayStub implements IPayStub {
    double netPay;
    double taxes;
    String name;
    double ytdEarning;
    double ytdTaxPay;

    public PayStub(String name, double netPay, double taxes, double ytdEarning, double ytdTaxPay) {
        this.name = name;
        this.netPay = netPay;
        this.taxes = taxes;
        this.ytdEarning = ytdEarning;
        this.ytdTaxPay = ytdTaxPay;

    }

    private static String round(double value) {
        // If the number ends in .00, use 1 decimal place, otherwise use 2
        double ten_times = 10 * value;
        DecimalFormat df = (ten_times == (int) ten_times) ? new DecimalFormat("#.0") : new DecimalFormat("#.##");
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
        DecimalFormat df = new DecimalFormat("#.00");

        // Format the double value
        String roundedYtdEarnings = df.format(this.ytdEarning);


        String[] words = {this.name, String.format("%.2f", this.netPay), String.format("%.2f", this.taxes),
                roundedYtdEarnings, round(this.ytdTaxPay)};
        return String.join(",", words);
    }
}
package student;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {

    private Builder() {
    }


    /**
     * Builds an employee object from a CSV string.
     * <p>
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     *
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        String[] tokens = csv.split(",");
        if (tokens[0].equals("HOURLY")) {
            return new HourlyEmployee(tokens[1], tokens[2],
                    Double.parseDouble(tokens[3]), Double.parseDouble(tokens[5]),
                    Double.parseDouble(tokens[6]), Double.parseDouble(tokens[4]));
        } else {
            return new SalaryEmployee(tokens[1], tokens[2],
                    Double.parseDouble(tokens[3]), Double.parseDouble(tokens[5]),
                    Double.parseDouble(tokens[6]), Double.parseDouble(tokens[4]));

        }
    }


    /**
     * Converts a TimeCard from a CSV String.
     *
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] tokens = csv.split(",");
        return new TimeCard(tokens[0], Integer.parseInt(tokens[1]));
    }
}

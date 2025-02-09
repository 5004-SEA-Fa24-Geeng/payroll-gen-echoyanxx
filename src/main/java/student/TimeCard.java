package student;

/**
 * Represents a time card that tracks the number of hours worked by an employee.
 */
public class TimeCard implements ITimeCard {

    /** The unique identifier for the employee. */
    private final String id;

    /** The number of hours worked. */
    private final int hours;

    /**
     * Constructs a TimeCard object with the given employee ID and worked hours.
     *
     * @param id     The unique identifier of the employee.
     * @param hours  The number of hours worked.
     */
    public TimeCard(String id, int hours) {
        this.id = id;
        this.hours = hours;
    }

    /**
     * Gets the employee ID.
     *
     * @return the employee ID
     */
    @Override
    public String getEmployeeID() {
        return this.id;
    }

    /**
     * Gets the hours worked by the employee.
     *
     * @return the hours worked by the employee
     */
    @Override
    public double getHoursWorked() {
        return this.hours;
    }
}

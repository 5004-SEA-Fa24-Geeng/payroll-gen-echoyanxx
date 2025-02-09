package student;

public class TimeCard implements ITimeCard {
    private final String id;
    private final int hours;

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

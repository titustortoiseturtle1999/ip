package task;

import constants.Constants;

/**
 * Deadline class for the deadline task. A task with a "do by" date / time.
 */
public class Deadline extends Task{
    protected String by;

    /**
     * Constructor with specified description and by.
     * @param description Description of the task.
     * @param by Do by date of the deadline.
     */
    public Deadline(String description, String by) {
        super(description, Constants.DEADLINE_LABEL);
        this.by = by;
    }

    /**
     * Constructor that creates a new deadline from an array of input parameters.
     * @param parameters Array of input words that specify the details of the deadline.
     */
    public Deadline(String[] parameters) {
        super (parameters[2],Constants.DEADLINE_LABEL, parameters[1].equals(String.valueOf(Constants.TICK_ICON)));
        this.by = parameters[3];
    }

    @Override
    public String toString() {
        return "[" + this.classLabel + "] " +  super.getDescription() + " (by: " + by + ")";
    }

    /**
     * Override and Overloading for the toString function that includes an option for showing status.
     * @param showStatus true will return the status as part of the string, false will not.
     * @return String of the deadline.
     */
    @Override
    public String toString(boolean showStatus) {
        if (showStatus) {
            return toString() + " " + getStatusIcon();
        } else {
            return toString();
        }
    }
    public String getBy() {
        return by;
    }

    /**
     * Formats the deadline in preparation for saving to a file.
     * @return The string of the formatted deadline.
     */
    @Override
    public String formatForFile() {
        return this.classLabel + " # " + this.getStatusIcon() + " # " + this.getDescription() + " # " + this.getBy();
    }
}

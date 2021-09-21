package task;

import constants.Constants;

/**
 * Event class is a task with an at date/time.
 */
public class Event extends Task{
    private String at;

    /**
     * Constructor with specified description and at.
     * @param description Description of the task.
     * @param at Do at date of the event.
     */
    public Event(String description, String at) {
        super(description, Constants.EVENT_LABEL);
        this.at = at;
    }

    /**
     * Constructor that creates a new event from an array of input parameters.
     * @param parameters Array of input words that specify the details of the deadline.
     */
    public Event(String[] parameters) {
        super (parameters[2],Constants.EVENT_LABEL, parameters[1].equals(Constants.TICK_ICON));
        this.at = parameters[3];
    }
    @Override
    public String toString() {
        return "[" + this.classLabel + "] " + super.getDescription() + " (at: " + this.at + ")";
    }
    /**
     * Override and Overloading for the toString function that includes an option for showing status.
     * @param showStatus true will return the status as part of the string, false will not.
     * @return String of the event.
     */
    public String toString(boolean showStatus) {
        if (showStatus) {
            return toString() + " " + getStatusIcon();
        } else {
            return toString();
        }
    }

    public String getAt() {
        return this.at;
    }

    /**
     * Formats the event in preparation for saving to a file.
     * @return The string of the formatted event.
     */
    @Override
    public String formatForFile() {
        return this.classLabel + " # " + this.getStatusIcon() + " # " + this.getDescription() + " # " + this.getAt();
    }
}

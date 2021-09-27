package task;
import constants.Constants;

/**
 * Todo is a task with no extra features.
 */
public class ToDo extends Task{
    /**
     * Constructor with specified description.
     * @param description Description of the task.
     */
    public ToDo(String description) {
        super(description, Constants.TODO_LABEL);
    }

    /**
     * Constructor that creates a new deadline from an array of input parameters.
     * @param parameters Array of input words that specify the details of the deadline.
     */
    public ToDo(String[] parameters) {
        super(parameters[2], Constants.TODO_LABEL, parameters[1].equals(String.valueOf(Constants.TICK_ICON)));
    }

    @Override
    public String toString() {
        return "[" + this.classLabel + "] " + super.getDescription();
    }
    /**
     * Override and Overloading for the toString function that includes an option for showing status.
     * @param showStatus true will return the status as part of the string, false will not.
     * @return String of the todo.
     */
    @Override
    public String toString(boolean showStatus) {
        return "[" + this.classLabel + "] " + super.toString(showStatus);
    }

    /**
     * Formats the deadline in preparation for saving to a file.
     * @return The string of the formatted todo.
     */
    @Override
    public String formatForFile() {
        return this.classLabel + " # " + this.getStatusIcon() + " # " + this.getDescription();
    }

}

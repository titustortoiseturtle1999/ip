package task;

import constants.Constants;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String classLabel;

    /**
     * Constructor with description and a label, where status is set to false.
     * @param description Description of the task.
     * @param classLabel String indicating the visual associated with the type of task.
     */
    public Task (String description, String classLabel) {
        this.description = description;
        this.isDone = false;
        this.classLabel = classLabel;
    }

    /**
     * Constructor with description, label and status.
     * @param description Description of the task.
     * @param classLabel String indicating the visual associated with the type of task.
     * @param status Status of the task.
     */
    public Task(String description, String classLabel, boolean status) {
        this.description = description;
        this.isDone = status;
        this.classLabel = classLabel;
    }

    public String getStatusIcon() {
        return (isDone ? Constants.TICK_ICON : " ");
    }

    public void setStatus(boolean update) {
        this.isDone = update;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDone() {
        return isDone;
    }

    /**
     * Default toString method for all task objects.
     * @param showStatus True if status is to be shown.
     * @return The String representing the task.
     */
    public String toString(boolean showStatus) {
        if (showStatus) {
            return this.getDescription() + " " + getStatusIcon();
        } else {
            return this.getDescription();
        }
    }

    public String getClassIcon() {return classLabel;}

    /**
     * By default, task objects cannot be written to a file directly.
     * @return A String with an error message.
     */
    public String formatForFile() {return "Invalid! Cannot write type Task to file";}
}

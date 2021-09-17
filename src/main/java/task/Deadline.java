package task;

import Constants.Constants;

public class Deadline extends Task{
    protected String by;

    public Deadline(String description, String by) {
        super(description, Constants.DEADLINE_LABEL);
        this.by = by;
    }
    public Deadline(String[] parameters) {
        super (parameters[2],Constants.DEADLINE_LABEL, parameters[1].equals(Constants.TICK_ICON));
        this.by = parameters[3];
    }

    public String toString() {
        return "[" + this.classLabel + "] " +  super.getDescription() + " (by: " + by + ")";
    }
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

    @Override
    public String formatForFile() {
        return this.classLabel + " # " + this.getStatusIcon() + " # " + this.getDescription() + " # " + this.getBy();
    }
}

package task;

import Constants.Constants;

public class Event extends Task{
    private String at;

    public Event(String description, String at) {
        super(description, Constants.EVENT_LABEL);
        this.at = at;
    }
    public Event(String[] parameters) {
        super (parameters[2],Constants.EVENT_LABEL, parameters[1].equals(Constants.TICK_ICON));
        this.at = parameters[3];
    }
    @Override
    public String toString() {
        return "[" + this.classLabel + "] " + super.getDescription() + " (at: " + this.at + ")";
    }
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

    @Override
    public String formatForFile() {
        return this.classLabel + " # " + this.getStatusIcon() + " # " + this.getDescription() + " # " + this.getAt();
    }
}

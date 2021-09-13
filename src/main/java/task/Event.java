package task;

public class Event extends Task{
    private String at;

    public Event(String description, String at) {
        super(description, "E");
        this.at = at;
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
        return "E # " + this.getStatusIcon() + " # " + this.getDescription() + " # " + this.getAt();
    }
}

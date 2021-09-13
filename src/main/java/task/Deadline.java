package task;

public class Deadline extends Task{
    protected String by;

    public Deadline(String description, String by) {
        super(description, "D");
        this.by = by;
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
        return "D # " + this.getStatusIcon() + " # " + this.getDescription() + " # " + this.getBy();
    }
}

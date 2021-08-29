public class Deadline extends Task{
    protected String by;
    protected final String deadlineLabel = "[D]";

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    @Override
    public String toString() {
        return deadlineLabel + " " +  super.getDescription() + " (by: " + by + ")";
    }
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
}

package task;

public class Event extends Task{
    private String at;
    private final String eventLabel = "[E]";

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }
    @Override
    public String toString() {
        return eventLabel + " " + super.getDescription() + " (at: " + this.at + ")";
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
}

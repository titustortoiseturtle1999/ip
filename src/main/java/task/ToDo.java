package task;

public class ToDo extends Task{
    public ToDo(String description) {
        super(description, "T");
    }
    @Override
    public String toString(boolean showStatus) {
        return "[" + this.classLabel + "] " + super.toString(showStatus);
    }

    @Override
    public String formatForFile() {
        return "T # " + this.getStatusIcon() + " # " + this.getDescription();
    }

}

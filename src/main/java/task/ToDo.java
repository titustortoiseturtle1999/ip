package task;
import Constants.Constants;

public class ToDo extends Task{
    public ToDo(String description) {
        super(description, Constants.TODO_LABEL);
    }

    public ToDo(String[] parameters) {
        super(parameters[2], Constants.TODO_LABEL, parameters[1].equals(Constants.TICK_ICON));
    }

    @Override
    public String toString() {
        return "[" + this.classLabel + "] " + super.getDescription();
    }
    @Override
    public String toString(boolean showStatus) {
        return "[" + this.classLabel + "] " + super.toString(showStatus);
    }

    @Override
    public String formatForFile() {
        return this.classLabel + " # " + this.getStatusIcon() + " # " + this.getDescription();
    }

}

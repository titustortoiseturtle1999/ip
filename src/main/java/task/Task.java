package task;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String classLabel;

    public Task (String description) {
        this.description = description;
        this.isDone = false;
        this.classLabel = "Task";
    }
    public Task (String description, String classLabel) {
        this.description = description;
        this.isDone = false;
        this.classLabel = classLabel;
    }

    public String getStatusIcon() {
        return (isDone ? "✓" : " ");
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

    public String toString(boolean showStatus) {
        if (showStatus) {
            return this.getDescription() + " " + getStatusIcon();
        } else {
            return this.getDescription();
        }
    }

    public String getClassIcon() {return classLabel;}

    public String formatForFile() {return "Invalid! Cannot write type Task to file";}
}

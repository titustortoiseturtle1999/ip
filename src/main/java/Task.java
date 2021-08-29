public class Task {
    protected String description;
    protected boolean isDone;

    public Task (String description) {
        this.description = description;
        this.isDone = false;
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
}

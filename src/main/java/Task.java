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
}

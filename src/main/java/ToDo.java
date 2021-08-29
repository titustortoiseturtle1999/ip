public class ToDo extends Task{
    private final String todoLabel = "[T]";

    public ToDo(String description) {
        super(description);
    }
    @Override
    public String toString(boolean showStatus) {
        return todoLabel + " " + super.toString(showStatus);
    }
}

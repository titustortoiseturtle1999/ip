package task;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public int getSize () {
        return tasks.size();
    }

    public Task getItem (int index) {
        return tasks.get(index);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int getNoOfCompleted() {
        int completedTasks = 0;
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks++;
            }
        }
        return completedTasks;
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }
}

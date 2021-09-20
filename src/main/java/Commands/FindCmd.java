package Commands;

import Exceptions.NoDescriptionException;
import duke.Parser;
import duke.Ui;
import task.TaskList;

public class FindCmd extends Commands{
    public static void findTask(String[] commandParameters, TaskList tasks, String line) {
        String input = "";
        try {
            input = Parser.processFind(commandParameters, line);
        } catch (NoDescriptionException e) {
            return;
        }
        Ui.showFoundTasks(iterateThroughTasks(tasks, input));
    }

    private static TaskList iterateThroughTasks(TaskList tasks, String input) {
        TaskList foundTasks = new TaskList();
        for (int i = 0; i < tasks.getSize(); i++) {
            addFoundTask(tasks, input, foundTasks, i);
        }
        return foundTasks;
    }

    private static void addFoundTask(TaskList tasks, String input, TaskList foundTasks, int index) {
        if (tasks.getItem(index).getDescription().contains(input)) {
            foundTasks.addTask(tasks.getItem(index));
        }
    }
}

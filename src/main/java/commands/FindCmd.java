package commands;

import exceptions.NoDescriptionException;
import duke.Parser;
import duke.Ui;
import task.TaskList;

public class FindCmd extends Commands{
    /**
     * Finds all the tasks that contain the String input by the user.
     * @param commandParameters Array of words input by the user.
     * @param tasks List of the users tasks.
     * @param line String of users input.
     */
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

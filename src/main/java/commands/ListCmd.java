package commands;

import exceptions.NoTasksException;
import duke.Parser;
import duke.Ui;
import task.TaskList;

public class ListCmd {
    /**
     * Prints out a list of the users tasks.
     * @param tasks
     */
    public static void listTasks(TaskList tasks) {
        try {
            Parser.processList(tasks);
        } catch (NoTasksException e) {
            return;
        }
        Ui.printTasks(tasks);
        Ui.showProgressBar(tasks);
    }
}

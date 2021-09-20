package Commands;

import Exceptions.NoTasksException;
import duke.Parser;
import duke.Ui;
import task.TaskList;

public class ListCmd {
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

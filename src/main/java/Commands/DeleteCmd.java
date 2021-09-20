package Commands;

import Exceptions.DeleteFormatException;
import duke.Messages;
import duke.Parser;
import duke.Ui;
import task.TaskList;

public class DeleteCmd extends Commands{
    public static void deleteTask(String[] commandParameters, TaskList tasks) {
        int index;
        try {
            index = Parser.processDelete(commandParameters);
        } catch (DeleteFormatException e) {
            return;
        }
        try {
            tasks.removeTask(index - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(Messages.TASK_NOT_IN_LIST);
        }
        Ui.showNoOfTasks(tasks);
    }

}

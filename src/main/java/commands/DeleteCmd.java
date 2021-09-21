package commands;

import exceptions.DeleteFormatException;
import duke.Messages;
import duke.Parser;
import duke.Ui;
import task.TaskList;


public class DeleteCmd extends Commands{
    /**
     * Deletes the specified task from the list.
     * If input is not valid, prints the appropriate error message.
     * @param commandParameters Array of words from the User input.
     * @param tasks List of the Users tasks.
     */
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
            return;
        }
        Ui.showNoOfTasks(tasks);
    }

}

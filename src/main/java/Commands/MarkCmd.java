package Commands;

import Exceptions.MarkFormatException;
import duke.Messages;
import duke.Parser;
import duke.Ui;
import task.TaskList;

public class MarkCmd extends Commands{
    public static void MarkTask(String[] commandParameters, TaskList tasks) {
        int index;
        try {
            index = Parser.processMark(commandParameters, tasks.getSize());
        } catch (MarkFormatException e) {
            return;
        }
        Mark(commandParameters[0], tasks, index);
        Ui.showProgressBar(tasks);
    }

    private static void Mark(String command, TaskList tasks, int index) {
        if (command.equals("done")) {
            tasks.getItem(index - 1).setStatus(true);
            System.out.println(Messages.ONE_STEP_CLOSER);
        } else {
            tasks.getItem(index - 1).setStatus(false);
            System.out.println(Messages.ONE_STEP_FURTHER);
        }
    }
}

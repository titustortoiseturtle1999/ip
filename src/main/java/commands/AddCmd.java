package commands;

import constants.TaskType;
import duke.Messages;
import duke.Parser;
import duke.Ui;
import exceptions.WrongFormatException;
import task.Deadline;
import task.Event;
import task.TaskList;
import task.ToDo;

/**
 * The AddCmd class handles the addition of new tasks
 */
public class AddCmd extends Commands{
    /**
     * Checks which task has been identified to be added
     * and adds it into tasks.
     * If the task is not valid, show an error message.
     * @param tasks List of Users tasks.
     * @param line Input String from User.
     * @param commandParameters Array of Input words.
     */
    public static void addTask(TaskList tasks, String line, String[] commandParameters) {
        switch (commandParameters[0]) {
        case "todo": {
            addTodo(tasks, line, commandParameters);
            break;
        }
        case "deadline": {
            addDeadline(tasks, line);
            break;
        }
        case "event": {
            addEvent(tasks, line);
            break;
        }
        default: {
            System.out.println(Messages.NOT_A_COMMAND);
        }
        }
        Ui.showNoOfTasks(tasks);
    }

    /**
     * Adds a todo to the TaskList tasks
     * @param tasks List of Users tasks
     * @param line Input String from User
     */
    private static void addTodo(TaskList tasks, String line, String[] commandParameters) {
        String description;
        try {
            description = Parser.processTodo(commandParameters, line);
        } catch (WrongFormatException e) {
            return;
        }
        ToDo newTodo = new ToDo(description);
        tasks.addTask(newTodo);
        Ui.addedTaskMsg((TaskType.TODO), newTodo.toString(false));
    }

    private static void addDeadline(TaskList tasks, String line) {
        try {
            Deadline newDeadline = (Deadline) Parser.processDnE(line, TaskType.DEADLINE);
            tasks.addTask(newDeadline);
            Ui.addedTaskMsg((TaskType.DEADLINE), newDeadline.toString(false));
        } catch (Exception e) {
            System.out.println(Messages.DEADLINE_FORMAT);
        }
    }

    private static void addEvent(TaskList tasks, String line) {
        try {
            Event newEvent = (Event) Parser.processDnE(line, TaskType.EVENT);
            tasks.addTask(newEvent);
            Ui.addedTaskMsg((TaskType.EVENT), newEvent.toString(false));
        } catch (Exception e) {
            System.out.println(Messages.EVENT_FORMAT);
        }
    }
}

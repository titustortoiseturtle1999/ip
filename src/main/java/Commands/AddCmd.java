package Commands;

import Constants.TaskType;
import duke.Messages;
import duke.Parser;
import duke.Ui;
import task.Deadline;
import task.Event;
import task.TaskList;
import task.ToDo;

public class AddCmd extends Commands{
    public static void addTask(TaskList tasks, String line, String[] commandParameters) {
        switch (commandParameters[0]) {
        case "todo": {
            AddCmd.addTodo(tasks, line);
            break;
        }
        case "deadline": {
            AddCmd.addDeadline(tasks, line);
            break;
        }
        case "event": {
            AddCmd.addEvent(tasks, line);
            break;
        }
        default: {
            System.out.println(Messages.NOT_A_COMMAND);
        }
        }
        Ui.showNoOfTasks(tasks);
    }
    public static void addTodo(TaskList tasks, String line) {
        try {
            String description = line.replace("todo ", "");
            ToDo newTodo = new ToDo(description);
            tasks.addTask(newTodo);
            System.out.println(Ui.addedTaskMsg(TaskType.TODO) + newTodo);
        } catch (Exception e) {
            System.out.println(Messages.TODO_FORMAT);
        }
    }

    public static void addDeadline(TaskList tasks, String line) {
        try {
            Deadline newDeadline = Parser.processDeadline(line);
            tasks.addTask(newDeadline);
            System.out.println(Ui.addedTaskMsg(TaskType.DEADLINE) + newDeadline);
        } catch (Exception e) {
            System.out.println(Messages.DEADLINE_FORMAT);
        }
    }

    public static void addEvent(TaskList tasks, String line) {
        try {
            Event newEvent = Parser.processEvent(line);
            tasks.addTask(newEvent);
            System.out.println(Ui.addedTaskMsg(TaskType.DEADLINE)+ newEvent);
        } catch (Exception e) {
            System.out.println(Messages.EVENT_FORMAT);
        }
    }
}

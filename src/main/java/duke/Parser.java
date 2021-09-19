package duke;

import Constants.ASCIIconstants;
import Constants.TaskType;
import task.Deadline;
import task.Event;
import task.TaskList;

public class Parser {

    public static boolean handleCommand(String line, TaskList tasks) {
        String[] commandParameters = line.split(" ");
        if (line.equals("list")) {
            Ui.printTasks(tasks);
            Ui.showProgressBar(tasks);
        } else if (line.equals("help")) {
            Ui.showCommands();
        } else if ((commandParameters[0].equals("done") || commandParameters[0].equals("undo"))
                && commandParameters.length == 2) {
            Commands.MarkTask(commandParameters[0], commandParameters[1], tasks);
        } else if (line.equals("logo")) {
            System.out.println(ASCIIconstants.logo);
        } else if (commandParameters[0].equals("del") && commandParameters.length == 2) {
            Commands.deleteTask(commandParameters[1], tasks);
        } else if (commandParameters[0].equals("todo")
                || commandParameters[0].equals("deadline")
                || commandParameters[0].equals("event")) {
            addTask(tasks, line, commandParameters);
        } else if (line.equals("bye")) {
            return true;
        } else {
            System.out.println(Messages.INVALID_INPUT);
        }
        Storage.saveData(tasks);
        return false;
    }


    public static Deadline processDeadline(String line) {
        int byIndex = line.indexOf("#");
        String description = line.substring(0, byIndex - 1);
        description = description.replace("deadline ", "");
        return new Deadline(description, line.substring(byIndex + 1));
    }

    public static Event processEvent(String line) {
        int byIndex = line.indexOf("#");
        String description = line.substring(0, byIndex - 1);
        description = description.replace("event ", "");
        return new Event(description, line.substring(byIndex + 1));
    }

    public static void addTask(TaskList tasks, String line, String[] commandParameters) {
        switch (commandParameters[0]) {
        case "todo": {
            Commands.addTodo(tasks, line);
            break;
        }
        case "deadline": {
            Commands.addDeadline(tasks, line);
            break;
        }
        case "event": {
            Commands.addEvent(tasks, line);
            break;
        }
        default: {
            System.out.println(Messages.NOT_A_COMMAND);
        }
        }
        Ui.showNoOfTasks(tasks);
    }




}

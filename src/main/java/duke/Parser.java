package duke;

import Commands.AddCmd;
import Commands.DeleteCmd;
import Commands.FindCmd;
import Commands.ListCmd;
import Commands.LogoCmd;
import Commands.MarkCmd;
import Exceptions.DeleteFormatException;
import Exceptions.MarkFormatException;
import Exceptions.NoDescriptionException;
import Exceptions.NoTasksException;
import Exceptions.WrongLengthException;
import task.Deadline;
import task.Event;
import task.TaskList;

public class Parser {

    public static boolean handleCommand(String line, TaskList tasks) {
        String[] commandParameters = line.split(" ");
        if (line.equals("list")) {
            ListCmd.listTasks(tasks);
        } else if (line.equals("help")) {
            Ui.showCommands();
        } else if (commandParameters[0].equals("done")
                || commandParameters[0].equals("undo")){
            MarkCmd.MarkTask(commandParameters, tasks);
        } else if (line.equals("logo")) {
            LogoCmd.showLogo();
        } else if (commandParameters[0].equals("del")) {
            DeleteCmd.deleteTask(commandParameters, tasks);
        } else if (commandParameters[0].equals("todo")
                || commandParameters[0].equals("deadline")
                || commandParameters[0].equals("event")) {
            AddCmd.addTask(tasks, line, commandParameters);
        } else if (commandParameters[0].equals("find")) {
            FindCmd.findTask(commandParameters, tasks, line);
        } else if (line.equals("bye")) {
            return true;
        } else {
            System.out.println(Messages.NOT_A_COMMAND);
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

    public static String processFind(String[] commandParameters, String line) throws NoDescriptionException {
        if (commandParameters.length == 1) {
            System.out.println(Messages.NO_DESCRIPTION);
            throw new NoDescriptionException();
        }
        return line.replace("find ", "");
    }

    public static void processList(TaskList tasks) throws NoTasksException {
        if (tasks.getSize() == 0) {
            System.out.println(Messages.NO_TASKS);
            throw new NoTasksException();
        }
    }

    public static void checkLength2(String[] commandParameters) throws WrongLengthException {
        if (commandParameters.length != 2) {
            System.out.println(Messages.MISSING_INDEX);
            throw new WrongLengthException();
        }
    }

    public static int checkIndexValid(String stringIndex) throws NumberFormatException{
        try {
            return Integer.parseInt(stringIndex);
        } catch (NumberFormatException e) {
            System.out.println(Messages.NOT_VALID_TASK_NUMBER);
            throw new NumberFormatException();
        }

    }

    public static int processMark(String[] commandParameters, int sizeOfTasks) throws MarkFormatException {
        try {
            checkLength2(commandParameters);
        } catch (WrongLengthException e) {
            throw new MarkFormatException();
        }
        int index;
        try {
            index = checkIndexValid(commandParameters[1]);
        } catch (NumberFormatException e) {
            throw new MarkFormatException();
        }
        if (index > sizeOfTasks || index <= 0) {
            System.out.println(Messages.TASK_NOT_IN_LIST);
            throw new MarkFormatException();
        }
        return index;
    }

    public static int processDelete(String[] commandParameters) throws DeleteFormatException {
        try {
            checkLength2(commandParameters);
        } catch (WrongLengthException e) {
            throw new DeleteFormatException();
        }
        int index;
        try {
            index = checkIndexValid(commandParameters[1]);
        } catch (NumberFormatException e) {
            throw new DeleteFormatException();
        }
        return index;
    }
}

package duke;

import commands.AddCmd;
import commands.DeleteCmd;
import commands.FindCmd;
import commands.ListCmd;
import commands.LogoCmd;
import commands.MarkCmd;
import constants.TaskType;
import exceptions.*;
import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;

/**
 * The Parser class filters and organises the User input.
 */
public class Parser {

    /**
     * Identifies the command from the user and calls the appropriate command function.
     * Prints the NOT_A_COMMAND
     * @param line String of user input.
     * @param tasks List of the users tasks.
     * @return True if the command is the exit command, "bye".
     */
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

    public static String processTodo(String[] commandParameters, String line) throws WrongFormatException {
        if (commandParameters.length == 1) {
            System.out.println(Messages.NO_DESCRIPTION);
            throw new WrongFormatException();
        }

        try {
            return line.replace("todo ", "");
        } catch (NullPointerException e) {
            System.out.println(Messages.TODO_FORMAT);
            throw new WrongFormatException();
        }
    }

    /**
     * Extracts the relevant information from the user input to create a new deadline object
     * @param line A String of the user input
     * @return A new Deadline object
     */
    public static Task processDnE(String line, TaskType type) throws WrongFormatException{
        String lineWOPrefix = line.replace(type == TaskType.DEADLINE ? "deadline " : "event ", "");
        int byIndex = lineWOPrefix.indexOf("#");
        String description = lineWOPrefix.substring(0, byIndex - 1);
        if (type == TaskType.DEADLINE) {
            return new Deadline(description, lineWOPrefix.substring(byIndex + 1));
        } else if (type == TaskType.EVENT) {
            return new Event(description, lineWOPrefix.substring(byIndex + 1));
        } else {
            System.out.println("Error formatting");
            throw new WrongFormatException();
        }
    }

    public static Event processEvent(String line) {
        String lineWOPrefix= line.replace("deadline ", "");
        int byIndex = lineWOPrefix.indexOf("#");
        String description = lineWOPrefix.substring(0, byIndex - 1);
        return new Event(description, lineWOPrefix.substring(byIndex + 1));
    }

    /**
     * Extracts the relevant information from the user input and
     * checks for formatting errors for the find command.
     * @param commandParameters Array of words from the user input.
     * @param line String of user input.
     * @return A String of the search keyword.
     * @throws NoDescriptionException If the user did not indicate a keyword.
     */
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

    /**
     * Checks the user input for exactly 2 items.
     * @param commandParameters Array of words from the user input
     * @throws WrongLengthException If the length of command parameters is not 2.
     */
    private static void checkLength2(String[] commandParameters) throws WrongLengthException {
        if (commandParameters.length != 2) {
            System.out.println(Messages.MISSING_INDEX);
            throw new WrongLengthException();
        }
    }

    private static int checkIndexValid(String stringIndex) throws NumberFormatException{
        try {
            return Integer.parseInt(stringIndex);
        } catch (NumberFormatException e) {
            System.out.println(Messages.NOT_VALID_TASK_NUMBER);
            throw new NumberFormatException();
        }

    }

    /**
     * Extracts the relevant information from the user input
     * and checks if the input format is correct for the command Mark.
     * @param commandParameters Array of words from the user input.
     * @param sizeOfTasks The length of the list of users tasks.
     * @return The number of the task to be marked.
     * @throws MarkFormatException If there is an error in the input format.
     */
    public static int processMark(String[] commandParameters, int sizeOfTasks) throws MarkFormatException {
        try {
            checkLength2(commandParameters);
        } catch (WrongLengthException e) {
            throw new MarkFormatException();
        }
        int number;
        try {
            number = checkIndexValid(commandParameters[1]);
        } catch (NumberFormatException e) {
            throw new MarkFormatException();
        }
        if (number > sizeOfTasks || number <= 0) {
            System.out.println(Messages.TASK_NOT_IN_LIST);
            throw new MarkFormatException();
        }
        return number;
    }

    /**
     * Extracts the relevant information from the user input
     * and checks if the input format is correct for the command delete.
     * @param commandParameters Array of words from the user input.
     * @return The number of the task to be deleted.
     * @throws DeleteFormatException If there is an error in the input format.
     */
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

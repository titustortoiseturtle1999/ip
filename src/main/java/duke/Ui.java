package duke;

import Constants.Constants;
import Constants.ASCIIconstants;
import Constants.TaskType;
import task.TaskList;

public class Ui {
    private Ui(){}

    public static void showSeparator() {
        System.out.println(Constants.LINE_SEPARATOR);
    }

    public static void showWelcome() {
        System.out.println(Messages.INITIAL_GREETING);
        Ui.showSeparator();
        System.out.println(ASCIIconstants.logo);
        System.out.println(Messages.SELF_INTRO );
    }
    public static void showExit() {
        System.out.println(Helper.getRandomIntegerBetweenRange(0, 6) == 1 ?
                Messages.YOU_ARE_IMPOSTER :
                Messages.YOU_ARE_NOT_IMPOSTER);
    }

    public static void printTasks(TaskList tasks) {
        for (int i = 0; i < tasks.getSize(); i++) {
            System.out.println(i + 1 + ". " + tasks.getItem(i).toString(true));
        }
    }

    public static void showProgressBar(TaskList tasks) {
        int totalLength = Constants.PROGRESS_BAR_LENGTH;
        int completedTasks = tasks.getNoOfCompleted();
        int filledBoxes = tasks.getSize() == 0 ? 0 : (completedTasks * totalLength) / tasks.getSize();
        for (int i = 0; i < filledBoxes; i++) {
            System.out.print(Constants.FILLED_BOX);
        }
        for (int i = filledBoxes; i < totalLength; i++) {
            System.out.print(Constants.EMPTY_BOX);
        }
        System.out.println();
    }

    public static void showCommands() {
        System.out.println(Constants.LINE_SEPARATOR);
        System.out.println("bye: exit program");
        System.out.println("logo: display my logo again!");
        System.out.println("list: list your tasks");
        System.out.println("done: mark your tasks as done\n- to mark item 2 as done, type \"done 2\"");
        System.out.println("undo: undo your marked tasks:\n- to undo a marked task 2, type \"undo 2\"");
        System.out.println("del x: delete task number x");
        System.out.println("find y: Find a task containing y");
        System.out.println("Todos do not have a date attached to it");
        System.out.println("Deadlines are tasks to be done by a specific date");
        System.out.println("Events are tasks that start and end at specific times");
    }

    public static String addedTaskMsg(TaskType type) {
        switch (type) {
        case TODO: {
            return "new Todo assigned to you: ";
        }
        case DEADLINE: {
            return "new Deadline assigned to you: ";
        }
        case EVENT: {
            return "new Event assigned to you: ";
        }
        default: {
            return "new Task assigned to you: ";
        }
        }
    }

    public static void showNoOfTasks(TaskList tasks) {
        System.out.println("You have " + tasks.getSize() + " tasks");
    }

    public static void promptUser() {
        System.out.println(Constants.LINE_SEPARATOR);
        System.out.println(Messages.USER_INPUT_PROMPT);
    }

    public static void showFoundTasks(TaskList foundTasks) {
        if (foundTasks.getSize() > 0) {
            System.out.println(Messages.FOUND_TASK_PREFACE);
        } else {
            System.out.println(Messages.NO_FOUND_TASKS);
        }
        printTasks(foundTasks);
    }

    public static void showLogo() {
        System.out.println(ASCIIconstants.logo);
    }
}




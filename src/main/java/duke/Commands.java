package duke;

import Constants.TaskType;
import task.Deadline;
import task.Event;
import task.TaskList;
import task.ToDo;

public class Commands {
    public static void MarkTask(String command, String stringIndex, TaskList tasks) {
        int index;
        try {
            index = Integer.parseInt(stringIndex);
        } catch (NumberFormatException e) {
            System.out.println(Messages.NOT_VALID_TASK_NUMBER);
            return;
        }
        if (index <= tasks.getSize() && index > 0) {
            Mark(command, tasks, index);
            Ui.showProgressBar(tasks);
        } else {
            System.out.println(Messages.TASK_NOT_IN_LIST);
        }
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

    public static void deleteTask(String stringIndex, TaskList tasks) {
        int index;
        try {
            index = Integer.parseInt(stringIndex);
        } catch (NumberFormatException e) {
            System.out.println(Messages.NOT_VALID_TASK_NUMBER);
            return;
        }
        try {
            tasks.removeTask(index - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(Messages.TASK_NOT_IN_LIST);
        }
    }


    public static void addTodo(TaskList tasks, String line) {
        try {
            String description = line.replace("todo ", "");
            ToDo newTodo = new ToDo(description);
            tasks.addTask(newTodo);
            System.out.println(Ui.addedTaskMsg(TaskType.TODO) + newTodo);
        } catch (Exception e) {
            System.out.println("The Todo format is: todo <name of todo>");
        }
    }

    public static void addDeadline(TaskList tasks, String line) {
        try {
            Deadline newDeadline = Parser.processDeadline(line);
            tasks.addTask(newDeadline);
            System.out.println("new Deadline assigned to you: " + newDeadline);
        } catch (Exception e) {
            System.out.println("The Deadline format is: deadline <name of deadline> #<do by date>");
        }
    }

    public static void addEvent(TaskList tasks, String line) {
        try {
            Event newEvent = Parser.processEvent(line);
            tasks.addTask(newEvent);
            System.out.println("new Event assigned to you: " + newEvent);
        } catch (Exception e) {
            System.out.println("The Event format is: event <name of event> #date and duration");
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;


public class Duke {

    public static final String LINE_SEPARATOR = "--------------------------------------------------------------";

    public static Task[] appendTask(Task[] list, Task task) {
        Task[] newTasks = Arrays.copyOf(list, list.length+1);
        newTasks[list.length] = task;
        return newTasks;
    }

    public static void printTasks(Task[] tasks) {
        if (tasks.length == 0) {
            System.out.println("Wow, a crewmate without tasks? That's rare");
        } else {
            for (int i = 0; i < tasks.length; i++) {
                System.out.println(i + 1 + ". " + tasks[i].toString(true));
            }
        }
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

    public static Task[] addTask(Task[] tasks, String line, String[] commandParameters) {
        switch (commandParameters[0]) {
        case "todo": {
            try {
                if (commandParameters.length < 2) {
                    throw new NoDescriptionException();
                }
                String description = line.replace("todo ", "");
                ToDo newTodo = new ToDo(description);
                tasks = appendTask(tasks, newTodo);
                System.out.println("new ToDo assigned to you: " + newTodo.getDescription());
            } catch (NoDescriptionException e) {
                System.out.println("Trying to assign an empty todo? The audacity.");
            }
            break;
        }
        case "deadline": {
            try {
                if (commandParameters.length < 2) {
                    throw new NoDescriptionException();
                }
                Deadline newDeadline = processDeadline(line);
                tasks = appendTask(tasks, newDeadline);
                System.out.println("new Deadline assigned to you: " + newDeadline);
            } catch (Exception e) {
                System.out.println("The Deadline format is: deadline <name of deadline> #<do by date>");
            }
            break;
        }
        case "event": {
            try {
                Event newEvent = processEvent(line);
                tasks = appendTask(tasks, newEvent);
                System.out.println("new Event assigned to you: " + newEvent);
            } catch (Exception e) {
                System.out.println("The Event format is: event <name of event> #date and duration");
            }
            break;
        }
        default: {
            System.out.println("Not a command! Get your act together or the imposters are gonna win!");
        }
        }
        return tasks;
    }

    public static void showCommands() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("bye: exit program");
        System.out.println("logo: display my logo again!");
        System.out.println("list: list your tasks");
        System.out.println("done: mark your tasks as done\n- to mark item 2 as done, type \"done 2\"");
        System.out.println("undo: undo your marked tasks:\n- to undo a marked task 2, type \"undo 2\"");
        System.out.println("Todos do not have a date attached to it");
        System.out.println("Deadlines are tasks to be done by a specific date");
        System.out.println("Events are tasks that start and end at specific times");
    }

    public static void showProgressBar(Task[] tasks) {
        int totalLength = 20;
        double completedTasks = 0;
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks++;
            }
        }
        int filledBoxes = (int)((completedTasks/tasks.length) * totalLength);
        for (int i = 0; i < filledBoxes; i++) {
            System.out.print("⬛");
        }
        for (int i = filledBoxes; i < totalLength; i++) {
            System.out.print("⬜");
        }
        System.out.println();
    }

    public static void markTask(String command, String stringIndex, Task[] tasks) {
        int index;
        try {
            index = Integer.parseInt(stringIndex);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid task number!");
            return;
        }
        if (index <= tasks.length && index > 0) {
            if (command.equals("done")) {
                tasks[index - 1].setStatus(true);
                System.out.println("One step closer to catching the Imposter!");
            } else {
                tasks[index - 1].setStatus(false);
                System.out.println("Oh no! The ship is falling apart!");
            }
            showProgressBar(tasks);
        } else {
            System.out.println("Task not in list!");
        }
    }
    
    public static Task[] handleCommand(String line, Task[] tasks) {
        String[] commandParameters = line.split(" ");
        if (line.equals("list")) {
            printTasks(tasks);
            showProgressBar(tasks);
        } else if (line.equals("help")) {
            showCommands();
        } else if ((commandParameters[0].equals("done") || commandParameters[0].equals("undo"))
                && commandParameters.length == 2) {
            markTask(commandParameters[0], commandParameters[1], tasks);
        } else if (line.equals("logo")) {
            System.out.println(ASCIIconstants.logo);
        } else if (!line.equals("bye")) {
            tasks = addTask(tasks, line, commandParameters);
            System.out.println("You have " + tasks.length + " tasks");
        }
        return tasks;
    }

    public static void readInput() {
        Scanner in = new Scanner(System.in);
        String line = "";
        Task[] tasks = new Task[]{};
        while (!line.equals("bye")) {
            System.out.println(LINE_SEPARATOR);
            System.out.println("To view my commands, type \"help\"\nEnter a Todo, Deadline, or Event: ");
            line = in.nextLine();
            tasks = handleCommand(line, tasks);
        }
    }

    public static void run() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("I keep track of your crewmate tasks and find imposters! \nHow can i help you?");
        readInput();
        System.out.println(Helper.getRandomIntegerBetweenRange(0, 6) == 1 ?
                "You're the imposter? （°0°） How could you!" :
                "Yay we found the imposter! ヽ(^o^)ノ The ship is saved!");
    }


    public static void main(String[] args) {
        System.out.println("Hello! I'm Amon Gus");
        System.out.println(ASCIIconstants.logo);
        run();
    }
}

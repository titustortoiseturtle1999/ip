package duke;

import Exceptions.DataFileCorruptedException;
import Exceptions.NoDescriptionException;
import task.Deadline;
import task.Event;
import task.Task;
import task.ToDo;
import Constants.Constants;
import Constants.ASCIIconstants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    public static void printTasks(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("Wow, a crewmate without tasks? That's rare");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + 1 + ". " + tasks.get(i).toString(true));
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

    public static void addTask(ArrayList<Task> tasks, String line, String[] commandParameters) {
        switch (commandParameters[0]) {
        case "todo": {
            try {
                if (commandParameters.length < 2) {
                    throw new NoDescriptionException();
                }
                String description = line.replace("todo ", "");
                ToDo newTodo = new ToDo(description);
                tasks.add(newTodo);
                System.out.println("new ToDo assigned to you: " + newTodo.getDescription());
            } catch (NoDescriptionException e) {
                System.out.println("Trying to assign an empty todo? The audacity.");
            }
            break;
        }
        case "deadline": {
            try {
                Deadline newDeadline = processDeadline(line);
                tasks.add(newDeadline);
                System.out.println("new Deadline assigned to you: " + newDeadline);
            } catch (Exception e) {
                System.out.println("The Deadline format is: deadline <name of deadline> #<do by date>");
            }
            break;
        }
        case "event": {
            try {
                Event newEvent = processEvent(line);
                tasks.add(newEvent);
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
    }

    public static void showCommands() {
        System.out.println(Constants.LINE_SEPARATOR);
        System.out.println("bye: exit program");
        System.out.println("logo: display my logo again!");
        System.out.println("list: list your tasks");
        System.out.println("done: mark your tasks as done\n- to mark item 2 as done, type \"done 2\"");
        System.out.println("undo: undo your marked tasks:\n- to undo a marked task 2, type \"undo 2\"");
        System.out.println("del x: delete task number x");
        System.out.println("Todos do not have a date attached to it");
        System.out.println("Deadlines are tasks to be done by a specific date");
        System.out.println("Events are tasks that start and end at specific times");
    }

    public static void showProgressBar(ArrayList<Task> tasks) {
        int totalLength = 20;
        int completedTasks = 0;
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks++;
            }
        }
        int filledBoxes = tasks.size() == 0 ? 0 : (completedTasks * totalLength) / tasks.size();
        for (int i = 0; i < filledBoxes; i++) {
            System.out.print(Constants.FILLED_BOX);
        }
        for (int i = filledBoxes; i < totalLength; i++) {
            System.out.print(Constants.EMPTY_BOX);
        }
        System.out.println();
    }

    public static void markTask(String command, String stringIndex, ArrayList<Task> tasks) {
        int index;
        try {
            index = Integer.parseInt(stringIndex);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid task number!");
            return;
        }
        if (index <= tasks.size() && index > 0) {
            if (command.equals("done")) {
                tasks.get(index - 1).setStatus(true);
                System.out.println("One step closer to catching the Imposter!");
            } else {
                tasks.get(index - 1).setStatus(false);
                System.out.println("Oh no! The ship is falling apart!");
            }
            showProgressBar(tasks);
        } else {
            System.out.println("Task not in list!");
        }
    }

    public static void handleCommand(String line, ArrayList<Task> tasks) {
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
        } else if (commandParameters[0].equals("del") && commandParameters.length == 2) {
            deleteTask(commandParameters[1], tasks);
        } else if (commandParameters[0].equals("todo")
                || commandParameters[0].equals("deadline")
                || commandParameters[0].equals("event")) {
            addTask(tasks, line, commandParameters);
            System.out.println("You have " + tasks.size() + " tasks");
        } else {
            System.out.println("Invalid input!");
        }
        saveData(tasks);
    }

    public static void saveData(ArrayList<Task> tasks) {
        try {
            FileWriter fw = new FileWriter(Constants.AMON_GUS_PATH);
            for (Task task: tasks) {
                fw.write(task.formatForFile());
                fw.write(System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error while saving to file amon_gus.txt.");
        }
    }
    public static void deleteTask(String stringIndex, ArrayList<Task> tasks) {
        int index;
        try {
            index = Integer.parseInt(stringIndex);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid task number!");
            return;
        }
        try {
            tasks.remove(index - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Task not in list!");
        }
    }

    public static void addToTasks(String input, ArrayList<Task> tasks) {
        String[] parameters = input.split(" # ");
        try {
            switch (parameters[0]){
            case "T": {
                ToDo newToDo = new ToDo(parameters);
                tasks.add(newToDo);
                break;
            }
            case "D": {
                Deadline newDeadline = new Deadline(parameters);
                tasks.add(newDeadline);
                break;
            }
            case "E": {
                Event newEvent = new Event(parameters);
                tasks.add(newEvent);
                break;
            }
            default: {
                throw new DataFileCorruptedException();
            }
            }
        } catch (Exception e) {
            System.out.println("Data file data/amon_gus.txt corrupted!");
        }
    }

    public static void handleFileNotExist() {
        System.out.println("data/amon_gus.txt not found, creating one now.");
        try {
            Path path = Paths.get("data");
            // If error, then directory exists but file does not
            Files.createDirectory(path);
        } catch (IOException e) {
            // create file in /data directory
            Paths.get("data/amon_gus.txt");
        }
    }

    public static void readFile(ArrayList<Task> tasks) throws IOException {
        File f = new File(Constants.AMON_GUS_PATH);
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                addToTasks(s.nextLine(), tasks);
            }
        } catch (FileNotFoundException e) {
            handleFileNotExist();
        }
    }

    public static void readInput() {
        Scanner in = new Scanner(System.in);
        String line = "";
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            readFile(tasks);
        } catch (IOException e) {
            System.out.println("Failed to create new data/amon_gus.txt file.\n" + e.getMessage());
        }
        while (!line.equals("bye")) {
            System.out.println(Constants.LINE_SEPARATOR);
            System.out.println("To view my commands, type \"help\"\nEnter a Todo, Deadline, or Event: ");
            line = in.nextLine();
            handleCommand(line, tasks);
        }

    }

    public static void run() {
        System.out.println(Constants.LINE_SEPARATOR);
        System.out.println("I keep track of your crewmate tasks and find imposters! ");
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

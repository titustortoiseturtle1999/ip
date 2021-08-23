import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    public static double getRandomIntegerBetweenRange(double min, double max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

    public static Task[] append(Task[] list, String item) {
        Task[] newTasks = Arrays.copyOf(list, list.length+1);
        Task newTask = new Task(item);
        newTasks[list.length] = newTask;
        return newTasks;
    }

    public static void printTasks(Task[] tasks) {
        if (tasks.length == 0) {
            System.out.println("Wow, a crewmate without tasks? That's rare");
        } else {
            for (int i = 0; i < tasks.length; i++) {
                System.out.println(i + 1 + ". " + tasks[i].description + " " + tasks[i].getStatusIcon());
            }
        }
    }

    public static void showCommands() {
        System.out.println("------------------------------");
        System.out.println("bye: exit program");
        System.out.println("logo: display my logo again!");
        System.out.println("list: list your tasks");
        System.out.println("done: mark your tasks as done\n- to mark item 2 as done, type \"done 2\"");
        System.out.println("undo: undo your marked tasks:\n- to undo a marked task 2, type \"undo 2\"");
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
                tasks[index -1].setStatus(false);
                System.out.println("Oh no! The ship is falling apart!");
            }
        } else {
            System.out.println("Task not in list!");
        }
    }
    
    public static Task[] handleCommand(String line, Task[] tasks) {
        String[] commandParameters = line.split(" ");
        if (line.equals("list")) {
            printTasks(tasks);
        } else if (line.equals("help")) {
            showCommands();
        } else if ((commandParameters[0].equals("done") || (commandParameters[0].equals("undo"))
                && commandParameters.length == 2)) {
            markTask(commandParameters[0], commandParameters[1], tasks);
        } else if (line.equals("logo")) {
            printLogo();
        } else if (!line.equals("bye")) {
            tasks = append(tasks, line);
            System.out.println("new task assigned to you: " + line);
        }
        return tasks;
    }

    public static void readInput() {
        Scanner in = new Scanner(System.in);
        String line = "";
        Task[] tasks = new Task[]{};
        while (!line.equals("bye")) {
            System.out.println("------------------------------");
            System.out.println("To view my commands, type \"help\"\nEnter a Task: ");
            line = in.nextLine();
            tasks = handleCommand(line, tasks);
        }
    }

    public static void greet() {
        System.out.println("------------------------------");
        System.out.println("I keep track of your crewmate tasks and find imposters! \nHow can i help you?");
        readInput();
        System.out.println(getRandomIntegerBetweenRange(0, 6) == 1 ?
                "You're the imposter? （°0°） How could you!" :
                "Yay we found the imposter! ヽ(^o^)ノ The ship is saved!");
    }

    public static void printLogo() {
        String logo = "................................................................................\n"
                + "..................................... ... ......................................\n"
                + ".........................&@@@@@@@@@@@@@@@@@@@@@@@@@%............................\n"
                + "....................#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.........................\n"
                + ".................@@@@@@@@@@@&%%%%%%%%%%%%%%%%%%%@@@@@@@@@&......................\n"
                + "...............@@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@@.....................\n"
                + ".............@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%@@@@@@....................\n"
                + ".........%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%%%&&@@@@@...................\n"
                + "......&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%&@@@@@@..................\n"
                + "....&&&&&&&,*          ,,,,,,,,,,,,,,(&&&&&&&%%%%%%%%%%&&@@@@@/.................\n"
                + "...&&&&&&,              ,,,,,,,,,,,,,,(((&&&&&%%%%%%%%%&&&@@@@@.................\n"
                + "../&&&&&,,*     ,,,,,,,,,,,,,,,,,,,,,,(((&&&&&&%%%%%%%%&&&@@@@@@@@@@@...........\n"
                + "..&&&&&&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(((((&&&&&%%%%%%%%&&&@@@@@@@@@@@@@@@@@.....\n"
                + "..&&&&&%(,,,,,,,,,,,,,,,,,,,,,,,,/((((((((&&&&&%%%%%%%%&&&&@@@@@@##%&@@@@@@@....\n"
                + "..(&&&&&(((((((((/,,,,,,/((((((((((((((((&&&&&%%%%%%%%%&&&&@@@@@%%%%%%%%@@@@@...\n"
                + "...@&&&&&(((((((((((((((((((((((((((((((&&&&&&%%%%%%%%%&&&&@@@@@%%%%%%%%%@@@@...\n"
                + ".....&&&&&&&&&(((((((((((((((((((((((&&&&&&&&%%%%%%%%%%&&&&@@@@@&&&&&&&&&@@@@@..\n"
                + ".......&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%&&&&@@@@@&&&&&&&&&&@@@@..\n"
                + "......,@@@@@&&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%%%%%%%%%%%%&&&&@@@@@&&&&&&&&&%@@@@..\n"
                + "......#@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&@@@@@&&&&&&&&&&@@@@#.\n"
                + "......&@@@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&@@@@@&&&&&&&&&&@@@@@.\n"
                + "......@@@@@&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&@@@@@&&&&&&&&&&@@@@@.\n"
                + "......@@@@@&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&@@@@@&&&&&&&&&&@@@@@.\n"
                + "......@@@@@&&%%%%%%%%%%%%%%     AMON GUS     %%%%%%%%&&&&&&@@@@@&&&&&&&&&&@@@@@.\n"
                + "......&@@@@%&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&@@@@@&&&&&&&&&&@@@@@.\n"
                + "....../@@@@&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&@@@@@&&&&&&&&&%@@@@@.\n"
                + ".......@@@@@&&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&&&&@@@@@&&&&&&&&&@@@@@@.\n"
                + ".......@@@@@&&&&&&&&&%%%%%%%%%%%%%%%%%%%%%%&&&&&&&&&&&&&&&&@@@@@&&&&&&&&&@@@@@..\n"
                + ".......@@@@@&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&@@@@@&&&&&&&&&@@@@@..\n"
                + ".......*@@@@@&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&@@@@@&&&&&&&&@@@@@...";
        System.out.println(logo);

    }
    public static void main(String[] args) {
        System.out.println("Hello! I'm Amon Gus");
        printLogo();
        greet();
    }
}

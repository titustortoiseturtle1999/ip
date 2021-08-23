import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    public static double getRandomIntegerBetweenRange(double min, double max){
        return (int)(Math.random()*((max-min)+1))+min;
    }

    public static Task[] append(Task[] list, String item) {
        Task[] newList = Arrays.copyOf(list, list.length+1);
        Task newTask = new Task(item);
        newList[list.length] = newTask;
        return newList;
    }

    public static void printTasks(Task[] Tasks) {
        if (Tasks.length == 0) {
            System.out.println("Wow, a crewmate without tasks? That's rare");
        } else {
            for (int i = 0; i < Tasks.length; i++) {
                System.out.println(i + 1 + ". " + Tasks[i].description + " " + Tasks[i].getStatusIcon());
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

    public static void markTask(String line, Task[] Tasks) {
        String[] command = line.split(" ");
        int index;
        try {
            index = Integer.parseInt(command[1]);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid task number!");
            return;
        }
        if (index <= Tasks.length && index > 0) {
            if (command[0].equals("done")) {
                Tasks[index - 1].updateStatus(true);
                System.out.println("One step closer to catching the Imposter!");
            } else {
                Tasks[index -1].updateStatus(false);
                System.out.println("Oh no! The ship is falling apart!");
            }
        } else {
            System.out.println("Task not in list!");
        }
    }
    public static Task[] handleCmd(String line, Task[] Tasks) {
        if (line.equals("list")) {
            printTasks(Tasks);
        } else if (line.equals("help")) {
            showCommands();
        } else if ((line.split(" ")[0].equals("done") || (line.split(" ")[0].equals("undo")) && line.split(" ").length == 2)) {
            markTask(line, Tasks);
        } else if (line.equals("logo")) {
            printLogo();
        } else if (!line.equals("bye")) {
            Tasks = append(Tasks, line);
            System.out.println("new task assigned to you: " + line);
        }
        return Tasks;
    }

    public static void task1EchoAndStore() {
        Scanner in = new Scanner(System.in);
        String line = "";
        Task[] Tasks = new Task[]{};
        while (!line.equals("bye")) {
            System.out.println("------------------------------");
            System.out.println("To view my commands, type \"help\"\nEnter a Task: ");
            line = in.nextLine();
            Tasks = handleCmd(line, Tasks);
        }
    }

    public static void greet() {
        System.out.println("------------------------------");
        System.out.println("I keep track of your crewmate tasks and find imposters! \nHow can i help you?");
        task1EchoAndStore();
        System.out.println(getRandomIntegerBetweenRange(0, 6) == 1 ? "You're the imposter? （°0°） How could you!" : "Yay we found the imposter! ヽ(^o^)ノ The ship is saved!");
    }

    public static void printLogo() {
        String logo = "........................................\n"
                + ".............@@@@@@@@@@@@@..............\n"
                + ".........@@@@@&%%%%%%%%%@@@@@...........\n"
                + ".......@@@@%%%%%%%%%%%%%%%%@@@..........\n"
                + "...&&&&&&&&&&&&&&&&&&&%%%%%%@@@.........\n"
                + "..&&&       ,,,,,,,((&&%%%%%&@@@........\n"
                + ".&&&,,,,,,,,,,,,,,,((&&&%%%%&@@@@@@@@@..\n"
                + ".(&&(((((,,,/((((((((&&%%%%%&&@@%%%%@@@.\n"
                + "...&&&&((((((((((((&&&&%%%%%&&@@&&&&&@@.\n"
                + "...,@@&&&&&&&&&&&&&&%%%%%%%%&&@@&&&&&@@.\n"
                + "...&@@%%%%%%%%%%%%%%%%%%%%%%&&@@&&&&&@@@\n"
                + "...@@@%%%%   AMON GUS   %%%&&&@@&&&&&@@@\n"
                + "...&@@&%%%%%%%%%%%%%%%%%%%&&&&@@&&&&&@@@\n"
                + "....@@&&&%%%%%%%%%%%%%%%&&&&&&@@&&&&&@@@\n"
                + "....@@&&&&&&&&&&&&&&&&&&&&&&&&@@&&&&&@@.";
        System.out.println(logo);

    }
    public static void main(String[] args) {
        System.out.println("Hello! I'm Amon Gus");
        System.out.println("------------------------------");
        printLogo();
        greet();
    }
}

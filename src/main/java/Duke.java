import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    public static String[] append(String[] list, String item) {
        String[] newList = Arrays.copyOf(list, list.length+1);
        newList[list.length] = item;
        return newList;
    }

    public static void printTasks(String[] Tasks) {
        for (int i = 0; i < Tasks.length; i++) {
            System.out.println(i+1 + ". " + Tasks[i]);
        }
    }

    public static void showCommands() {
        System.out.println("bye: exit program");
        System.out.println("list: list your tasks");
    }
    public static String[] handleCmd(String line, String[] Tasks) {
        if (line.equals("list")) {
            printTasks(Tasks);
        } else if (line.equals("help")) {
            showCommands();
        } else if (!line.equals("bye")) {
            Tasks = append(Tasks, line);
            System.out.println("new task assigned to you: " + line);
        }
        return Tasks;
    }
    public static void task1EchoAndStore() {
        Scanner in = new Scanner(System.in);
        String line = "";
        String[] Tasks = new String[]{};
        while (!line.equals("bye")) {
            System.out.println("Enter a Task: \nTo view my commands, type \"help\"");
            line = in.nextLine();
            Tasks = handleCmd(line, Tasks);
        }
    }
    public static void greet() {
        System.out.println("------------------------------");
        System.out.println("I complete tasks and find imposters! \nHow can i help you?");
        System.out.println("------------------------------");
        System.out.println("My first task is to echo your Tasks!");
        task1EchoAndStore();
        System.out.println("Bye. Hope to see you again soon!");
    }
    public static void main(String[] args) {
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
                + "...@@@%%%%%%%%%%%%%%%%%%%%%&&&@@&&&&&@@@\n"
                + "...&@@&%%%%%%%%%%%%%%%%%%%&&&&@@&&&&&@@@\n"
                + "....@@&&&%%%%%%%%%%%%%%%&&&&&&@@&&&&&@@@\n"
                + "....@@&&&&&&&&&&&&&&&&&&&&&&&&@@&&&&&@@.";
        System.out.println("Hello! I'm Amon Gus");
        System.out.println("------------------------------");
        System.out.println(logo);
        greet();
    }
}

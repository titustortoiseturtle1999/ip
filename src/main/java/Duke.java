import java.util.Scanner;

public class Duke {
    public static void task1EchoCommands() {
        Scanner in = new Scanner(System.in);
        String line = "";
        while (!line.equals("bye")) {
            System.out.println("Enter a command: \nTo exit, enter \"bye\"" );
            line = in.nextLine();
            System.out.println(line);
        }
    }
    public static void greet() {

        System.out.println("------------------------------");
        System.out.println("I complete tasks and find imposters! \nHow can i help you?");
        System.out.println("------------------------------");
        System.out.println("My first task is to echo your commands!");
        task1EchoCommands();
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

package duke;

import task.TaskList;
import java.util.Scanner;

public class Duke {
    public static void run() {
        TaskList tasks = new TaskList();
        Storage.handleFile(tasks);
        Scanner in = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            Ui.promptUser();
            isExit = Parser.handleCommand(in.nextLine(), tasks);
        }
    }


    public static void main(String[] args) {
        Ui.showWelcome();
        run();
        Ui.showExit();
    }
}

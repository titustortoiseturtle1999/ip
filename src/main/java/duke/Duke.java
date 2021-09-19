package duke;

import task.TaskList;
import Constants.Constants;
import java.util.Scanner;

public class Duke {
    public static void run() {
        TaskList tasks = new TaskList();
        Storage.handleFile(tasks);
        Scanner in = new Scanner(System.in);
        boolean inputExit = false;
        while (!inputExit) {
            System.out.println(Constants.LINE_SEPARATOR);
            System.out.println(Messages.USER_INPUT_PROMPT);
            String line = in.nextLine();
            inputExit = Parser.handleCommand(line, tasks);
        }
    }

    public static void main(String[] args) {
        Ui.showWelcome();
        run();
        Ui.showExit();
    }
}

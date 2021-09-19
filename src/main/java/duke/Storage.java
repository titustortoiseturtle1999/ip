package duke;

import Constants.Constants;
import Exceptions.DataFileCorruptedException;
import task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private Storage() {
    };

    public static void readFile(TaskList tasks) throws IOException {
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

    public static void addToTasks(String input, TaskList tasks) {
        String[] parameters = input.split(" # ");
        try {
            switch (parameters[0]){
            case "T": {
                ToDo newToDo = new ToDo(parameters);
                tasks.addTask(newToDo);
                break;
            }
            case "D": {
                Deadline newDeadline = new Deadline(parameters);
                tasks.addTask(newDeadline);
                break;
            }
            case "E": {
                Event newEvent = new Event(parameters);
                tasks.addTask(newEvent);
                break;
            }
            default: {
                throw new DataFileCorruptedException();
            }
            }
        } catch (Exception e) {
            System.out.println(Messages.DATA_FILE_CORRUPTED);
        }
    }
    public static void handleFileNotExist() {
        System.out.println(Messages.CREATE_DATA_FILE);
        try {
            Path path = Paths.get(Constants.AMON_GUS_DIR);
            Files.createDirectory(path);
        } catch (IOException e) {
            Paths.get(Constants.AMON_GUS_PATH);
        }
    }

    public static void saveData(TaskList tasks) {
        try {
            FileWriter fw = new FileWriter(Constants.AMON_GUS_PATH);
            for (int i = 0; i < tasks.getSize(); i++) {
                fw.write(tasks.getItem(i).formatForFile());
                fw.write(System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(Messages.ERROR_SAVING_TO_FILE);
        }
    }

    public static void handleFile(TaskList tasks) {
        try {
            Storage.readFile(tasks);
        } catch (IOException e) {
            System.out.println(Messages.ERROR_CREATING_FILE);
        }
    }
}

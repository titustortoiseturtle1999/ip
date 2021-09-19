package duke;

import Constants.Constants;
import Exceptions.DataFileCorruptedException;
import task.Deadline;
import task.Event;
import task.Task;
import task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    private FileIO() {
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
}

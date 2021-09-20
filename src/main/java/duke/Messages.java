package duke;

public class Messages {
    public static final String INITIAL_GREETING= "Hello! I'm Amon Gus";
    public static final String SELF_INTRO = "I keep track of your crewmate tasks and find imposters!";
    public static final String YOU_ARE_IMPOSTER = "You're the imposter? （°0°） How could you!";
    public static final String YOU_ARE_NOT_IMPOSTER = "Yay we found the imposter! ヽ(^o^)ノ The ship is saved!";

    public static final String DATA_FILE_CORRUPTED = "Data file data/amon_gus.txt corrupted!";
    public static final String CREATE_DATA_FILE = "data/amon_gus.txt not found, creating one now.";
    public static final String ERROR_SAVING_TO_FILE = "Error while saving to file amon_gus.txt.";
    public static final String ERROR_CREATING_FILE = "Failed to create new data/amon_gus.txt file.";

    public static final String NOT_VALID_TASK_NUMBER = "Not a valid task number!";
    public static final String TASK_NOT_IN_LIST = "Task not in list!";
    public static final String NOT_A_COMMAND = "Not a command! Get your act together or the imposters are gonna win!";
    public static final String NO_DESCRIPTION = "Missing description field!";
    public static final String MISSING_INDEX = "Missing the number of the task!";


    public static final String USER_INPUT_PROMPT = "To view my commands, type \"help\"\nEnter a Todo, Deadline, or Event: ";
    public static final String ONE_STEP_CLOSER = "One step closer to catching the Imposter!";
    public static final String ONE_STEP_FURTHER = "Oh no! The ship is falling apart!";

    public static final String TODO_FORMAT = "The Todo format is: todo <name of todo>";
    public static final String DEADLINE_FORMAT = "The Deadline format is: deadline <name of deadline> #<do by date>";
    public static final String EVENT_FORMAT = "The Event format is: event <name of event> #date and duration";
    public static final String FOUND_TASK_PREFACE = "Here are the matching tasks in your list:";
    public static final String NO_FOUND_TASKS = "Did not find any matching tasks.";
    public static final String NO_TASKS = "Wow, a crewmate without tasks? That's rare";
}

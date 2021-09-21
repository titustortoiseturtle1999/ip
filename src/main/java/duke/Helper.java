package duke;

public class Helper {
    private Helper() {
    }

    /**
     * @param min Lower bound of output value.
     * @param max Upper bound of output value.
     * @return a double of a number between the min and max values provided.
     */
    public static double getRandomIntegerBetweenRange(double min, double max){
        return (int)(Math.random() * ((max-min) + 1)) + min;
    }
}

package duke;

public class Helper {
    private Helper() {
    }
    public static double getRandomIntegerBetweenRange(double min, double max){
        return (int)(Math.random() * ((max-min) + 1)) + min;
    }
}

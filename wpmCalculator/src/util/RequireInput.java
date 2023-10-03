package util;
import java.util.Scanner;

public class RequireInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getInput(String input) {
        System.out.print(input + " ");
        return scanner.nextLine ();
    }
}
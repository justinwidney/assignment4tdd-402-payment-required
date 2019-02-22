package cmput402.tdd;

import java.util.Scanner;

//Simulating user input/output taken from: https://stackoverflow.com/a/6416591
public static class IntegerAsker {
    private final Scanner scanner;
    private final PrintStream out;

    public IntegerAsker(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
    }

    public int ask(String message) {
        out.println(message);
        return scanner.nextInt();
    }
}

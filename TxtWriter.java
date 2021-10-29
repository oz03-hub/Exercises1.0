import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TxtWriter {
    public static void main(String[] args) throws FileNotFoundException {
        final PrintStream originalOut = System.out;

        PrintStream nStream = new PrintStream("Test.txt");
        System.setOut(nStream);

        System.out.println("This should write to file");
        System.out.println(":)");

        System.out.close();

        System.setOut(originalOut);
        System.out.println("Terminal?");
    }
}

package avaj.launcher;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Printer {

    private static BufferedWriter bufferedWriter;

    public static void openFile(String fileName) {
        try {
            // specify file location
            File file = new File("./" + fileName);
            // if it doesn't exist create it
            if (!file.exists()) {
                file.createNewFile();
            }
            Printer.bufferedWriter = new BufferedWriter(new FileWriter("./" + fileName));
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Problem opening the file to write");
        }
    }

    public static void printLine(String line) {
        try {
            bufferedWriter.write(line);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Problem writing to the file");
        }
    }

}

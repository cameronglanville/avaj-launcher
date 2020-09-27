package avaj.launcher;

import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.Math;
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.BufferedWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        // if (args.length > 0) {
        // for (int i = 0; i < args.length; i++) {
        // System.out.println(args[i]);
        // }
        // }

        //check for the correct number of arguments
        if (args.length == 0) {
            throw new Exception("Please pass avaj launcher a scenario");
        } else if (args.length > 1) {
            throw new Exception("Too many arguments");
        }

        //System.out.println(args[0]); //for testing
        //try to open the file passed as an argument
        FileReader fileReader;
        try {
            fileReader = new FileReader("./" + args[0]);
        } catch(Exception e) {
            throw new Exception("bad input");
        }

        //use read the file line by line
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String line = bufferReader.readLine();
        //check the first line for number of interations
        int times;
        try {
            times = Integer.parseInt(line);
        } catch(Exception e) {
            bufferReader.close();
            fileReader.close();
            throw new Exception("bad first line: \"" + line + "\"");
        }
        if (times <= 0) {
            bufferReader.close();
            fileReader.close();
            throw new Exception("The scenario needs a positive interation number");
        }

        line = bufferReader.readLine();
        while (line != null) {
            String temp[] = line.split(" ");
            if (temp.length != 5) {
                System.out.println("Yay, you got to the end!");
            }
        }

        System.out.println("Yay, you got to the end!");
        bufferReader.close();
        fileReader.close();
    }
}
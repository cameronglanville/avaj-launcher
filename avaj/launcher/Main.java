package avaj.launcher;

import java.io.FileReader;
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
        if (args.length == 0) {
            throw new Exception("please pass avaj launcher a scenario");
        } else if (args.length > 1) {
            throw new Exception("too many arguments");
        }

        //System.out.println(args[0]);
        FileReader fileReader;
        try {
            fileReader = new FileReader("./" + args[0]);
        } catch(Exception e) {
            throw new Exception("bad input");
        }
        
        fileReader.close();
    }
}
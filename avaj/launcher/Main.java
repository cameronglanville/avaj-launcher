package avaj.launcher;

import java.io.FileReader;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) throws Exception {
        WeatherTower weatherTower = new WeatherTower();
        Printer.openFile("simulation.txt");

        //check for the correct number of arguments
        if (args.length == 0) {
            throw new Exception("Please pass avaj launcher a scenario");
        } else if (args.length > 1) {
            throw new Exception("You have passed too many arguments");
        }

        //try to open the file passed as an argument
        FileReader fileReader;
        try {
            fileReader = new FileReader("./" + args[0]);
        } catch(Exception e) {
            throw new Exception("That is not a valid file");
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
            throw new Exception("Bad first line, expecting a number: \"" + line + "\"");
        }
        if (times <= 0) {
            bufferReader.close();
            fileReader.close();
            throw new Exception("The number of times the simulation is run needs to be positive");
        } //can it be equal to zero? No

        //iterate through the rest of the file
        line = bufferReader.readLine();
        String temp[];
        int number;
        while (line != null) {
            temp = line.split(" ");
            //check the number of inputs per line
            if (temp.length != 5) {
                bufferReader.close();
                fileReader.close();
                throw new Exception("Incorrect formating: \"" + line + "\"");
            }
            //check type
            if (!temp[0].equals("JetPlane") && !temp[0].equals("Helicopter") && !temp[0].equals("Baloon")) {
                bufferReader.close();
                fileReader.close();
                throw new Exception("Unrecognised type: \"" + temp[0] + "\" on line: \"" + line + "\"");
            }
            //check name ?
            //check longitude
            try {
                number = Integer.parseInt(temp[2]);
            } catch(Exception e) {
                bufferReader.close();
                fileReader.close();
                throw new Exception("longitude is not a number: \"" + temp[2] + "\" on line: \"" + line + "\"");
            }
            if (number <= 0) {
                bufferReader.close();
                fileReader.close();
                throw new Exception("longitude is not a positive number: \"" + temp[2] + "\" on line: \"" + line + "\"");
            }
            //check latitude
            try {
                number = Integer.parseInt(temp[3]);
            } catch(Exception e) {
                bufferReader.close();
                fileReader.close();
                throw new Exception("latitude is not a number: \"" + temp[3] + "\" on line: \"" + line + "\"");
            }
            if (number <= 0) {
                bufferReader.close();
                fileReader.close();
                throw new Exception("latitude is not a positive number: \"" + temp[3] + "\" on line: \"" + line + "\"");
            }
            //check height
            try {
                number = Integer.parseInt(temp[4]);
            } catch(Exception e) {
                bufferReader.close();
                fileReader.close();
                throw new Exception("height is not a number: \"" + temp[4] + "\" on line: \"" + line + "\"");
            }
            if (number < 0) {
                bufferReader.close();
                fileReader.close();
                throw new Exception("height is not valid: \"" + temp[4] + "\" on line: \"" + line + "\"");
            }
            //create and register the aircrafts
            switch (temp[0]) {
                case "JetPlane": {
                    new JetPlane(temp[1], new Coordinates(Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]))).registerTower(weatherTower);
                    break;
                }
                case "Helicopter": {
                    new Helicopter(temp[1], new Coordinates(Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]))).registerTower(weatherTower);
                    break;
                }
                case "Baloon": {
                    new Baloon(temp[1], new Coordinates(Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]))).registerTower(weatherTower);
                    break;
                }
            }
            line = bufferReader.readLine();
        }

        //change the weather specified times
        int i = 0;
        while (i < times) {
            weatherTower.changeWeather();
            i++;
        }

        Printer.closeFile();
        bufferReader.close();
        fileReader.close();
        // System.out.println("Yay, you got to the end!");
    }
}
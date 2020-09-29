# avaj-launcher
minimal aircraft simulation program, an introduction to the Java world

## Compile the project running the commands bellow in the root of the project folder

- find -name *.java > sources.txt
- javac @sources.txt

## Running the project

- java avaj.launcher.Main scenario.txt

## Folder Structure

The workspace contains:

- `avaj.launcher`: the project package

## Info: scenario structure

- first line: number of times the simulatoin is run, must be positive
- lines after the first desribe the aircrafts: TYPE NAME LONGITUDE LATITUDE HEIGHT
- aircrafts have three types: JetPlane Helicopter Baloon
- weather can be one of four: RAIN FOG SUN SNOW

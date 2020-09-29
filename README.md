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

## Info

- first line: number of times the simulatoin is run
- second line desribes the aircraft: TYPE NAME LONGITUDE LATITUDE HEIGHT
- aircrafts have 3 types: JetPlane Helicopter Baloon
- weather can be one of 4: RAIN FOG SUN SNOW

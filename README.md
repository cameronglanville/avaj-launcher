# avaj-launcher
minimal aircraft simulation program, an introduction to the Java world

## Compile the project running the commands bellow in the root of the project folder

- find -name *.java > sources.txt
- // javac -sourcepath @sources.txt // doesn't work
- javac @sources.txt

## Running the project

- // java -cp . com.avaj.Main // seems not needed
- java avaj.launcher

## Folder Structure

The workspace contains:

- `avaj.launcher`: the project package

## Info

- first line: number of times the simulatoin is run
- second line desribes the aircraft: TYPE NAME LONGITUDE LATITUDE HEIGHT
- aircrafts have 3 types: JetPlane Helicopter Baloon
- weather can be one of 4: RAIN FOG SUN SNOW

## Dependency Management

The `JAVA DEPENDENCIES` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-pack/blob/master/release-notes/v0.9.0.md#work-with-jar-files-directly).

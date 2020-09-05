# avaj-launcher
minimal aircraft simulation program, an introduction to the Java world

## Compile the project running the commands bellow in the root of the project folder

find -name *.java > sources.txt
XX javac -sourcepath @sources.txt XX doesn't work
javac @sources.txt

## Running the project

XX java -cp . com.avaj.Main XX seems not needed
java avaj.launcher

## Folder Structure

The workspace contains:

- `avaj.launcher`: the project package

## Dependency Management

The `JAVA DEPENDENCIES` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-pack/blob/master/release-notes/v0.9.0.md#work-with-jar-files-directly).

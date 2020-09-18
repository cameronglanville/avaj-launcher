package avaj.launcher;

public abstract class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter; //starts at 0, will save the id and the number of aircrafts are initially registered

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        Aircraft.idCounter = Aircraft.idCounter + 1;
        return Aircraft.idCounter;
    }

}
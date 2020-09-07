package avaj.launcher;

public abstract class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.trim().toLowerCase().equals("jetplane")) {
            return new JetPlane(name, coordinates);
        } else if (type.trim().toLowerCase().equals("helicopter")) {
            return new Helicopter(name, coordinates);
        } else if (type.trim().toLowerCase().equals("baloon")) {
            return new Baloon(name, coordinates);
        }
        return null;
    }

}

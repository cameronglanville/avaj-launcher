package avaj.launcher;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude; // should be checked for negative before getting here
        this.latitude = latitude; // should be checked for negative before getting here
        if (height < 0) {
            this.height = 0;
        } else if (height > 100) {
            this.height = 100;
        } else {
            this.height = height;
        }
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

}

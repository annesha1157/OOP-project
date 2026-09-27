public class Location {

    private String locationId;
    private String locationName;
    private String roadName;
    private String junctionName;
    private int numberOfVehicles;

    public Location(String locationId, String locationName, String roadName, String junctionName) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.roadName = roadName;
        this.junctionName = junctionName;
        this.numberOfVehicles = 0;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getRoadName() {
        return roadName;
    }

    public String getJunctionName() {
        return junctionName;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void updateTrafficDensity(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public String getTrafficDensity() {
        if (numberOfVehicles <= 35) {
            return "LOW";
        } else if (numberOfVehicles <= 70) {
            return "MEDIUM";
        } else {
            return "HIGH";
        }
    }

    public String displayLocation() {
        return "Location: " + locationName +
                "\nRoad: " + roadName +
                "\nJunction: " + junctionName +
                "\nVehicles: " + numberOfVehicles +
                "\nDensity: " + getTrafficDensity();
    }

    @Override
    public String toString() {
        return displayLocation();
    }
}

import java.util.ArrayList;
import java.util.List;

public class Junction {

    private String junctionId;
    private String location;
    private List<TrafficSignal> signals;
    private List<Police> policeList;
    private int vehicleCount;
    private JunctionClearance clearance;

    public Junction(String junctionId, String location) {
        this.junctionId = junctionId;
        this.location = location;
        this.signals = new ArrayList<>();
        this.policeList = new ArrayList<>();
        this.vehicleCount = 0;
    }

    public String getJunctionId() {
        return junctionId;
    }

    public String getLocation() {
        return location;
    }

    public List<TrafficSignal> getSignals() {
        return signals;
    }

    public List<Police> getPoliceList() {
        return policeList;
    }

    public void addSignal(TrafficSignal signal) {
        signals.add(signal);
    }

    public void addPolice(Police police) {
        policeList.add(police);
    }

    public void updateVehicleCount(int count) {
        this.vehicleCount = count;
    }

    public String getTrafficDensity() {
        if (vehicleCount <= 35) {
            return "LOW";
        } else if (vehicleCount <= 70) {
            return "MEDIUM";
        } else {
            return "HIGH";
        }
    }

    public JunctionClearance requestClearance(String officerName) {
        this.clearance = new JunctionClearance(junctionId, officerName);
        return clearance;
    }

    public JunctionClearance getClearance() {
        return clearance;
    }

    public String displayJunction() {
        return "Junction: " + junctionId +
                "\nLocation: " + location +
                "\nVehicles: " + vehicleCount +
                "\nDensity: " + getTrafficDensity() +
                "\nSignals: " + signals.size() +
                "\nPolice Assigned: " + policeList.size();
    }

    @Override
    public String toString() {
        return displayJunction();
    }
}

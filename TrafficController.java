import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TrafficController {

    private List<Account> accounts;
    private List<Passenger> passengers;
    private List<Vehicle> vehicles;
    private List<Police> policeOfficers;

    private List<Junction> junctions;
    private List<TrafficSignal> signals;
    private List<EmergencyRequest> emergencyRequests;
    private List<RoadCrossingRequest> crossingRequests;

    private Map<String, Location> locations;
    private Map<String, Junction> junctionMap;

    private RoadMap roadMap;
    private TrafficRule trafficRule;

    private PriorityQueue<EmergencyVehicle> priorityQueue;

    public TrafficController() {

        accounts = new ArrayList<>();
        passengers = new ArrayList<>();
        vehicles = new ArrayList<>();
        policeOfficers = new ArrayList<>();

        junctions = new ArrayList<>();
        signals = new ArrayList<>();
        emergencyRequests = new ArrayList<>();
        crossingRequests = new ArrayList<>();

        locations = new HashMap<>();
        junctionMap = new HashMap<>();

        roadMap = new RoadMap();
        trafficRule = new TrafficRule();

        priorityQueue = new PriorityQueue<>((a, b) -> b.getPriority() - a.getPriority());
    }

    // ===================== Account =====================

    public void registerAccount(Account account) {
        accounts.add(account);
        account.register();
    }

    public Account findAccount(String accountId) {
        for (Account a : accounts) {
            if (a.getAccountId().equals(accountId)) {
                return a;
            }
        }
        return null;
    }

    // ===================== Vehicle =====================

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        accounts.add(vehicle);
        if (vehicle instanceof EmergencyVehicle) {
            priorityQueue.add((EmergencyVehicle) vehicle);
        }
    }

    public Vehicle findVehicle(String vehicleNumber) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleNumber().equals(vehicleNumber)) {
                return v;
            }
        }
        return null;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // ===================== Passenger =====================

    public void registerPassenger(Passenger passenger) {
        passengers.add(passenger);
        accounts.add(passenger);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    // ===================== Police =====================

    public void registerPolice(Police police) {
        policeOfficers.add(police);
        accounts.add(police);
    }

    public List<Police> getPoliceOfficers() {
        return policeOfficers;
    }

    // ===================== Emergency Requests =====================

    public void addEmergencyRequest(EmergencyRequest request) {
        emergencyRequests.add(request);
    }

    public List<EmergencyRequest> getEmergencyRequests() {
        return emergencyRequests;
    }

    public void approveEmergency(String requestId) throws EmergencyRequestException {
        EmergencyRequest req = findEmergencyRequest(requestId);
        if (req == null) {
            throw new EmergencyRequestException("Request not found: " + requestId);
        }
        if (req.getStatus().equals("COMPLETED")) {
            throw new EmergencyRequestException("Request already completed: " + requestId);
        }
        req.approve();
    }

    public void rejectEmergency(String requestId) throws EmergencyRequestException {
        EmergencyRequest req = findEmergencyRequest(requestId);
        if (req == null) {
            throw new EmergencyRequestException("Request not found: " + requestId);
        }
        req.reject();
    }

    public void completeEmergency(String requestId) throws EmergencyRequestException {
        EmergencyRequest req = findEmergencyRequest(requestId);
        if (req == null) {
            throw new EmergencyRequestException("Request not found: " + requestId);
        }
        if (!req.getStatus().equals("APPROVED")) {
            throw new EmergencyRequestException("Request must be approved before completion: " + requestId);
        }
        req.complete();
    }

    private EmergencyRequest findEmergencyRequest(String requestId) {
        for (EmergencyRequest r : emergencyRequests) {
            if (r.getRequestId().equals(requestId)) {
                return r;
            }
        }
        return null;
    }

    // ===================== Signals =====================

    public void addSignal(TrafficSignal signal) {
        signals.add(signal);
    }

    public List<TrafficSignal> getSignals() {
        return signals;
    }

    public void changeSignal(String signalId, String newState) throws InvalidSignalTransitionException {
        for (TrafficSignal s : signals) {
            if (s.getSignalId().equals(signalId)) {
                s.changeState(newState);
                return;
            }
        }
    }

    // ===================== Junction =====================

    public void addJunction(Junction junction) {
        junctions.add(junction);
        junctionMap.put(junction.getJunctionId(), junction);
    }

    public List<Junction> getJunctions() {
        return junctions;
    }

    public Junction findJunction(String junctionId) {
        return junctionMap.get(junctionId);
    }

    public JunctionClearance clearJunction(String junctionId, String officerName) throws JunctionClearanceException {
        Junction junction = junctionMap.get(junctionId);
        if (junction == null) {
            throw new JunctionClearanceException("Junction not found: " + junctionId);
        }
        return junction.requestClearance(officerName);
    }

    // ===================== Road Crossing =====================

    public void createCrossingRequest(RoadCrossingRequest request) {
        crossingRequests.add(request);
    }

    public List<RoadCrossingRequest> getCrossingRequests() {
        return crossingRequests;
    }

    public void approveCrossing(String requestId) {
        for (RoadCrossingRequest r : crossingRequests) {
            if (r.getRequestId().equals(requestId)) {
                r.approve();
                return;
            }
        }
    }

    // ===================== Roadmap =====================

    public void addRoute(String from, String to) {
        roadMap.addRoute(from, to);
    }

    public void addRoute(String from, String to, double distanceKm, String density, boolean blocked) {
        roadMap.addRoute(from, to, distanceKm, density, blocked);
    }

    public String findEfficientRoute(String source) throws InvalidRouteException {
        return roadMap.findEfficientRoute(source);
    }

    public String findEfficientRoute(String source, String destination) throws InvalidRouteException {
        return roadMap.findEfficientRoute(source, destination);
    }

    public String findEmergencyRoute(String source, String destination) throws InvalidRouteException {
        return roadMap.findEmergencyRoute(source, destination);
    }

    // ===================== Locations =====================

    public void addLocation(Location location) {
        locations.put(location.getLocationId(), location);
    }

    public Location getLocation(String locationId) {
        return locations.get(locationId);
    }

    // ===================== Traffic Rules =====================

    public TrafficRule getTrafficRule() {
        return trafficRule;
    }

    // ===================== Priority List =====================

    public List<EmergencyVehicle> getPriorityList() {
        List<EmergencyVehicle> list = new ArrayList<>(priorityQueue);
        list.sort((a, b) -> b.getPriority() - a.getPriority());
        return list;
    }

    // ===================== Display =====================

    public String displaySystemStatus() {
        return "Accounts: " + accounts.size() +
                "\nVehicles: " + vehicles.size() +
                "\nPassengers: " + passengers.size() +
                "\nPolice: " + policeOfficers.size() +
                "\nJunctions: " + junctions.size() +
                "\nSignals: " + signals.size() +
                "\nEmergency Requests: " + emergencyRequests.size() +
                "\nCrossing Requests: " + crossingRequests.size();
    }
}

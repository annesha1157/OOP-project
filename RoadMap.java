import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoadMap {

    private Map<String, List<Road>> adjacency;

    private static class Road {
        String from;
        String to;
        double distanceKm;
        String density;
        boolean blocked;

        Road(String from, String to, double distanceKm, String density, boolean blocked) {
            this.from = from;
            this.to = to;
            this.distanceKm = distanceKm;
            this.density = density;
            this.blocked = blocked;
        }
    }

    public RoadMap() {
        adjacency = new HashMap<>();
    }

    public void addRoute(String from, String to, double distanceKm, String density, boolean blocked) {
        adjacency.computeIfAbsent(from, k -> new ArrayList<>())
                .add(new Road(from, to, distanceKm, density, blocked));
        adjacency.computeIfAbsent(to, k -> new ArrayList<>())
                .add(new Road(to, from, distanceKm, density, blocked));
    }

    public void addRoute(String from, String to) {
        addRoute(from, to, 1.0, "LOW", false);
    }

    private double densityPenalty(String density) {
        switch (density) {
            case "LOW":
                return 0;
            case "MEDIUM":
                return 2;
            default:
                return 5;
        }
    }

    public String findEfficientRoute(String source) throws InvalidRouteException {

        List<Road> roads = adjacency.get(source);

        if (roads == null || roads.isEmpty()) {
            throw new InvalidRouteException("No route found from: " + source);
        }

        Road best = null;
        double bestCost = Double.MAX_VALUE;

        for (Road r : roads) {
            if (r.blocked) {
                continue;
            }
            double cost = r.distanceKm + densityPenalty(r.density);
            if (cost < bestCost) {
                bestCost = cost;
                best = r;
            }
        }

        if (best == null) {
            throw new InvalidRouteException("All routes from " + source + " are blocked.");
        }

        return best.to;
    }

    public String findEfficientRoute(String source, String destination) throws InvalidRouteException {

        List<Road> roads = adjacency.get(source);

        if (roads == null) {
            throw new InvalidRouteException("No routes from: " + source);
        }

        for (Road r : roads) {
            if (!r.blocked && r.to.equals(destination)) {
                return source + " -> " + destination;
            }
        }

        for (Road r1 : roads) {
            if (r1.blocked) {
                continue;
            }
            List<Road> next = adjacency.get(r1.to);
            if (next == null) {
                continue;
            }
            for (Road r2 : next) {
                if (!r2.blocked && r2.to.equals(destination)) {
                    return source + " -> " + r1.to + " -> " + destination;
                }
            }
        }

        throw new InvalidRouteException("No route found between " + source + " and " + destination);
    }

    public String findEmergencyRoute(String source, String destination) throws InvalidRouteException {
        return findEfficientRoute(source, destination);
    }
}

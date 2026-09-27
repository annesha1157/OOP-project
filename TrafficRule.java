public class TrafficRule {

    public String checkSignalRule(String state) {
        switch (state) {
            case "RED":
                return "STOP";
            case "YELLOW":
                return "SLOW DOWN";
            case "GREEN":
                return "GO";
            default:
                return "UNKNOWN";
        }
    }

    public String checkEmergencyRule() {
        return "Emergency vehicles must be given priority at all junctions.";
    }

    public String checkCrossingRule() {
        return "Vehicles must stop for pedestrian crossing when requested.";
    }

    public String displayRules() {
        return "===== TRAFFIC RULES =====\n\n" +
                "RED    -> STOP\n" +
                "YELLOW -> SLOW DOWN\n" +
                "GREEN  -> GO\n\n" +
                "Emergency vehicles get priority.\n" +
                "No direct RED -> GREEN transition.\n" +
                "No direct GREEN -> RED transition.\n" +
                "Pedestrian crossing requests must be honored.\n" +
                "Drivers should follow traffic signals.";
    }
}

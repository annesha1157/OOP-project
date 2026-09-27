public abstract class TrafficSignal implements Switchable {

    protected String signalId;
    protected String location;
    protected String state;
    protected boolean on;

    public TrafficSignal(String signalId, String location) {
        this.signalId = signalId;
        this.location = location;
        this.state = "RED";
        this.on = false;
    }

    public String getSignalId() {
        return signalId;
    }

    public String getLocation() {
        return location;
    }

    public String getState() {
        return state;
    }

    @Override
    public void switchOn() {
        on = true;
    }

    @Override
    public void switchOff() {
        on = false;
        state = "RED";
    }

    @Override
    public boolean isOn() {
        return on;
    }

    public void changeState(String newState) throws InvalidSignalTransitionException {

        if (state.equals("RED") && newState.equals("GREEN")) {
            throw new InvalidSignalTransitionException(
                    "Invalid transition: cannot go directly from RED to GREEN.");
        }

        if (state.equals("GREEN") && newState.equals("RED")) {
            throw new InvalidSignalTransitionException(
                    "Invalid transition: cannot go directly from GREEN to RED.");
        }

        this.state = newState;
    }

    public abstract String displaySignal();
}

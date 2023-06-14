public class LoadTruckState extends State{
    public LoadTruckState() {
    }
    @Override
    public int getChargeRequiredForState() {
        return 5;
    }

    @Override
    public State timeElapsed(int minutes) {
        minutesElapsed = minutesElapsed + minutes;
        int timeSpentInState = minutesElapsed;
        if(timeSpentInState >= 5) {
            return Simulation.instance().getFactory().makeIdleState();
        }
        return null;
    }
}

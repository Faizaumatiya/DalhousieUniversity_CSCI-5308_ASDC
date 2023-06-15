public class MoveToTruckState extends State{
    public MoveToTruckState() {
    }
    @Override
    public int getChargeRequiredForState() {
        return 4;
    }

    @Override
    public State timeElapsed(int minutes) {
        minutesElapsed = minutesElapsed + minutes;
        int timeSpentInState = minutesElapsed;
        if(timeSpentInState >= 4) {
            return Simulation.instance().getFactory().makeLoadTruckState();
        }
        return null;
    }
}

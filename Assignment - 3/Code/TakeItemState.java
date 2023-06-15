public class TakeItemState extends State{
    public TakeItemState() {
    }
    @Override
    public int getChargeRequiredForState() {
        return 2;
    }
    @Override
    public State timeElapsed(int minutes) {
        minutesElapsed = minutesElapsed + minutes;
        int timeSpentInState = minutesElapsed;
        if(timeSpentInState >= 2) {
            return Simulation.instance().getFactory().makeMoveToTruckState();
        }
        return null;
    }
}

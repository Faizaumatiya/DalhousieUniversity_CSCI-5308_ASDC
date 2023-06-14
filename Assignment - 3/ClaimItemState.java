public class ClaimItemState extends State{
    
    public ClaimItemState() {

    }

    @Override
    public int getChargeRequiredForState() {
        return 1;
    }

    @Override
    public State timeElapsed(int minutes) {
        Shelf shelf = Simulation.instance().getShelf();
        if(shelf.getItemCount() == 0)
        {
            return Simulation.instance().getFactory().makeIdleState();
        }
        minutesElapsed = minutesElapsed + minutes;
        int timeSpentInState = minutesElapsed;
        if(timeSpentInState >= 1) {
            shelf.claimItem();
            return Simulation.instance().getFactory().makeMoveToShelfState();
        }
        return null;

    }
}

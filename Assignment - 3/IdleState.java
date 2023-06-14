public class IdleState extends State{
    public IdleState() {
    }
    @Override
    public int getChargeRequiredForState() {
        return 0;
    }
    @Override
    public State timeElapsed(int minutes) {
        Shelf shelf = Simulation.instance().getShelf();
        if(shelf.getItemCount() == 0) {
            return  Simulation.instance().getFactory().makeFinishedState();
        }
        else
            return Simulation.instance().getFactory().makeClaimItemState();
    }
}

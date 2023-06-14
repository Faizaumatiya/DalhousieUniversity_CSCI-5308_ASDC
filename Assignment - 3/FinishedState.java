public class FinishedState extends State{

    @Override
    public State timeElapsed(int minutes) {
        return null;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

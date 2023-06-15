public class RechargeState extends State{
    private State state;
    private IBattery battery;

    public RechargeState(State state, IBattery battery) {
        this.state = state;
        this.battery = battery;
    }

    @Override
    public State timeElapsed(int minutes) {
        battery.recharge(minutes);

        return state;
    }
}

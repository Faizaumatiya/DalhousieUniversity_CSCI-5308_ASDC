public class BatteryPackDecorator implements IBattery{
    protected Battery batteryPack;
    protected IBattery battery;

    public BatteryPackDecorator(IBattery battery, int packCapacity) {
        this.battery = battery;
        this.batteryPack = new Battery(packCapacity);
    }
    @Override
    public boolean hasEnoughPowerForMinutes(int minutes) {
        return battery.hasEnoughPowerForMinutes(minutes);
    }

    @Override
    public boolean isFullyCharged() {
        return battery.isFullyCharged() && batteryPack.isFullyCharged();
    }

    @Override
    public void drain(int minutes) {
        int maxPackCapacityCanBeDrained = Math.min(minutes, batteryPack.getCharge());
        batteryPack.drain(maxPackCapacityCanBeDrained);
        if(maxPackCapacityCanBeDrained != minutes){
            this.battery.drain(minutes - maxPackCapacityCanBeDrained);
        }
    }

    @Override
    public void recharge(int minutes) {
        this.battery.recharge(minutes);
        batteryPack.recharge(minutes);
    }
}

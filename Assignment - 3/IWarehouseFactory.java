public interface IWarehouseFactory
{
	// Robots and batteries
	public IBattery createBattery(int capacity);
	public IRobot createRobot(int batteryCapacity);

	public IRobot createRobotWithBatteryPack(int batteryCapacity, int packCapacity);
	// States
	// .. You must complete the interface with methods to instantiate your state objects.
	public State makeIdleState();
	State makeRechargeState(State state, IBattery battery);
	State makeFinishedState();
	State makeClaimItemState();
	State makeMoveToShelfState();
	State makeTakeItemState();
	State makeMoveToTruckState();
	State makeLoadTruckState();

}

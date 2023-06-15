
public class WarehouseFactory implements IWarehouseFactory
{
	@Override
	public IBattery createBattery(int capacity)
	{
		return new Battery(capacity);
	}
	@Override
	public IRobot createRobot(int batteryCapacity)
	{
		IBattery battery = createBattery(batteryCapacity);
		State startState = makeIdleState();
		Robot robot = new Robot(battery, startState);
		TimerSubject.instance().attach(robot);
		return robot;
	}

	public IRobot createRobotWithBatteryPack(int batteryCapacity, int packCapacity)
	{
		BatteryPackDecorator decoratorPack = new BatteryPackDecorator(createBattery(batteryCapacity), packCapacity);
		State startState = makeIdleState();
		Robot robot = new Robot(decoratorPack, startState);
		TimerSubject.instance().attach(robot);
		return robot;
	}
	@Override
	public State makeIdleState() {
		return new IdleState();
	}
	@Override
	public State makeRechargeState(State state, IBattery battery) {
		return new RechargeState(state,battery);
	}

	@Override
	public State makeFinishedState() {
		return new FinishedState();
	}

	@Override
	public State makeClaimItemState() {
		return new ClaimItemState();
	}
	@Override
	public State makeMoveToShelfState() {
		return new MoveToShelfState();
	}

	@Override
	public State makeTakeItemState() {
		return new TakeItemState();
	}

	@Override
	public State makeMoveToTruckState() {
		return new MoveToTruckState();
	}

	@Override
	public State makeLoadTruckState() {
		return new LoadTruckState();
	}
}

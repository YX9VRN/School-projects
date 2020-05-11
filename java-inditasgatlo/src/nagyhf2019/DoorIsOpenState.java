package nagyhf2019;

public class DoorIsOpenState implements VehicleState{

	@Override
	public void next(Vehicle v) {
		v.setState(new SitState());
		
	}

	@Override
	public void prev(Vehicle v) {
		v.setState(new UnlockedState());
		
	}

	@Override
	public void printStatus() {
		System.out.println("Az ajtó nyitva ülj be az autóba a \"sit\" paranccsal");
		
	}
	public String toString() {
		return("DoorIsOpenState");
	}

}

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
		System.out.println("Az ajt� nyitva �lj be az aut�ba a \"sit\" paranccsal");
		
	}
	public String toString() {
		return("DoorIsOpenState");
	}

}

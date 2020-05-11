package nagyhf2019;

public class SitState implements VehicleState{

	@Override
	public void next(Vehicle v) {
		v.setState(new DoorIsClosedState());
		
	}

	@Override
	public void prev(Vehicle v) {
		v.setState(new DoorIsOpenState());
		
	}

	@Override
	public void printStatus() {
		System.out.println("Bent �lsz, csukd be az ajt�t a \"close\" paranccsal");
		
	}
	public String toString() {
		return("SitState");
	}

}

package nagyhf2019;

public class DoorIsClosedState implements VehicleState{

	@Override
	public void next(Vehicle v) {
		v.setState(new CodeValidState());
	}

	@Override
	public void prev(Vehicle v) {
		v.setState(new DoorIsClosedState());
		
	}

	@Override
	public void printStatus() {
		System.out.println("�rd be a k�dot");
		
	}
	public String toString() {
		return("DoorIsClosedState");
	}
}

package nagyhf2019;

public class UnlockedState implements VehicleState {

	@Override
	public void next(Vehicle v) {
		v.setState(new DoorIsOpenState());
	}

	@Override
	public void prev(Vehicle v) {
		v.setState(new InitialState());
	}

	@Override
	public void printStatus() {
		System.out.println("A zár fel van oldva nyisd ki az ajtót írd be, hogy \"open\"");
	}
	public String toString() {
		return("UnlockedState");
	}
	
}

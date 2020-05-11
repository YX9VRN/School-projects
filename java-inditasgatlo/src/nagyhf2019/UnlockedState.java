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
		System.out.println("A z�r fel van oldva nyisd ki az ajt�t �rd be, hogy \"open\"");
	}
	public String toString() {
		return("UnlockedState");
	}
	
}

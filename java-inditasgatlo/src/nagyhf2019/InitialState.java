package nagyhf2019;

public class InitialState implements VehicleState{

	@Override
	public void next(Vehicle v) {
		v.setState(new UnlockedState());
	}

	@Override
	public void prev(Vehicle v) {
		System.out.println("Alapállapot");
	}

	@Override
	public void printStatus() {
		System.out.println("Be van zárva az ajtó, elõször fel kell oldani a központizárat a feloldáshóz írd be, hogy \"unlock\"");
	}
	public String toString() {
		return("InitialState");
	}
}

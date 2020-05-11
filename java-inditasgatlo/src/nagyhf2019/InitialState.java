package nagyhf2019;

public class InitialState implements VehicleState{

	@Override
	public void next(Vehicle v) {
		v.setState(new UnlockedState());
	}

	@Override
	public void prev(Vehicle v) {
		System.out.println("Alap�llapot");
	}

	@Override
	public void printStatus() {
		System.out.println("Be van z�rva az ajt�, el�sz�r fel kell oldani a k�zpontiz�rat a felold�sh�z �rd be, hogy \"unlock\"");
	}
	public String toString() {
		return("InitialState");
	}
}

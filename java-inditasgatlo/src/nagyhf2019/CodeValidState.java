package nagyhf2019;

public class CodeValidState implements VehicleState{

	@Override
	public void next(Vehicle v) {
		v.setState(new FinalState());
		
	}

	@Override
	public void prev(Vehicle v) {
		v.setState(new DoorIsClosedState());
		
	}

	@Override
	public void printStatus() {
		System.out.println("A kód jó, indítsd el az autót a \"start\" paranccsal");
	}
	public String toString() {
		return("CodeValidState");
	}
}

package nagyhf2019;

public class FinalState implements VehicleState {

	@Override
	public void next(Vehicle v) {
		System.out.println("V�gs� �llapot");
	}

	@Override
	public void prev(Vehicle v) {
		v.setState(new CodeValidState());
		
	}

	@Override
	public void printStatus() {
		System.out.println("vrmmmmmmmmm");
		
	}
	public String toString() {
		return("FinalState");
	}

}

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
		System.out.println("A k�d j�, ind�tsd el az aut�t a \"start\" paranccsal");
	}
	public String toString() {
		return("CodeValidState");
	}
}

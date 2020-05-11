package nagyhf2019;

public class Pressure extends Contact {
	/**
	 * Ez az osztály adja vissza, hogy az ülnek az autóban vagy sem
	 * A contact leszármazottja
	 * ha true akkor ülnek az ülésen
	 * ha false akkor akkor nem ülnek az ülésen*/
	public Pressure(boolean b) {
			super(b); 
	}
	public boolean getStatus() {
		return super.status;
	}
	public String toString() {
		/*felüldefiniálja az õs .toStringet az adott komponensnek megfelelõen**/
		if (super.status){
			return "pressed";
		} 
		return "depressed :))";
	}
	
}

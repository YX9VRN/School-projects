package nagyhf2019;

public class Pressure extends Contact {
	/**
	 * Ez az oszt�ly adja vissza, hogy az �lnek az aut�ban vagy sem
	 * A contact lesz�rmazottja
	 * ha true akkor �lnek az �l�sen
	 * ha false akkor akkor nem �lnek az �l�sen*/
	public Pressure(boolean b) {
			super(b); 
	}
	public boolean getStatus() {
		return super.status;
	}
	public String toString() {
		/*fel�ldefini�lja az �s .toStringet az adott komponensnek megfelel�en**/
		if (super.status){
			return "pressed";
		} 
		return "depressed :))";
	}
	
}

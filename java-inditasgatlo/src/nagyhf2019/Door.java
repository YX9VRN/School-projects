package nagyhf2019;

public class Door extends Contact {
	/**
	 * Ez az oszt�ly adja vissza, hogy az ajt� nyitott vagy csukott �llapotban van
	 * A contact lesz�rmazottja
	 * ha true akkor az ajt� be van csukva
	 * ha false akkor az ajt� nyitva van*/
	public Door(boolean b) {
		super(b);
	}
	public boolean getStatus() {
		return super.status;
	}
	public String toString() {
		/*fel�ldefini�lja az �s .toStringet az adott komponensnek megfelel�en**/
		if (super.status){
			return "the door is closed";
		} 
		return "the door is opened";
		
	}

}

package nagyhf2019;

public class DoorLock extends Contact{
	/**
	 * ez az oszt�ly adja vissza, hogy a k�zponti z�r z�rt vagy feloldott �llapotban van
	 * -ha true akkor a kozponti z�r z�rva van
	 * -ha false akkor nyitva*/
	public DoorLock(boolean b) {
		super(b); 
	}
	public boolean getStatus() {
		return super.status;
	}
	public String toString() {
		/*
		 * fel�ldefini�lja az �s .toStringj�t az adott komponsensnek megfelel�en**/
		if (super.status){
			return "doorlock closed";
		} 
		return "doorlock opened";
	}

}

package nagyhf2019;

public class DoorLock extends Contact{
	/**
	 * ez az osztály adja vissza, hogy a központi zár zárt vagy feloldott állapotban van
	 * -ha true akkor a kozponti zár zárva van
	 * -ha false akkor nyitva*/
	public DoorLock(boolean b) {
		super(b); 
	}
	public boolean getStatus() {
		return super.status;
	}
	public String toString() {
		/*
		 * felüldefiniálja az õs .toStringjét az adott komponsensnek megfelelõen**/
		if (super.status){
			return "doorlock closed";
		} 
		return "doorlock opened";
	}

}

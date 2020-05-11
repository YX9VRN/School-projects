package nagyhf2019;

public class Door extends Contact {
	/**
	 * Ez az osztály adja vissza, hogy az ajtó nyitott vagy csukott állapotban van
	 * A contact leszármazottja
	 * ha true akkor az ajtó be van csukva
	 * ha false akkor az ajtó nyitva van*/
	public Door(boolean b) {
		super(b);
	}
	public boolean getStatus() {
		return super.status;
	}
	public String toString() {
		/*felüldefiniálja az õs .toStringet az adott komponensnek megfelelõen**/
		if (super.status){
			return "the door is closed";
		} 
		return "the door is opened";
		
	}

}

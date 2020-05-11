package nagyhf2019;

abstract public class Contact {
	/*Absztrakt osztály ami megadja, hogy az adott komponens éppen zárt vagy nyitott állapotban van
	 * ha true akkor kapcsolódik
	 * ha false akkor nem kapcsolodik
	 * ez az osztály nem példányósítható csak a sepcifikált leszármazottjai**/
	protected boolean status;
	public Contact(boolean b) {
		status = b;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String toString() {
		if (status) {
			return "connected";		//ha true akkor zarva van
		} else {
			return "disconnected";	//ha false akkor nyitva van
		}
	}
}

package nagyhf2019;

abstract public class Contact {
	/*Absztrakt oszt�ly ami megadja, hogy az adott komponens �ppen z�rt vagy nyitott �llapotban van
	 * ha true akkor kapcsol�dik
	 * ha false akkor nem kapcsolodik
	 * ez az oszt�ly nem p�ld�ny�s�that� csak a sepcifik�lt lesz�rmazottjai**/
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

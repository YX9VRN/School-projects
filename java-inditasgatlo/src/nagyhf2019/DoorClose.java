package nagyhf2019;

public class DoorClose implements Command{
	/*Implement�lja a command interf�szt, szimul�lja az ajt� bez�r�s�t**/
	
	public void execute(Vehicle v) {
		/*Az ajt� �rt�ke true lesz, teh�t az ajt� be van csukva**/
		v.setDoor(true);
		System.out.println(v.getDoor().toString()+"( allapot ="+v.getDoor().status+")");
	}

}

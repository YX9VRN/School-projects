package nagyhf2019;

public class DoorOpen implements Command{

	public void execute(Vehicle v) {
		/**
		 * implement�lja a command interf�szt
		 * szimulalja az ajtonyitast
		 * Az ajt� �rt�ke false lesz, teh�t az ajt� nyitva van*/
		v.setDoor(false);
		System.out.println(v.getDoor().toString()+"( allapot ="+v.getDoor().status+")");
	}

}

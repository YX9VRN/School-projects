package nagyhf2019;

public class DoorOpen implements Command{

	public void execute(Vehicle v) {
		/**
		 * implementálja a command interfészt
		 * szimulalja az ajtonyitast
		 * Az ajtó értéke false lesz, tehát az ajtó nyitva van*/
		v.setDoor(false);
		System.out.println(v.getDoor().toString()+"( allapot ="+v.getDoor().status+")");
	}

}

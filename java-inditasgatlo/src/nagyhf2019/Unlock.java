package nagyhf2019;

public class Unlock implements Command{

	
	public void execute(Vehicle v) {
		/**
		 * implementálja a command interfészt
		 * szimulalja a központizárat
		 * A zár értéke false lesz, tehát a központizár nyitva van*/
		v.setDoorLock(false);
		System.out.println(v.getDoorLock().toString()+"( allapot ="+v.getDoorLock().status+")");
	}

}

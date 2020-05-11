package nagyhf2019;

public class Lock implements Command{

	
	public void execute(Vehicle v) {
		/**
		 * implementálja a command interfészt
		 * szimulalja a központizárat
		 * A zár értéke true lesz, tehát a központizár zárva van*/
		v.setDoorLock(true);
		System.out.println(v.getDoorLock().toString()+"( allapot ="+v.getDoorLock().status+")");
	}

}

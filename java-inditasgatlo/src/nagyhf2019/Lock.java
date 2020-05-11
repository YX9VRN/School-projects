package nagyhf2019;

public class Lock implements Command{

	
	public void execute(Vehicle v) {
		/**
		 * implement�lja a command interf�szt
		 * szimulalja a k�zpontiz�rat
		 * A z�r �rt�ke true lesz, teh�t a k�zpontiz�r z�rva van*/
		v.setDoorLock(true);
		System.out.println(v.getDoorLock().toString()+"( allapot ="+v.getDoorLock().status+")");
	}

}

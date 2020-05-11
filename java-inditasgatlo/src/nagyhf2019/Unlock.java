package nagyhf2019;

public class Unlock implements Command{

	
	public void execute(Vehicle v) {
		/**
		 * implement�lja a command interf�szt
		 * szimulalja a k�zpontiz�rat
		 * A z�r �rt�ke false lesz, teh�t a k�zpontiz�r nyitva van*/
		v.setDoorLock(false);
		System.out.println(v.getDoorLock().toString()+"( allapot ="+v.getDoorLock().status+")");
	}

}

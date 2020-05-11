package nagyhf2019;

public class Sit implements Command {

	
	public void execute(Vehicle v) {
		/**
		 * implementálja a command interfészt
		 * szimulalja a nyomásérzékelõt
		 * Az értéke true tehat valaki ül az autóban*/
		v.setPressure(true);
		System.out.println(v.getPressure().toString()+"( allapot ="+v.getPressure().status+")");
	}

}

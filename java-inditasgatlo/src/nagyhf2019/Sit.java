package nagyhf2019;

public class Sit implements Command {

	
	public void execute(Vehicle v) {
		/**
		 * implement�lja a command interf�szt
		 * szimulalja a nyom�s�rz�kel�t
		 * Az �rt�ke true tehat valaki �l az aut�ban*/
		v.setPressure(true);
		System.out.println(v.getPressure().toString()+"( allapot ="+v.getPressure().status+")");
	}

}

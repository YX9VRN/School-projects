package nagyhf2019;

public class Start implements Command{
	/**
	 * implement�lja a command interf�szt
	 * szimulalja az ind�t�st
	 * megh�v egy met�dust*/
	@Override
	public void execute(Vehicle v) {
		try {
			v.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

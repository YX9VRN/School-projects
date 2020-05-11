package nagyhf2019;

public class Start implements Command{
	/**
	 * implementálja a command interfészt
	 * szimulalja az indítást
	 * meghív egy metódust*/
	@Override
	public void execute(Vehicle v) {
		try {
			v.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

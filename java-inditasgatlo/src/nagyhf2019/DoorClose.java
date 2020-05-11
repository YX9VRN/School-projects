package nagyhf2019;

public class DoorClose implements Command{
	/*Implementálja a command interfészt, szimulálja az ajtó bezárását**/
	
	public void execute(Vehicle v) {
		/*Az ajtó értéke true lesz, tehát az ajtó be van csukva**/
		v.setDoor(true);
		System.out.println(v.getDoor().toString()+"( allapot ="+v.getDoor().status+")");
	}

}

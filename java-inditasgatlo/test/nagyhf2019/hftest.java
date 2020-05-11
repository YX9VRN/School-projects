package nagyhf2019;

import static org.junit.Assert.*;
import org.junit.Test;


public class hftest {
	Vehicle v = new Vehicle();
	@Test
	public void keyTest() {
		assertEquals(v.getKey(),v.getEncrypted());
	}
	@Test
	public void pressureTest(){
		//alapérteémezetten nincs bent senki
		assertEquals(false,v.getPressure().getStatus());
	}
	@Test
	public void doorLockTest() {
		//alapérteémezetten be van zárva
		assertEquals(true, v.getDoorLock().getStatus());
	}
	@Test
	public void doorTest() {
		//alapérteémezetten be van csukva
		assertEquals(true, v.getDoor().getStatus());
	}
	
	

}

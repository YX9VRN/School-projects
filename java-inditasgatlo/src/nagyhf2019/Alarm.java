package nagyhf2019;

import java.util.*;

public class Alarm {
	/*
	 * Az idõzítõ miatt szükség van egy TimerTask(egy timer folyamat) osztályra ami párhuzamosan fut a fõfolyamattal**/
	Timer tmr;
	boolean code;
	boolean riaszt;
	public Alarm(int s, boolean b) {
		/*Konstruktor ahhoz, hogy másodõercben lehessen konstruálni**/
		tmr = new Timer();
		tmr.schedule(new RemindTask(), s*1000);
		code = b;
		riaszt = false;
	}
	public boolean isRiaszt() {
		return riaszt;
	}
	public void setRiaszt(boolean riaszt) {
		this.riaszt = riaszt;
	}
	public Timer getTmr() {
		return tmr;
	}
	public void setTmr(Timer tmr) {
		this.tmr = tmr;
	}
	public boolean isCode() {
		return code;
	}
	public void setCode(boolean c) {
		this.code = c;
	}
	class RemindTask extends TimerTask {

		@Override
		public void run() {
			/*felüldefiniálja a run metódust**/
			try {
				// ha a beírt kód hibás fut a timertask amig be nem fejezõdik és ha nem írták be adott idõ alatt a jó kódot akkor riaszt
				if(!code) {
					riaszt = true;
					Vehicle.alarm();	
				}else {
					tmr.cancel();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
	}
	
	
}
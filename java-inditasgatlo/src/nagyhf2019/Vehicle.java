package nagyhf2019;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;


public class Vehicle  {
	/**
	 * A fõ osztály ami tartalmazza a komponenseket
	 * ezt használja a Main is*/
	private VehicleState state = new InitialState();//az indítás állapota
	private Door door;			//ajtó 
	private DoorLock doorLock;	//központizár
	private Starter starter;	//indító
	private String key;			//a kulcs ami a karaktersorozatot tartalmazza
	private String numKey;		//a 6 jegyû kód
	private Pressure pressure;	//nyomásérzékelõ
	private boolean isCodeValid ;
	
	
	public Vehicle()  {
		
		//default konstruktor
		isCodeValid = false;
		door = new Door(true);
		doorLock = new DoorLock(true);
		starter = new Starter();
		key = "";
		pressure = new Pressure(false);
		
		
	}
	public Pressure getPressure() {
		return pressure;
	}
	public void setPressure(boolean b) {
		this.pressure = new Pressure(b);
	}
	public Door getDoor() {
		return door;
	}
	public void setDoor(boolean d) {
		this.door = new Door(d);
	}
	public DoorLock getDoorLock() {
		return doorLock;
	}
	public void setDoorLock(boolean dl) {
		this.doorLock = new DoorLock(dl);
	}
	public Starter getStarter() {
		return starter;
	}
	public void setStarter(Starter starter) {
		this.starter = starter;
	}
	public String getKey() {
		return key;
	}
	public VehicleState getState() {
		return state;
	}
	public void setState(VehicleState state) {
		this.state = state;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getNk() {
		return numKey;
	}
	public void setNk(String nk) {
		this.numKey = nk;
	}
	public String getEncrypted() {
		return this.getStarter().getEncrypted();
	}
	public void previousState() {
		state.prev(this);
	}
	public void nextState() {
		state.next(this);
	}
	public void printStatus() {
		state.printStatus();
	}
	public static  void alarm() throws InterruptedException {
		//riaszto
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				System.err.println("viiiiiiiiiiiiiiiiiiiiiii");
			}else {
				System.err.println("uuuuuuuuuuuuuuuuuuuuuuuuu");
			}
		TimeUnit.SECONDS.sleep(1);
		}
		System.exit(0);
	}
	public boolean exec(String line, String comm, HashMap<String,Command> map) {
		/*
		 * Ez a metódus hajtja végre a parancsokat**/
		Command c;
		if(line.equals(comm)) {
			c = map.get(line);
			c.execute(this);
			return true;
		} else {
			System.err.println("Rossz parancs!");
			return false;
		}
	}
	
	public  boolean numLock(String code) {
		/*
		 * Ez a metódus hasonlítja össze a beírt kódot az autó kódjával**/
		if (code.equals(numKey)){
			return true;
		}
		return false;
	}
	public void start() throws InterruptedException {
		/*
		 * ez a metódus állítja a starter tagváltozóit, és lezárja az indítást**/
		this.getStarter().setNofs(this.getStarter().getNofs()+1);
		this.getStarter().setLastStart(LocalDate.now());
		this.setKey(this.getEncrypted());
		System.out.println("Vrmmmmm");	
		
		
	}
	public void stateMachine() {
		HashMap<String,Command> map = new HashMap<String,Command>();
		map.put("open",new DoorOpen());
		map.put("close", new DoorClose());
		map.put("lockon", new Lock());
		map.put("unlock", new Unlock());
		map.put("sit",new Sit());
		map.put("start",new Start());
		
		this.getStarter().load();		
		this.setKey(this.getStarter().getEncrypted());
		this.setNk("000000");
		
		Scanner input = new Scanner(System.in);
		String line = "";
		this.setState(new InitialState());
		while(!state.toString().equals("FinalState")) {
			if(state.toString().equals("InitialState")) {
				state.printStatus();
				line = input.nextLine();
				if(exec(line,"unlock",map)) {
					this.nextState();
					}	
			}else if(state.toString().equals("UnlockedState")){
				state.printStatus();
				line = input.nextLine();
				if(exec(line,"open",map)){
					this.nextState();
					}
			}else if(state.toString().equals("DoorIsOpenState")){
				state.printStatus();
				line = input.nextLine();
				if(exec(line,"sit",map)){
					this.nextState();
				}
			}else if(state.toString().equals("SitState")){
				state.printStatus();
				line = input.nextLine();
				if(exec(line,"close",map)) {
					this.nextState();
				}
			}else if(state.toString().equals("DoorIsClosedState")){
				state.printStatus();
				Alarm a = new Alarm(5,false);
				while (!isCodeValid  ){
					//20 mp en keresztül kéri a kódot különben riaszt
					if(!a.isRiaszt()) {
						System.out.println("Add meg a kódot(20mp(teszthez 6db 0))");
						line = input.nextLine();
					}
					isCodeValid = numLock(line);
					if(isCodeValid) {
						a.setCode(true);
					}
				}
				state.next(this);
			}else if(state.toString().equals("CodeValidState")) {
				state.printStatus();
				line = input.nextLine();
				if(this.getKey().equals(this.getEncrypted())){
					if(exec(line,"start",map)) {
						this.nextState();
					}
					try {
						this.getStarter().generateHash();
						//elõállítja a titkosított karaktersorozatot
						this.setKey(this.getStarter().getEncrypted());
						//beállítja a kulcsra
						this.getStarter().save();
						//elmenti a változókat
					} catch (Exception e) {
						e.printStackTrace();
					}	
				}
			}	
		}	
		System.exit(0);
	}
	
	
}



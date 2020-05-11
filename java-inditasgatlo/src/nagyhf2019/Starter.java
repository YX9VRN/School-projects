package nagyhf2019;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.io.*;


@SuppressWarnings("serial")
public class Starter implements Serializable {
	/*
	 * Ez egy komponense a jármûnek ez állítja elõ a kulcshoz szükséges karaktersorozatot
	 * amit lehet titkosítani menteni és betölteni**/
	private int nofs ; 				//number of starts 
	private LocalDate lastStart;	//utolso inditas				  
	private String sernum;			//sorozatszam statikus
	private String status;			//az idnito allapota 
	private String encrypted; 		//a titkositott "kulcs" amit atmasol a valódi kulcsra
	
	public Starter() {
		//default konstruktor
		nofs = 0;
		lastStart = LocalDate.of(1970, 1, 1);
		sernum = "XXXX";
		status = "basic";
		encrypted = "";
	}
	public Starter(int numOfStart, LocalDate lStart, String serialNumber, String stat) {
		//konstruktor
		nofs = numOfStart;
		lastStart = lStart;
		sernum = serialNumber;
		status = stat;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNofs() {
		return nofs;
	}
	public void setNofs(int nofs) {
		this.nofs = nofs;
	}
	public LocalDate getLastStart() {
		return lastStart;
	}
	public void setLastStart(LocalDate lastStart) {
		this.lastStart = lastStart;
	}
	public String getSernum() {
		return sernum;
	}
	public void setSernum(String sernum) {
		this.sernum = sernum;
	}
	public String toString() {
		return (nofs+"-"+lastStart.toString()+"-"+sernum+"-"+status);
	}
	public String getEncrypted() {
		return encrypted;
	}
	public void setEncrypted(String encrypted) {
		this.encrypted = encrypted;
	}
	public String generateHash() throws NoSuchAlgorithmException {
		/*titkosító metódus**/
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(this.toString().getBytes());
		encrypted = new String(messageDigest.digest());
		return encrypted;
	}
	
	public void save() {
		/*ezzel a metódussal lehet menteni**/
		FileOutputStream f;
		try {
			f = new FileOutputStream("filename.txt");
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(nofs);
			out.writeObject(lastStart);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	
	}
	public void load() {
		/*ezzel a metódussal lehet betölteni**/
		try {
		FileInputStream f = new FileInputStream("filename.txt");
		ObjectInputStream in = new ObjectInputStream(f);
		nofs = (int)in.readObject();
		lastStart = (LocalDate)in.readObject();
		in.close();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
	
	
}



















































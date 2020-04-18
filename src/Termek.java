
public class Termek {
	
	private int szam;
	private String azonosito;
	private int mennyiseg;
	
	
	
	public Termek(int szam, String azonosito, int mennyiseg) {
		super();
		this.szam = szam;
		this.azonosito = azonosito;
		this.mennyiseg = mennyiseg;
	}
	public int getSzam() {
		return szam;
	}
	public void setSzam(int szam) {
		this.szam = szam;
	}
	public String getAzonosito() {
		return azonosito;
	}
	public void setAzonosito(String azonosito) {
		this.azonosito = azonosito;
	}
	public int getMennyiseg() {
		return mennyiseg;
	}
	public void setMennyiseg(int mennyiseg) {
		this.mennyiseg = mennyiseg;
	}
	
	@Override
	public String toString() {
		return "Termekek [szam=" + szam + ", azonosito=" + azonosito + ", mennyiseg=" + mennyiseg + "]";
	}
	
	
}

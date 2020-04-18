import java.util.List;

public class Rendeles {
	private String datum;
	private int szam;
	private String email;
	private List<Termek> termekek;
	
	public Rendeles() {
		
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public int getSzam() {
		return szam;
	}

	public void setSzam(int szam) {
		this.szam = szam;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Termek> getTermekek() {
		return termekek;
	}

	public void setTermekek(List<Termek> termekek) {
		this.termekek = termekek;
	}

	@Override
	public String toString() {
		return "Rendeles [datum=" + datum + ", szam=" + szam + ", email=" + email + ", termekek=" + termekek + "]";
	}
	
	
	
}

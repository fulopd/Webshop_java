
public class Raktar {
	private String termekkod;
	private String termeknev;
	private int ar;
	private int db;
	
	public String getTermekkod() {
		return termekkod;
	}
	public void setTermekkod(String termekkod) {
		this.termekkod = termekkod;
	}
	public String getTermeknev() {
		return termeknev;
	}
	public void setTermeknev(String termeknev) {
		this.termeknev = termeknev;
	}
	public int getAr() {
		return ar;
	}
	public void setAr(int ar) {
		this.ar = ar;
	}
	public int getDb() {
		return db;
	}
	public void setDb(int db) {
		this.db = db;
	}
	
	@Override
	public String toString() {
		return "Raktar [termekkod=" + termekkod + ", termeknev=" + termeknev + ", ar=" + ar + ", db=" + db + "]";
	}
	
	public Raktar(String termekkod, String termeknev, int ar, int db) {
		super();
		this.termekkod = termekkod;
		this.termeknev = termeknev;
		this.ar = ar;
		this.db = db;
	}
	
	
	
	
	
}

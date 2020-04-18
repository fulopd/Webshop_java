import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	
	public static List<Raktar> termekLista() {
		List<Raktar> termekLista = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get("raktar.csv"));
			for (String sor : beolvas.subList(1, beolvas.size())) {
				String[] split = sor.split(";");
				Raktar o = new Raktar(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]));
				
				termekLista.add(o);
			}
		} catch (IOException e) {
			System.err.println("Hiba a beolvasasnal");
		}
		return termekLista;
	}
	
	
	public static List<Rendeles> rendelesLista() {
		List<Rendeles> rendelesLista = new ArrayList<>();
		try {
			List<String> beolvas = Files.readAllLines(Paths.get("rendeles.csv"));
			List<String> listaM = new ArrayList<>();
			List<String> listaT = new ArrayList<>();
			
			for (String sor : beolvas) {
				if (sor.contains("M")) {
					listaM.add(sor);
				}
				if (sor.contains("T")) {
					listaT.add(sor);
				}
			}
			
			for (String sorM : listaM) {
				String[] splitM =  sorM.split(";");
				List<Termek> temp = new ArrayList<>();
				Rendeles o = new Rendeles();
				o.setDatum(splitM[1]);
				o.setSzam(Integer.parseInt(splitM[2]));
				o.setEmail(splitM[3]);
				for (String sorT : listaT) {
					String[] splitT =  sorT.split(";");
					if (splitT[1].equals(splitM[2])) {
						temp.add(new Termek(Integer.parseInt(splitT[1]), splitT[2], Integer.parseInt(splitT[3])));
					}
				}
				o.setTermekek(temp);
				rendelesLista.add(o);
			}
					
			
		} catch (IOException e) {
			System.err.println("Hiba a beolvasasnal");
		}
		return rendelesLista;
	}
	
	
	public static void main(String[] args) {
		List<Raktar> termekLista = termekLista();
		List<Rendeles> rendelesLista = rendelesLista();
		Map<String, Integer> hianycikk = new TreeMap<>();
		
		//rendelesLista.forEach(System.out::println);
		
		for (Rendeles r : rendelesLista) {
			boolean teljesitheto = true;
			int sum = 0;
			for (Termek t : r.getTermekek()) {
				//DEBUG: Termekek:
				//System.out.println("\t"+t);
				for (Raktar raktar : termekLista) {					
					if (raktar.getTermekkod().equals(t.getAzonosito())) {
						//System.out.println(raktar.getTermekkod() +" " + raktar.getDb());
						if (raktar.getDb()-t.getMennyiseg()>=0) {
							raktar.setDb(raktar.getDb()-t.getMennyiseg());
							sum += raktar.getAr() * t.getMennyiseg();
						}else {
							//DEBUG Nincs:
							//System.out.println("Nincs már raktáron");
							//DEBUG raktar:
							//System.out.println(t.getAzonosito() + " " +(raktar.getDb() - t.getMennyiseg()*-1));
							hianycikk.merge(t.getAzonosito(), (raktar.getDb()-t.getMennyiseg()*(-1)), Integer::sum);
							teljesitheto = false;
						}
					}
				}
			}
			//DEBUG M Rendeles:
			//System.out.println(r.getDatum() +" " + r.getSzam() + " " + r.getEmail() +" " + teljesitheto + " ----> " + sum + "\n\n");
			if (teljesitheto) {
				System.out.println(r.getEmail() + " A rendelést két napon belül szállítjuk " + sum + "ft");
			}else {
				System.out.println(r.getEmail() + " A rendelést függõ állípotba került hamarosan értesítjük.");
			}
		}

		System.out.println("4. feladat:");
		hianycikk.forEach((k,v) -> System.out.println(k +";" + v));
	}

}

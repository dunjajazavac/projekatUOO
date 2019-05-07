package korisnik;

import java.util.ArrayList;
import enumeracija.Pol;
import enumeracija.Sluzba;
import enumeracija.Uloga;
import pregledi.Pregledi;

public class Lekar extends Korisnik {
	public double plata;
	public String specijalizacija;
	public Sluzba sluzba;
	public ArrayList<Pacijenti> pacijent;
	public ArrayList<Pregledi>pregled;
	
	public Lekar() {
		this.plata=0;
		this.specijalizacija="";
		this.sluzba=null;
		this.pacijent=new ArrayList<Pacijenti>();
		this.pregled=new ArrayList<Pregledi>();
		
		}

	public Lekar(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, Uloga uloga, double plata, String specijalizacija, Sluzba sluzba, ArrayList<Pacijenti>pacijent, ArrayList<Pregledi>pregled) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, uloga);
		
	}
	
	public Lekar(Lekar original) {
		super(original);
		this.plata=original.plata;
		this.specijalizacija=original.specijalizacija;
		this.sluzba=original.sluzba;
		this.pacijent=original.pacijent;
		this.pregled=original.pregled;
		
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(String specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	public Sluzba getSluzba() {
		return sluzba;
	}

	public void setSluzba(Sluzba sluzba) {
		this.sluzba = sluzba;
	}

	public ArrayList<Pacijenti> getPacijent() {
		return pacijent;
	}

	public void setPacijent(ArrayList<Pacijenti> pacijent) {
		this.pacijent = pacijent;
	
	}
	public ArrayList<Pregledi> getPregled() {
		return pregled;
	}

	public void setPregled(ArrayList<Pregledi> pregled) {
		this.pregled = pregled;
	}

	@Override
	public String toString() {
		String s = "Lekar " + super.toString() + 
				"\nPlata: " + this.plata +
				"\nSpecijalizacija: " + this.specijalizacija+
				"\nSluzba "+ this.sluzba;
		
		for (Pacijenti pacijent : pacijent) {
			s += "\n" + pacijent;
		}
		for(Pregledi pregled: pregled) {
			s+="\n"+pregled;
		}
		return s;
	

}
}

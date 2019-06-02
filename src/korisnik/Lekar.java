package korisnik;



import java.util.ArrayList;

import enumeracija.Pol;
import enumeracija.Sluzba;
import pregledi.Pregledi;

public class Lekar extends Korisnik {
	public Sluzba sluzba;
	public String specijalizacija;
	public double plata;
	public ArrayList<Pregledi> pregled;
	public ArrayList<Pacijenti> pacijent;
	
	public Lekar() {
		super();
		this.sluzba=null;
		this.specijalizacija="";
		this.plata=0;
		
		}

	public Lekar(String ime, String prezime, String jmbg,Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, Sluzba sluzba,String specijalizacija,double plata,ArrayList<Pregledi>pregled,ArrayList<Pacijenti>pacijent) {
		super(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka);
		
		this.sluzba=sluzba;
		this.specijalizacija=specijalizacija;
		this.plata=plata;
		
		
	}
	

	public Sluzba getSluzba() {
		return sluzba;
	}

	public void setSluzba(Sluzba sluzba) {
		this.sluzba = sluzba;
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

	public ArrayList<Pregledi> getPregled() {
		return pregled;
	}

	public void setPregled(ArrayList<Pregledi> pregled) {
		this.pregled = pregled;
	}

	public ArrayList<Pacijenti> getPacijent() {
		return pacijent;
	}

	public void setPacijent(ArrayList<Pacijenti> pacijent) {
		this.pacijent = pacijent;
	}

	@Override
	public String toString() {
		return "LEKAR\nIme: " +getIme()+
				"\nPrezime: "+getPrezime()+
				"\nJMBG: "+getJmbg()+
				"\nPol: "+getPol()+
				"\nAdresa: "+getAdresa()+
				"\nBroj telefona: "+getBrojTelefona()+
				"\nKorisnicko ime: "+getKorisnickoIme()+
				"\nLozinka: "+getLozinka()+
				"\nSluzba: "+getSluzba()+
				"\nSpecijalizacija: "+this.specijalizacija+
				"\nPlata: "+getPlata();
				}
			
		
}

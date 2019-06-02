package korisnik;
import java.util.ArrayList;

import enumeracija.Pol;
import enumeracija.Sluzba;

import pregledi.Pregledi;


public class MedicinskaSestra extends Korisnik {
	public double Plata;
	public Sluzba sluzba;
	private ArrayList<Lekar> lekari;
	private ArrayList<Pacijenti> pacijent;
	private ArrayList<Pregledi> pregled;
	

	public MedicinskaSestra() {
		this.Plata=0;
		this.sluzba=null;
		this.lekari=new ArrayList<Lekar>();
		this.pacijent=new ArrayList<Pacijenti>();
		this.pregled=new ArrayList<Pregledi>();
			}

	public MedicinskaSestra(String ime, String prezime, String jmbg, Pol  pol, String adresa,
			String brojTelefona, String korisnickoIme, String lozinka,double Plata, Sluzba sluzba,ArrayList<Lekar> lekari,ArrayList<Pacijenti>pacijent,ArrayList<Pregledi>pregled) {
		super(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka);
		this.Plata=Plata;
		this.sluzba=sluzba;
		this.lekari=lekari;
		this.pacijent=pacijent;
		this.pregled=pregled;
			}

	public MedicinskaSestra(MedicinskaSestra original) {
		super(original);
		this.Plata=original.Plata;
		this.sluzba=original.sluzba;
		this.lekari=original.lekari;
		this.pacijent=original.pacijent;
		this.pregled=original.pregled;
		
	}
	

	public ArrayList<Lekar> getLekari() {
		return lekari;
	}

	public void setLekari(ArrayList<Lekar> lekari) {
		this.lekari = lekari;
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

	public double getPlata() {
		return Plata;
	}

	public void setPlata(double plata) {
		Plata = plata;
	}

	public Sluzba getSluzba() {
		return sluzba;
	}

	public void setSluzba(Sluzba sluzba) {
		this.sluzba = sluzba;
	}

	@Override
	public String toString() {
		return "MEDICINSKA SESTRA \nIme: " +getIme()+
				"\nPrezime: "+getPrezime()+
				"\nJMBG: "+getJmbg()+
				"\nPol: "+getPol()+
				"\nAdresa: "+getAdresa()+
				"\nBroj telefona: "+getBrojTelefona()+
				"\nKorisnicko ime: "+getKorisnickoIme()+
				"\nLozinka: "+getLozinka()+
				"\nPlata: "+getPlata()+
				"\nSluzba: "+getSluzba();
				};
	}
	
	
	


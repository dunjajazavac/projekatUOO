package korisnik;
import java.util.ArrayList;

import enumeracija.Pol;
import enumeracija.Sluzba;

import pregledi.Pregledi;


public class MedicinskaSestra extends Korisnik {
	public double Plata;
	public Sluzba sluzba;
	

	public MedicinskaSestra() {
		this.Plata=0;
		this.sluzba=null;
			}

	public MedicinskaSestra(String ime, String prezime, String jmbg, Pol  pol, String adresa,
			String brojTelefona, String korisnickoIme, String lozinka,double Plata, Sluzba sluzba) {
		super(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka);
		this.Plata=Plata;
		this.sluzba=sluzba;
			}

	public MedicinskaSestra(MedicinskaSestra original) {
		super(original);
		this.Plata=original.Plata;
		this.sluzba=original.sluzba;
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
		return "MEDICINSKA SESTRA\nIme: " +getIme()+
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
	
	
	


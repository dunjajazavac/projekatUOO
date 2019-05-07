package korisnik;

import enumeracija.Pol;
import enumeracija.Sluzba;
import enumeracija.Uloga;

public class MedicinskaSestra extends Korisnik {
	public double Plata;
	public Sluzba sluzba;
	

	public MedicinskaSestra() {
		this.Plata=0;
		this.sluzba=null;
			}

	public MedicinskaSestra(String id, String ime, String prezime, String jmbg, Pol pol, String adresa,
			String brojTelefona, String korisnickoIme, String lozinka, Uloga uloga,double Plata, Sluzba sluzba) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, uloga);
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
		return "Medicinska Sestra"+ super.toString()+
				"\nPlata: "+this.Plata+
				"\nSluzba: "+this.sluzba;
	}
	
	
	

}

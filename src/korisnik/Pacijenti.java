package korisnik;

import enumeracija.Pol;
import enumeracija.Uloga;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;

public class Pacijenti extends Korisnik{
	public Lekar izabraniLekar;
	public ZdravstvenaKnjizica zdknjizica;

	public Pacijenti(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, Uloga uloga, Lekar izabranilekar, ZdravstvenaKnjizica zdknjizica) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, uloga);
		}
		
	public Pacijenti(Pacijenti original) {
		super(original);
		this.izabraniLekar=original.izabraniLekar;
		this.zdknjizica=original.zdknjizica;
	}

	public Lekar getIzabraniLekar() {
		return izabraniLekar;
	}

	public void setIzabraniLekar(Lekar izabraniLekar) {
		this.izabraniLekar = izabraniLekar;
	}

	public ZdravstvenaKnjizica getZdknjizica() {
		return zdknjizica;
	}

	public void setZdknjizica(ZdravstvenaKnjizica zdknjizica) {
		this.zdknjizica = zdknjizica;
	}
	
	@Override
	public String toString() {
		String s = "Pacijent " + super.toString() + 
				"\nIzabrani lekar : " + this.izabraniLekar +
				"\nZdravstvena knjizica : " + this.zdknjizica;
		return s;
	}
	

		
		
		
		
		
		
	}

		
		
		





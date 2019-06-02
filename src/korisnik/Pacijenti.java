package korisnik;



import java.util.ArrayList;

import enumeracija.Pol;
import pregledi.Pregledi;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;

public class Pacijenti extends Korisnik{
	public Lekar izabranilekar;
	public ZdravstvenaKnjizica idKnjizica;

	public Pacijenti() {
		super();
		this.izabranilekar=new Lekar();
		this.idKnjizica=new ZdravstvenaKnjizica();
		}
	
		
	

	
	public Pacijenti(String ime,String prezime, String jmbg, Pol pol,String adresa, String brojTelefona, String korisnickoIme, String lozinka, Lekar izabraniLekar,ZdravstvenaKnjizica idKnjizica) {
		
		super(ime,prezime,jmbg,pol,adresa,brojTelefona,korisnickoIme,lozinka);
		this.izabranilekar=izabraniLekar;
		this.idKnjizica=idKnjizica;
	}
	
	public Pacijenti(String jmbgString) {
		
	}










	public Lekar getIzabranilekar() {
		return izabranilekar;
	}





	public void setIzabranilekar(Lekar izabranilekar) {
		this.izabranilekar = izabranilekar;
	}


	public ZdravstvenaKnjizica getIdKnjizica() {
		return idKnjizica;
	}





	public void setIdKnjizica(ZdravstvenaKnjizica idKnjizica) {
		this.idKnjizica = idKnjizica;
	}





	@Override
	public String toString() {
		return "PACIJENT \nIme: " +getIme()+
				"\nPrezime: "+getPrezime()+
				"\nJMBG: "+getJmbg()+
				"\nPol: "+getPol()+
				"\nAdresa: "+getAdresa()+
				"\nBroj telefona: "+getBrojTelefona()+
				"\nKorisnicko ime: "+getKorisnickoIme()+
				"\nLozinka: "+getLozinka()+
				"\nIzabrani lekar: "+this.izabranilekar.getKorisnickoIme()+
				"\nID knjzice: "+this.idKnjizica.getBroj()+"\n";
				}
	

		
		
		
		
		
		
	}

		
		
		





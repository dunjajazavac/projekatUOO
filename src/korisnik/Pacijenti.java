package korisnik;



import enumeracija.Pol;
import pregledi.Pregledi;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;

public class Pacijenti extends Korisnik{
	public Lekar jmbgLekara;
	public ZdravstvenaKnjizica idKnjizica;

	public Pacijenti() {
		super();
		this.jmbgLekara=new Lekar();
		this.idKnjizica=new ZdravstvenaKnjizica();
		}
	
		
	

	
	public Pacijenti(String ime,String prezime, String jmbg, Pol pol,String adresa, String brojTelefona, String korisnickoIme, String lozinka, Lekar jmbgLekara,ZdravstvenaKnjizica idKnjizica) {
		
		super(ime,prezime,jmbg,pol,adresa,brojTelefona,korisnickoIme,lozinka);
		this.jmbgLekara=jmbgLekara;
		this.idKnjizica=idKnjizica;
	}
	









	


	public Lekar getJmbgLekara() {
		return jmbgLekara;
	}





	public void setJmbgLekara(Lekar jmbgLekara) {
		this.jmbgLekara = jmbgLekara;
	}





	public ZdravstvenaKnjizica getIdKnjizica() {
		return idKnjizica;
	}





	public void setIdKnjizica(ZdravstvenaKnjizica idKnjizica) {
		this.idKnjizica = idKnjizica;
	}





	@Override
	public String toString() {
		return "PACIJENT\nIme: " +getIme()+
				"\nPrezime: "+getPrezime()+
				"\nJMBG: "+getJmbg()+
				"\nPol: "+getPol()+
				"\nAdresa: "+getAdresa()+
				"\nBroj telefona: "+getBrojTelefona()+
				"\nKorisnicko ime: "+getKorisnickoIme()+
				"\nLozinka: "+getLozinka()+
				"\nIzabrani lekar:"+this.jmbgLekara.getKorisnickoIme()+
				"\nID knjzice: "+this.idKnjizica.getBroj()+"\n";
				}
	

		
		
		
		
		
		
	}

		
		
		





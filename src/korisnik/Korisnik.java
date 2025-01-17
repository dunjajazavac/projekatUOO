package korisnik;

import enumeracija.Pol;

public abstract class Korisnik {
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected Pol pol;
	protected String adresa;
	protected String brojTelefona;
	protected String korisnickoIme;
	protected String lozinka;
	
	public Korisnik() {
		this.ime="";
		this.prezime="";
		this.jmbg="";
		this.pol=null;
		this.adresa="";
		this.brojTelefona="";
		this.korisnickoIme="";
		this.lozinka="";
		
		
			}
	
		
		public Korisnik(String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		}



	public Korisnik(Korisnik original) {
		this.ime=original.ime;
		this.prezime=original.prezime;
		this.jmbg=original.jmbg;
		this.pol=original.pol;
		this.adresa=original.adresa;
		this.brojTelefona=original.brojTelefona;
		this.korisnickoIme=original.korisnickoIme;
		this.lozinka=original.lozinka;

		
	}
	
	




	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}



	public String getJmbg() {
		return jmbg;
	}



	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}



	public Pol getPol() {
		return pol;
	}


	public void setPol(Pol pol) {
		this.pol = pol;
	}


	public String getAdresa() {
		return adresa;
	}



	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}



	public String getBrojTelefona() {
		return brojTelefona;
	}



	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}



	public String getKorisnickoIme() {
		return korisnickoIme;
	}



	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}



	public String getLozinka() {
		return lozinka;
	}



	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}




	@Override
	public String toString() {
		return  "\nIme: " + ime
				 + "\nPrezime: " + prezime
				 + "\nJmbg: " + jmbg
				 + "\nPol: " + pol
				 + "\nAdresa: " + adresa
				 + "\nBroj telefona: " + brojTelefona
				 + "\nKorisnicko ime: " + korisnickoIme
				 + "\nLozinka: " + lozinka;
				 
		}
		
		
		
	}
	
	
	



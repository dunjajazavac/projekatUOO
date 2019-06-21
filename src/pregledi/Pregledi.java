package pregledi;

import enumeracija.Status;
import korisnik.Lekar;
import korisnik.Pacijenti;

public class Pregledi {
	public String id;
	public Pacijenti pacijent;
	public 	Lekar doktor;
	public String datum;
	public String soba;
	public String opis;
	public Status status;
	public double cena;
	
	public Pregledi() {
		this.id="";
		this.pacijent=new Pacijenti();
		this.doktor=new Lekar();
		this.datum="";
		this.soba="";
		this.opis="";
		this.status=null;
		this.cena=0;
	}

	public Pregledi(String id, Pacijenti pacijent, Lekar doktor, String datum, String soba, String opis, Status status,
			double cena) {
		super();
		this.id = id;
		this.pacijent = pacijent;
		this.doktor = doktor;
		this.datum = datum;
		this.soba = soba;
		this.opis = opis;
		this.status = status;
		this.cena = cena;
	}



	public Pregledi(Pregledi original) {
		this.id=original.id;
		this.pacijent=original.pacijent;
		this.doktor=original.doktor;
		this.datum=original.datum;
		this.soba=original.soba;
		this.opis=original.opis;
		this.status=original.status;
		this.cena=original.cena;
		}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public Pacijenti getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijenti pacijent) {
		this.pacijent = pacijent;
	}

	

	public Lekar getDoktor() {
		return doktor;
	}

	public void setDoktor(Lekar doktor) {
		this.doktor = doktor;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	

	public String getSoba() {
		return soba;
	}

	public void setSoba(String soba) {
		this.soba = soba;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		String s = "Pregledi " + 
				"\nId : "+this.id+
				"\nPacijent : " + this.pacijent.getKorisnickoIme() +
				"\nLekar : " + this.doktor.getKorisnickoIme()+
				"\nTermin: "+ this.datum+
				"\nSoba: "+ this.soba+
				"\nOpis: "+this.opis+
				"\nStatus: "+this.status+
				"\nCena: "+this.cena;
		return s;
	}
	
	
	
	

}

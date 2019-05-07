package pregledi;

import enumeracija.Status;
import korisnik.Lekar;
import korisnik.Pacijenti;

public class Pregledi {
	public Pacijenti pacijent;
	public Lekar lekar;
	public String datum;
	public int soba;
	public String opis;
	public Status status;
	
	public Pregledi() {
		this.pacijent=null;
		this.lekar=null;
		this.datum="";
		this.soba=0;
		this.opis="";
		this.status=null;
	}

	public Pregledi(Pacijenti pacijent, Lekar lekar, String datum, int soba, String opis, Status status) {
		super();
		this.pacijent = pacijent;
		this.lekar = lekar;
		this.datum = datum;
		this.soba = soba;
		this.opis = opis;
		this.status = status;
	}
	public Pregledi(Pregledi original) {
		this.pacijent=original.pacijent;
		this.lekar=original.lekar;
		this.datum=original.datum;
		this.soba=original.soba;
		this.opis=original.opis;
		this.status=original.status;
		}

	public Pacijenti getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijenti pacijent) {
		this.pacijent = pacijent;
	}

	public Lekar getLekar() {
		return lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public int getSoba() {
		return soba;
	}

	public void setSoba(int soba) {
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
	
	@Override
	public String toString() {
		String s = "Pregledi " + super.toString() + 
				"\nPacijent : " + this.pacijent +
				"\nLekar : " + this.lekar+
				"\nTermin: "+ this.datum+
				"\nSoba: "+ this.soba+
				"\nOpis: "+this.opis+
				"\nStatus: "+this.status;
		return s;
	}
	
	
	
	

}

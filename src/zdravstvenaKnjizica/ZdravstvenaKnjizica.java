package zdravstvenaKnjizica;

import enumeracija.Kategorija;

public class ZdravstvenaKnjizica {
	public String broj;
	public String datum;
	public Kategorija kategorija;
	
	public ZdravstvenaKnjizica() {
		this.broj="";
		this.datum="";
		this.kategorija=null;
	}
	
	public ZdravstvenaKnjizica(String broj, String datum, Kategorija kategorija) {
		super();
		this.broj = broj;
		this.datum = datum;
		this.kategorija = kategorija;
	}

	public ZdravstvenaKnjizica(ZdravstvenaKnjizica original) {
		this.broj=original.broj;
		this.datum=original.datum;
		this.kategorija=original.kategorija;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}
	
	@Override
	public String toString() {
		String s = "Zdravstvena knjizica " + 
				"\nBroj: " + this.broj +
				"\nDatum: " + this.datum+
				"\nKategorija: "+this.kategorija;
		
		return s;
	}

}

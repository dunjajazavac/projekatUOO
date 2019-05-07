package zdravstvenaKnjizica;

import enumeracija.Kategorija;

public class ZdravstvenaKnjizica {
	public int broj;
	public String datum;
	public Kategorija kategorija;
	
	public ZdravstvenaKnjizica() {
		this.broj=0;
		this.datum="";
		this.kategorija=null;
	}

	public ZdravstvenaKnjizica(int broj, String datum, Kategorija kategorija) {
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

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
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
		String s = "Zdravstvena knjizica " + super.toString() + 
				"\nBroj: " + this.broj +
				"\nDatum: " + this.datum+
				"\nKategorija: "+this.kategorija;
		
		return s;
	}

}

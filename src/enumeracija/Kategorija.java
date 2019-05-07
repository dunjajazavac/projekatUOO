package enumeracija;

public enum Kategorija{
	PRVA("1"),DRUGA("2"),TRECA("3");
	
	private String skracenica;
	private Kategorija(String skracenica) {
		this.skracenica=skracenica;
	}
	private Kategorija() {
		this.skracenica="SVE";
	}
	public String getSkracenica() {
		return skracenica;
	}
	public String toString() {
		switch(this) {
		case PRVA:
			return "Pregled se placa 300 dinara.";
		case DRUGA:
			return "Pregled se placa 50 dinara.";
		case TRECA:
			return "Pregled je besplatan.";
			default:
				return null;
		
		
		}
	}
}
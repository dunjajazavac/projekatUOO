package enumeracija;

public enum Kategorija{
	PRVA,
	DRUGA,
	TRECA;
	
	public static Kategorija fromInt(int a) {
		switch(a) {
		case 1:
			return PRVA;
		case 2:
			return DRUGA;
		default:
			return TRECA;
		
		}
	}
	public static int toInt(Kategorija kategorijaO) {
		switch(kategorijaO) {
		case PRVA:
			return 1;
		case DRUGA:
			return 2;
		default:
			return 3;
		}
		
	}

}


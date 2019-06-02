package enumeracija;

public enum Pol {
	MUSKI, //1
	ZENSKI; //2
	
	public static Pol fromInt(int a) {
		switch(a) {
		case 1:
			return MUSKI;
		default:
			return ZENSKI;
		}
	}
	
	public static int toInt(Pol pol) {
		switch(pol) {
		case MUSKI:
			return 1;
		default:
			return 2;
		
		}
	}
		
	}

	

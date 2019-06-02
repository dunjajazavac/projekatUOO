package enumeracija;

public enum Status {
	ZATRAZEN,
	ZAKAZAN, 
	OTKAZAN, 
	ZAVRSEN;
	
	public static Status fromInt(int a) {
		switch(a) {
		case 1:
			return ZATRAZEN;
		case 2:
			return ZAKAZAN;
		case 3:
			return OTKAZAN;
		default:
			return ZAVRSEN;
		}
	}
	
	public static int toInt(Status status) {
		switch(status) {
		case ZATRAZEN:
			return 1;
		case ZAKAZAN:
			return 3;
		case OTKAZAN:
			return 3;
		default:
			return 4;
		}
	}
}

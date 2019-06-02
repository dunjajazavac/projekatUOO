package enumeracija;

public enum Sluzba {
	    OPSTAMEDICINA,
	    ZASTITADECE, 
	    STOMATOLOGIJA, 
	    ZASTITARADNIKA, 
	    PRAVNOEKONOMSKIPOSLOVI, 
	    TEHNICKIPOSLOVI;

		public static Sluzba fromInt(int a) {
			switch(a) {
			case 1:
				return OPSTAMEDICINA;
			case 2:
				return ZASTITADECE;
			case 3:
				return STOMATOLOGIJA;
			case 4:
				return ZASTITARADNIKA;	
			case 5:
				return PRAVNOEKONOMSKIPOSLOVI;
			default:
				return TEHNICKIPOSLOVI;
			}
		}
		
		public static int toInt(Sluzba sluzba) {
			switch(sluzba) {
			case OPSTAMEDICINA:
				return 1;
			case ZASTITADECE:
				return 2;
			case STOMATOLOGIJA:
				return 3;
			case ZASTITARADNIKA:
				return 4;
			case PRAVNOEKONOMSKIPOSLOVI:
				return 5;
			default:
				return 6;
			
			}
		}
			
		}

package main;

import domZdravlja.DomZdravlja;
import korisnik.Lekar;
import korisnik.MedicinskaSestra;
import korisnik.Pacijenti;
import pregledi.Pregledi;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;

public class DZ {

	public static void ispis(DomZdravlja dom) {
		for(Pacijenti pacijent:dom.getPacijent()) {
			System.out.println(pacijent+"\n");
		}
		for(Lekar doktor:dom.getLekari()) {
			System.out.println(doktor+"\n");
		}
		for(MedicinskaSestra medsestre:dom.getMedicinskesestre()) {
			System.out.println(medsestre+"\n");
		}
		for(Pregledi pregled:dom.getPregled()) {
			System.out.println(pregled+"\n");
			
		}
		for(ZdravstvenaKnjizica knjizica:dom.getZdknjizica()) {
			System.out.println(knjizica+"\n");
			
		}
		
		

	}

}

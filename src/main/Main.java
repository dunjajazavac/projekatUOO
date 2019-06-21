package main;


import java.util.ArrayList;

import domZdravlja.DomZdravlja;
import enumeracija.Kategorija;
import enumeracija.Pol;
import enumeracija.Sluzba;
import enumeracija.Status;
import gui.Login;
import korisnik.Lekar;
import korisnik.MedicinskaSestra;
import korisnik.Pacijenti;
import pregledi.Pregledi;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;

public class Main {
	final static String fajlPacijenata="pacijenti.txt";
	final static String fajlLekara="lekari.txt";
	final static String fajlMedSestre="medicinskesestre.txt";
	final static String fajlPregleda="pregledi.txt";
	final static String fajlKnjizice="zdknjizica.txt";
	
	
public static void main(String[] args){
	 DomZdravlja dom=new DomZdravlja();
     //ZdravstvenaKnjizica knjizica=new ZdravstvenaKnjizica("1234","21.02.2020.", Kategorija.PRVA);
	 //Lekar doktor=new Lekar("Ljubisa", "Simic", "0104777", Pol.MUSKI, "Jevrejska 14","0651234", "ljubisas", "ljube123", Sluzba.OPSTAMEDICINA, "ortopedija", 50000);
	 //Pacijenti pacijent=new Pacijenti("Sanja", "Peric", "0405221", Pol.ZENSKI, "Koste Racina 2", "0621234","sanjap", "sanja123",doktor,knjizica);
	 //Pregledi p=new Pregledi("115", pacijent, doktor,"24.09.2020",14,"glavobolja", Status.ZAKAZAN, 300);
	// Pacijenti pacijent1=new Pacijenti("Sava","Perovic","025874", Pol.MUSKI, "Slobodana Penezica 23", "0641789", "savap","perovic1", doktor, knjizica);
	 //MedicinskaSestra sestra=new MedicinskaSestra("Maja","Simic","032145",Pol.ZENSKI, "Rumenacka 3","0641235","majas", "maja123", 48000, Sluzba.TEHNICKIPOSLOVI);
	 //Pregledi pregled=new Pregledi("114", pacijent1, doktor,"25.08.2019.",15,"bol u grlu", Status.ZAKAZAN,500);
	 //dom.dodajMedSestru(sestra);
	//dom.dodajPacijenta(pacijent);
	 //dom.dodajPacijenta(pacijent1);
	// dom.dodajLekara(doktor);
	 //dom.dodajPreglede(p);
	// dom.dodajZdknjizicu(knjizica);
	// dom.snimiLekare(fajlLekara);
	 //dom.snimiMedsestre(fajlMedSestre);
	 //dom.snimiPacijente(fajlPacijenata);
	 //dom.snimiPreglede(fajlPregleda);
	 //dom.snimiZdknjzicu(fajlKnjizice);
	 
	 dom.ucitajKnjizice(fajlKnjizice);
	 dom.ucitajLekare(fajlLekara);
	 dom.ucitajPacijente(fajlPacijenata);
	 dom.ucitajMedSestre(fajlMedSestre);
	 dom.ucitajPreglede(fajlPregleda);
	 DomZdravlja.ispis(dom);
	Login prozor=new Login(dom);
	prozor.setVisible(true);
	 
	 
	
	
	
	
		}

		
		
		
		
		
		
		
		
		
	}
	
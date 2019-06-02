package main;
import enumeracija.*;

import java.util.ArrayList;

import domZdravlja.DomZdravlja;
import korisnik.Lekar;
import korisnik.MedicinskaSestra;
import korisnik.Pacijenti;
import pregledi.Pregledi;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;

public class Main {
	final static String fajlPacijenata="pacijenti.txt";
	final static String fajlLekara="lekari.txt";
	final static String fajlMedSestra="medicinskesestre.txt";
	final static String fajlPregleda="pregledi.txt";
	final static String fajlKnjizica="zdknjizica.txt";
	
	
public static void main(String[] args){
	DomZdravlja dom=new DomZdravlja();
		
		System.out.println("Dodavanje");
		
		Lekar doktor=new Lekar("Marko", "Srdanovic", "03012121", Pol.MUSKI, "Koste Racina 7", "0651234", "markos", "srda123", Sluzba.OPSTAMEDICINA, "decija hirurgija", 50000, new ArrayList<Pregledi>(), new ArrayList<Pacijenti>());
		Lekar doktor1=new Lekar("Sanja", "Matic", "2205147", Pol.ZENSKI, "Rumenacka 44","0641235", "sanjam", "matic1", Sluzba.STOMATOLOGIJA,"zubna hirurgija",48000, new ArrayList<Pregledi>(),new ArrayList<Pacijenti>());
		MedicinskaSestra sestra=new MedicinskaSestra("Jana", "Jovic", "124578", Pol.ZENSKI, "Zeleznicka 3", "0612345", "janaj", "jovic33", 30000, Sluzba.PRAVNOEKONOMSKIPOSLOVI, new ArrayList<Lekar>(),new ArrayList<Pacijenti>(), new ArrayList<Pregledi>());
		ZdravstvenaKnjizica knjizica=new ZdravstvenaKnjizica("123", "12.10.20119", Kategorija.DRUGA);
		ZdravstvenaKnjizica knjizica1=new ZdravstvenaKnjizica("321", "02.01.2020", Kategorija.PRVA);
		Pacijenti pacijent=new Pacijenti("Olja", "Milosevic", "3004199", Pol.ZENSKI, "Tone Hadzica 10", "0641235", "oljam","milosevic123", doktor, knjizica1);
		Pregledi pregled=new Pregledi("2", pacijent, doktor,"26.03.2021",5,"bolovi u grlu", Status.ZATRAZEN,100);
	
		
		
		
		
		dom.dodajLekara(doktor);
		dom.dodajLekara(doktor1);
		dom.dodajMedSestru(sestra);
		dom.dodajPacijenta(pacijent);
		dom.dodajPreglede(pregled);
		dom.dodajZdknjizicu(knjizica);
		dom.dodajZdknjizicu(knjizica1);
		
		dom.snimiLekare(fajlLekara);
		dom.snimiMedsestre(fajlMedSestra);
		dom.snimiPacijente(fajlPacijenata);
		dom.snimiPreglede(fajlPregleda);
		dom.snimiZdknjzicu(fajlKnjizica);
		
		dom.ucitajKnjizice(fajlKnjizica);
		dom.ucitajLekare(fajlLekara);
		dom.ucitajMedSestre(fajlMedSestra);
		dom.ucitajPacijente(fajlPacijenata);
		dom.ucitajPreglede(fajlPregleda);
		
		dom.obrisiLekara("sanjam");
		
		DomZdravlja.ispis(dom);		
		
			
		}

		
		
		
		
		
		
		
		
		
	}
	
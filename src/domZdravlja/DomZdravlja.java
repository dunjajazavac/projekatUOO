package domZdravlja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import enumeracija.Kategorija;
import enumeracija.Pol;
import enumeracija.Sluzba;
import enumeracija.Status;
import korisnik.Lekar;
import korisnik.MedicinskaSestra;
import korisnik.Pacijenti;
import pregledi.Pregledi;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;



	public class DomZdravlja {
		private ArrayList<Lekar> lekari;
		private ArrayList<MedicinskaSestra>medicinskesestre;
		private ArrayList<Pacijenti>pacijent;
		private ArrayList<Pregledi>pregled;
		private ArrayList<ZdravstvenaKnjizica>knjizica;
		
		

		public DomZdravlja() {
			this.lekari=new ArrayList<Lekar>();
			this.medicinskesestre=new ArrayList<MedicinskaSestra>();
			this.pacijent=new ArrayList<Pacijenti>();
			this.pregled=new ArrayList<Pregledi>();
			this.knjizica=new ArrayList<ZdravstvenaKnjizica>();
		}
			
		public ArrayList<Lekar> getLekari() {
			return lekari;
		}
		
		public ArrayList<MedicinskaSestra> getMedicinskesestre() {
			return medicinskesestre;
		}

		public void setLekari(ArrayList<Lekar> lekari) {
			this.lekari = lekari;
		}



		public void setMedicinskesestre(ArrayList<MedicinskaSestra> medicinskesestre) {
			this.medicinskesestre = medicinskesestre;
		}


		public ArrayList<Pacijenti> getPacijent() {
			return pacijent;
		}

		public void setPacijent(ArrayList<Pacijenti> pacijent) {
			this.pacijent = pacijent;
		}

		
		public ArrayList<Pregledi> getPregled() {
			return pregled;
		}

		public void setPregled(ArrayList<Pregledi> pregled) {
			this.pregled = pregled;
		}


		public ArrayList<ZdravstvenaKnjizica> getKnjizica() {
			return knjizica;
		}


		public void dodajPacijenta(Pacijenti pacijent) {
			this.pacijent.add(pacijent);
			
		}
		public Pacijenti nadjiPacijenta(String korisnickoIme) {
			for(Pacijenti pacijent: pacijent) {
				if (pacijent.getKorisnickoIme().equals(korisnickoIme)) {
					return pacijent;
				}
				
			}
			return null;
		
		}
		public void obrisiPacijenta(Pacijenti pacijent) {
			this.pacijent.remove(pacijent);
		}
		public Pacijenti loginPacijent(String korisnickoime,String sifra) {
			for(Pacijenti pacijent:pacijent) {
				if(pacijent.getKorisnickoIme().equalsIgnoreCase(korisnickoime)&& pacijent.getLozinka().equals(sifra)) {
					return pacijent;
				}
			}
			return null;
		}
		
		
		public void dodajLekara(Lekar lekar) {
			this.lekari.add(lekar);
			
		}
		public void obrisiLekara(Lekar lekar) {
			this.lekari.remove(lekar);
		}
		
		public  Lekar nadjiLekara(String KorisnickoIme) {
			boolean postoji=false;
			for (Lekar lekar : lekari) {
				if (lekar.getKorisnickoIme().equals(KorisnickoIme)) {
					return lekar;
					}
			
			}
			return null;
		
		}
		public Lekar loginLekara(String korisnickoIme,String lozinka) {
			for(Lekar lekar: lekari) {
				if(lekar.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && lekar.getLozinka().equals(lozinka)) {
					return lekar;
				}
				
			}
			return null;
		}
		
		public void dodajMedSestru(MedicinskaSestra medicinskesestre) {
			this.medicinskesestre.add(medicinskesestre);
			
		}
		public void obrisiMedSestre(MedicinskaSestra medicinskesestre) {
			this.medicinskesestre.remove(medicinskesestre);
			
		}
		public MedicinskaSestra nadjiMedsestre(String korisnickoIme) {
			boolean postoji=false;
			for (MedicinskaSestra medicinskesestre : medicinskesestre) {
				if (medicinskesestre.getKorisnickoIme().equals(korisnickoIme)) {
					postoji=true;
					return medicinskesestre;
					}
			if(postoji==false) {
					System.out.println("Ne postoji medicinska sestra sa unetim jmbg-om.Unesite opet");
				}
			}
			return null;
		}
		public void dodajPreglede(Pregledi pregled) {
			this.pregled.add(pregled);
		}
		public void obrisiPreglede(Pregledi pregled) {
			this.pregled.remove(pregled);
		}
		public  Pregledi nadjiPreglede(String id) {
			for (Pregledi pregled : pregled) {
				if (pregled.getId().equals(id)) {
					return pregled;
				}
				else {
					System.out.println("Ne postoji pregled sa unetim id-om.Unesite opet");
				}
			}
			return null;
		}
		public void dodajZdknjizicu(ZdravstvenaKnjizica zdknjizica) {
			this.knjizica.add(zdknjizica);
			
		}
		public void obrisiZdknjizicu(ZdravstvenaKnjizica zdknjizica) {
			this.knjizica.remove(zdknjizica);
		}
		public  ZdravstvenaKnjizica nadjZdravstvenaKnjizica(String id) {
			for (ZdravstvenaKnjizica zdknjizica : knjizica) {
				if (zdknjizica.getBroj().equals(id)) {
					return zdknjizica;
				}
				

				}
			return null;
		}
	public void snimiLekare(String fajlIme) {
		try {
			File file = new File("src/fajlovi/"+fajlIme);
			String doktor = "";
			for (Lekar lekar : lekari) {
				doktor +=lekar.getIme() + "|" + lekar.getPrezime()+"|"
						+ lekar.getJmbg() + "|" + Pol.toInt(lekar.getPol()) + "|"
						+ lekar.getAdresa() + "|" + lekar.getBrojTelefona() + "|" + lekar.getKorisnickoIme() + "|"
						+ lekar.getLozinka() +"|" +Sluzba.toInt(lekar.getSluzba())+"|"+lekar.getSpecijalizacija() +"|"+lekar.getPlata()+"\n";
				
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file,false));
			writer.write(doktor);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja lekara.");
		}
	}
	
	public void snimiMedsestre(String fajlIme) {
		try {
			File file = new File("src/fajlovi/"+fajlIme);
			String content = "";
			for (MedicinskaSestra medicinskasestra : medicinskesestre) {
				content +=medicinskasestra.getIme() + "|" + medicinskasestra.getPrezime()
						+ "|" + medicinskasestra.getJmbg() + "|" + Pol.toInt(medicinskasestra.getPol()) + "|"
						+ medicinskasestra.getAdresa() + "|" + medicinskasestra.getBrojTelefona() + "|" + medicinskasestra.getKorisnickoIme() + "|"
						+ medicinskasestra.getLozinka()+"|" +medicinskasestra.getPlata()+"|" + Sluzba.toInt(medicinskasestra.getSluzba())+"\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file,false));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja medicinskih sestara.");
		}
			
		
	}
	public void snimiPreglede(String fajlIme) {
		try {
			File file = new File("src/fajlovi/"+fajlIme);
			String podaci = "";
			for (Pregledi pregled :pregled) {
				podaci +=pregled.getId()+"|"+pregled.getPacijent().getKorisnickoIme() + "|" + pregled.getDoktor().getKorisnickoIme() +"|"+pregled.getDatum()+"|"+pregled.getSoba()+"|"+pregled.getOpis() + "|" +Status.toInt(pregled.getStatus())+"|"+pregled.getCena()+"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,false));
			writer.write(podaci);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja pregleda.");
		}
		
	}
	public void snimiZdknjzicu(String fajlIme) {
		try {
			File file=new File("src/fajlovi/"+fajlIme);
			String pacijent= "";
			for (ZdravstvenaKnjizica zdknjizica :knjizica) {
				pacijent +=zdknjizica.getBroj() + "|" + zdknjizica.getDatum() +"|"+Kategorija.toInt(zdknjizica.getKategorija())+"|"+"\n";
				
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,false));
			writer.write(pacijent);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja zdravstvene knjizice.");
		}
		
	}
	public void snimiPacijente(String fajlIme) {
		try {
			File file = new File("src/fajlovi/"+fajlIme);
			String osoba = "";
			for (Pacijenti pacijent:pacijent) {
				osoba+=pacijent.getIme()+ "|" + pacijent.getPrezime() + "|" +
					   pacijent.getJmbg()+ "|" + Pol.toInt(pacijent.getPol()) + "|" +
					   pacijent.getAdresa()+ "|" +pacijent.getBrojTelefona()+ "|" +
					   pacijent.getKorisnickoIme()+ "|"+ pacijent.getLozinka()+ "|"+
					   pacijent.getJmbgLekara().getKorisnickoIme()+"|" +pacijent.getIdKnjizica().getBroj()+ "|"+"\n";
				}

			BufferedWriter writer= new BufferedWriter(new FileWriter(file,false));
			writer.write(osoba);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja pacijenata.");
	}
	}
	public void ucitajLekare(String fajlIme) {
		try {
			File file = new File("src/fajlovi/"+fajlIme);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line=null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String ime=split[0];
				String prezime=split[1];
				String jmbg=split[2];
				int PolInt=Integer.parseInt(split[3]);
				Pol pol=Pol.fromInt(PolInt);
				String adresa=split[4];
				String brojTelefona=split[5];
				String korisnickoIme=split[6];
				String lozinka=split[7];
				int SluzbaInt=Integer.parseInt(split[8]);
				Sluzba sluzba=Sluzba.fromInt(SluzbaInt);
				String specijalizacija=split[9];
				double plata=Double.parseDouble(split[10]);
				
				Lekar lekar=new Lekar(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, sluzba, specijalizacija, plata);
				lekari.add(lekar);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Neuspesno ucitavanje lekara.");
			e.printStackTrace();
		}
	}
	public void ucitajMedSestre(String fajlIme) {
		try {
			File file = new File("src/fajlovi/"+fajlIme);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line=null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String ime= split[0];
				String prezime = split[1];
				String jmbg = split[2];
				int Polint=Integer.parseInt(split[3]);
				Pol pol=Pol.fromInt(Polint);
				String adresa = split[4];
				String brojTelefona = split[5];
				String korisnickoIme = split[6];
				String lozinka = split[7];
				double plata= Double.parseDouble(split[8]);
				int SluzbaInt=Integer.parseInt(split[9]);
				Sluzba sluzba=Sluzba.fromInt(SluzbaInt);
				MedicinskaSestra sestra =new MedicinskaSestra(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata, sluzba);
				medicinskesestre.add(sestra);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Neuspesno ucitavanje medicinskih sestara. ");
			e.printStackTrace();
		}
	}
	public void ucitajPacijente(String fajlIme) {
		try {
			File file = new File("src/fajlovi/"+fajlIme);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line=null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String ime= split[0];
				String prezime = split[1];
				String jmbg = split[2];
				int Polint=Integer.parseInt(split[3]);
				Pol pol=Pol.valueOf(Pol.fromInt(Polint)+"");
				String adresa = split[4];
				String brojTelefona = split[5];
				String korisnickoIme = split[6];
				String lozinka = split[7];
				String doktor=split[8];
				Lekar jmbgLekara=(Lekar) nadjiLekara(doktor);
				String knjizicaStr=split[9];
				ZdravstvenaKnjizica idKnjizica=(ZdravstvenaKnjizica) nadjZdravstvenaKnjizica(knjizicaStr);	
				Pacijenti pacijent1=new Pacijenti(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, jmbgLekara, idKnjizica);
				pacijent.add(pacijent1);
				
				
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Neuspesno ucitavanje pacijenata.");
			e.printStackTrace();
			
		}
	}
	public void ucitajKnjizice(String fajlIme) {
		try {
			File file=new File("src/fajlovi/"+fajlIme);
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=reader.readLine())!=null) {
				String[]split=line.split("\\|");
				String broj = split[0];
				String datum=split[1];
				int kategorijaInt=Integer.parseInt(split[2]);
				Kategorija kategorija=Kategorija.valueOf(Kategorija.fromInt(kategorijaInt)+"");
				ZdravstvenaKnjizica knjizica1=new ZdravstvenaKnjizica(broj,datum,kategorija);
				knjizica.add(knjizica1);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Neuspesno ucitavanje knjizice.");
			e.printStackTrace();
		}
	}
	public void ucitajPreglede(String fajlIme) {
		try {
			File file=new File("src/fajlovi/"+fajlIme);
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=reader.readLine())!=null) {
				String[]split=line.split("\\|");
				String id = split[0];
				String pacijentStr=split[1];
				Pacijenti pacijent=(Pacijenti) nadjiPacijenta(pacijentStr);
				String lekar1=split[2];
				Lekar lekar=(Lekar) nadjiLekara(lekar1);
				String datum=split[3];
				String soba=split[4];
				String opis=split[5];
				int status1=Integer.parseInt(split[6]);
				Status status=Status.valueOf(Status.fromInt(status1)+"");
				double cena=Double.parseDouble(split[7]);
				
				Pregledi pregled1=new Pregledi(id,pacijent,lekar,datum,soba,opis,status,cena);
				pregled.add(pregled1);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Neuspesno ucitavanje pregleda.");
			e.printStackTrace();
		}
	}
	public MedicinskaSestra login(String korisnickoIme, String sifra) {
		for (MedicinskaSestra sestra : medicinskesestre) {
			if(sestra.getKorisnickoIme().equalsIgnoreCase(korisnickoIme)
					&& sestra.getLozinka().equals(sifra)) {
				return sestra;
			}
		}
		return null;
	}
	public static void ispis(DomZdravlja dom) {
		for(Lekar lekar:dom.getLekari()) {
			System.out.println(lekar+"\n");
		}
		for(MedicinskaSestra medicinskaSestra:dom.getMedicinskesestre()) {
			System.out.println(medicinskaSestra+"\n");
		}
		for(Pacijenti pacijent:dom.getPacijent()) {
			System.out.println(pacijent +"\n");
		}
		for(ZdravstvenaKnjizica zdravstvenaKnjizica:dom.getKnjizica()) {
			System.out.println(zdravstvenaKnjizica+"\n");
		}
		for(Pregledi pregledi:dom.getPregled()) {
			System.out.println(pregledi+"\n");
		}
		
	}
			
	}
	
	
				
		
		
	
	

	
		
	
	
	
					
		
		
	
		

	
				




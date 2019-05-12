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
import enumeracija.Uloga;
import korisnik.Lekar;
import korisnik.MedicinskaSestra;
import korisnik.Pacijenti;
import pregledi.Pregledi;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;



	public class DomZdravlja {
		private ArrayList<korisnik.Lekar> lekari;
		private ArrayList<korisnik.MedicinskaSestra>medicinskesestre;
		private ArrayList<korisnik.Pacijenti>pacijent;
		private ArrayList<pregledi.Pregledi>pregled;
		private ArrayList<zdravstvenaKnjizica.ZdravstvenaKnjizica>zdknjizica1;
		
		public ArrayList<zdravstvenaKnjizica.ZdravstvenaKnjizica> getZdknjizica1() {
			return zdknjizica1;
		}




		public void setZdknjizica1(ArrayList<zdravstvenaKnjizica.ZdravstvenaKnjizica> zdknjizica1) {
			this.zdknjizica1 = zdknjizica1;
		}




		public ArrayList<pregledi.Pregledi> getPregled() {
			return pregled;
		}




		public void setPregled(ArrayList<pregledi.Pregledi> pregled) {
			this.pregled = pregled;
		}




		public ArrayList<zdravstvenaKnjizica.ZdravstvenaKnjizica> getZdknjizica() {
			return zdknjizica1;
		}




		public void setZdknjizica(ArrayList<zdravstvenaKnjizica.ZdravstvenaKnjizica> zdknjizica) {
			this.zdknjizica1 = zdknjizica;
		}

		
	
		public DomZdravlja() {
			this.lekari=new ArrayList<korisnik.Lekar>();
			this.medicinskesestre=new ArrayList<korisnik.MedicinskaSestra>();
			this.pacijent=new ArrayList<korisnik.Pacijenti>();
			this.pregled=new ArrayList<pregledi.Pregledi>();
			this.zdknjizica1=new ArrayList<zdravstvenaKnjizica.ZdravstvenaKnjizica>();
		}
			
		


		public ArrayList<korisnik.Lekar> getLekari() {
			return lekari;
		}

		public void setLekari(ArrayList<korisnik.Lekar> lekari) {
			this.lekari = lekari;
		}

		public ArrayList<korisnik.MedicinskaSestra> getMedicinskesestre() {
			return medicinskesestre;
		}

		public void setMedicinskesestre(ArrayList<korisnik.MedicinskaSestra> medicinskesestre) {
			this.medicinskesestre = medicinskesestre;
		}

		public ArrayList<korisnik.Pacijenti> getPacijent() {
			return pacijent;
		}

		public void setPacijent(ArrayList<korisnik.Pacijenti> pacijent) {
			this.pacijent = pacijent;
		}
		
		
		public void dodajPacijenta(Pacijenti pacijent) {
			this.pacijent.add(pacijent);
			
		}
		
		public void obrisiPacijenta(Pacijenti pacijent) {
			this.pacijent.remove(pacijent);
		}

		public Pacijenti nadjiPacijenta(String jmbg) {
			for (Pacijenti pacijent : pacijent) {
				if (pacijent.getJmbg().equals(jmbg)) {
					return pacijent;
				}
				else {
					System.out.println("Ne postoji pacijent sa unetim jmbg-om.Unesite ponovo.");
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
		
		public  Lekar nadjiLekara(String jmbg) {
			for (Lekar lekar : lekari) {
				if (lekar.getJmbg().equals(jmbg)) {
					return lekar;
					}
			else {
			System.out.println("Ne postoji lekar sa unetim jbmg-om.Unesite ponovo");
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
		public MedicinskaSestra nadjiMedsestre(String jmbg) {
			for (MedicinskaSestra medicinskesestre : medicinskesestre) {
				if (medicinskesestre.getJmbg().equals(jmbg)) {
					return medicinskesestre;
					}
				else {
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
			this.zdknjizica1.add(zdknjizica);
			
		}
		public void obrisiZdknjizicu(ZdravstvenaKnjizica zdknjizica) {
			this.zdknjizica1.remove(zdknjizica);
		}
		public  ZdravstvenaKnjizica nadjiZdknjizicu(int Broj) {
			for (ZdravstvenaKnjizica zdknjizica : zdknjizica1) {
				if (zdknjizica.getBroj()==(Broj)) {
					return zdknjizica;
				}
				else {
					System.out.println("Ne postoji zdravstvena knjizica sa unetim brojem.Unesite opet");
				}
			}
			return null;
		
		}
	public void snimiLekare(String lekari) {
		try {
			File file = new File("src/fajlovi/" + lekari);
			String doktor = "";
			for (Lekar lekar : this.lekari) {
				doktor += lekar.getId() + "|" + lekar.getIme() + "|" + lekar.getPrezime()
						+ "|" + lekar.getJmbg() + "|" + lekar.getPol() + "|"
						+ lekar.getAdresa() + "|" + lekar.getBrojTelefona() + "|" + lekar.getKorisnickoIme() + "|"
						+ lekar.getLozinka() +"|"+ lekar.getUloga() +"|" +lekar.getPlata()+"|" +lekar.getSpecijalizacija()+"|"+ lekar.getSluzba()+"|"+lekar.getPacijent()+"|"+lekar.getPregled()+"\n";
				
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(doktor);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja lekara.");
		}
	}
	
	public void snimiMedsestre(String medicniskesestre) {
		try {
			File file = new File("src/fajlovi/" + medicinskesestre);
			String content = "";
			for (MedicinskaSestra medicinskasestra : medicinskesestre) {
				content += medicinskasestra.getId() + "|" + medicinskasestra.getIme() + "|" + medicinskasestra.getPrezime()
						+ "|" + medicinskasestra.getJmbg() + "|" + medicinskasestra.getPol() + "|"
						+ medicinskasestra.getAdresa() + "|" + medicinskasestra.getBrojTelefona() + "|" + medicinskasestra.getKorisnickoIme() + "|"
						+ medicinskasestra.getLozinka() +"|"+ medicinskasestra.getUloga() +"|" +medicinskasestra.getPlata()+"|" + medicinskasestra.getSluzba()+"\n";
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja medicinskih sestara.");
		}
			
		
	}
	public void snimiPreglede(String pregledi) {
		try {
			File file = new File("src/fajlovi/" + pregledi);
			String podaci = "";
			for (Pregledi pregled :this.pregled) {
				pregledi +=pregled.getId()+"|"+pregled.getPacijent() + "|" + pregled.getLekar() +"|"+pregled.getDatum()+"|"+pregled.getSoba()+"|"+pregled.getOpis() + "|" +pregled.getStatus()+"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(podaci);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja pregleda.");
		}
		
	}
	public void snimiZdknjzicu(String zdknjizica) {
		try {
			new File("src/fajlovi/" + zdknjizica);
			String knjizica = "";
			for (ZdravstvenaKnjizica zdknjizica1 :this.zdknjizica1) {
				knjizica +=zdknjizica1.getBroj() + "|" + zdknjizica1.getDatum() +"|"+zdknjizica1.getKategorija()+"\n";
				
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(zdknjizica));
			writer.write(knjizica);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja zdravstvene knjizice.");
		}
		
	}
	public void snimiPacijente(String pacijenti) {
		try {
			File file = new File("src/fajlovi/" +pacijenti);
			String osoba = "";
			for (Pacijenti pacijent:this.pacijent) {
				osoba+= pacijent.getId()+"|" + pacijent.getIme() + "|" +pacijent.getPrezime()+
				 "|" +pacijent.getJmbg() + "|" + pacijent.getPol() + "|"
				+pacijent.getAdresa() + "|" +pacijent.getBrojTelefona() + "|" +pacijent.getKorisnickoIme() + "|"
				+ pacijent.getLozinka() +"|"+pacijent.getUloga() +"|" +pacijent.getIzabraniLekar()+"|" + pacijent.getZdknjizica()+"\n";
				
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(osoba);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom snimanja pacijenata.");
	}
	}
	public void ucitajLekare(Lekar lekari) {
		try {
			File file = new File("src/fajlovi/" + lekari);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line=null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime= split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String pols =split[4];
				Pol pol=Pol.valueOf(pols);
				String adresa = split[5];
				String brojTelefona = split[6];
				String korisnickoIme = split[7];
				String lozinka = split[8];
				String ulogas =split[9];
				Uloga uloga=Uloga.valueOf(ulogas);
				String platString=split[10];
				double plata= Double.parseDouble(platString);
				String specijalizacija=split[11];
				String sluzbas=split[12];
				Sluzba sluzba=Sluzba.valueOf(sluzbas);
				ArrayList<Pacijenti> pacijent= new ArrayList<Pacijenti>();
				ArrayList<Pregledi>pregled=new ArrayList<Pregledi>();
				Lekar doktor = new Lekar(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, uloga,plata,specijalizacija,sluzba,new ArrayList<Pacijenti>(),new ArrayList<Pregledi>());
				this.lekari.add(doktor);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Neuspesno ucitavanje lekara.");
			e.printStackTrace();
		}
	}
	public void ucitajMedSestre(MedicinskaSestra medicinskesestre) {
		try {
			File file = new File("src/fajlovi/" +medicinskesestre);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line=null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime= split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String pols =split[4];
				Pol pol=Pol.valueOf(pols);
				String adresa = split[5];
				String brojTelefona = split[6];
				String korisnickoIme = split[7];
				String lozinka = split[8];
				String ulogas =split[9];
				Uloga uloga=Uloga.valueOf(ulogas);
				String platString=split[10];
				double plata= Double.parseDouble(platString);
				String sluzbas=split[11];
				Sluzba sluzba=Sluzba.valueOf(sluzbas);
				MedicinskaSestra medicinskesestre1 = new MedicinskaSestra (id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, uloga,plata,sluzba);
				this.medicinskesestre.add(medicinskesestre1);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Neuspesno ucitavanje medicinskih sestara. ");
			e.printStackTrace();
		}
	}
	public void ucitajPacijente(String pacijenti) {
		try {
			File file = new File("src/fajlovi/" +pacijenti);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line=null;
			while ((line = reader.readLine()) != null) {
				String[] split = line.split("\\|");
				String id = split[0];
				String ime= split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String pols=split[4];
				Pol pol =Pol.valueOf(pols);
				String adresa = split[5];
				String brojTelefona = split[6];
				String korisnickoIme = split[7];
				String lozinka = split[8];
				String ulogas =split[9];
				Uloga uloga=Uloga.valueOf(ulogas);
				Lekar izabraniLekar=split[10];
				Pacijenti pacijent= new Pacijenti (id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, uloga,izabraniLekar,zdknjizica);
				this.pacijent.add(pacijent);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Neuspesno ucitavanje pacijenata.");
			e.printStackTrace();
			
		}
	}
	public void ucitajKnjizice(String zdknjizica) {
		try {
			File file=new File("src/fajlovi/"+zdknjizica);
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=reader.readLine())!=null) {
				String[]split=line.split("\\|");
				String brojString = split[0];
				int broj=Integer.parseInt(brojString);
				String datum=split[1];
				String kategorijas=split[2];
				Kategorija kategorija=Kategorija.valueOf(kategorijas);
				ZdravstvenaKnjizica knjizica=new ZdravstvenaKnjizica(broj,datum,kategorija);
				this.zdknjizica1.add(knjizica);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Neuspesno ucitavanje knjizice.");
			e.printStackTrace();
		}
	}
	public void ucitajPreglede(String pregledi) {
		try {
			File file=new File("src/fajlovi/"+pregledi);
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=reader.readLine())!=null) {
				String[]split=line.split("\\|");
				String id = split[0];
				String pacijent=split[1];
				String lekar=split[2];
				String datum=split[3];
				String sobaS=split[4];
				int soba=Integer.parseInt(sobaS);
				String opis=split[5];
				String statuss=split[6];
				Status status=Status.valueOf(statuss);
				Pregledi pregled=new Pregledi(id,pacijent,lekar,datum,soba,opis,status);
				this.pregled.add(pregled);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Neuspesno ucitavanje pregleda.");
			e.printStackTrace();
		}
	}
			
	}
	
	
				
		
		
	
	

	
		
	
	
	
					
		
		
	
		

	
				




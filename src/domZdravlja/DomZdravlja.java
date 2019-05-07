package domZdravlja;


	import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

		public Pacijenti nadjiPacijenta(String korisnickoIme) {
			for (Pacijenti pacijent : pacijent) {
				if (pacijent.getKorisnickoIme().equals(korisnickoIme)) {
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
		
		public  Lekar nadjiLekara(String korisnickoIme) {
			for (Lekar lekar : lekari) {
				if (lekar.getKorisnickoIme().equals(korisnickoIme)) {
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
			for (MedicinskaSestra medicinskesestre : medicinskesestre) {
				if (medicinskesestre.getKorisnickoIme().equals(korisnickoIme)) {
					return medicinskesestre;
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
		public  Pregledi nadjiPreglede(String Opis) {
			for (Pregledi pregled : pregled) {
				if (pregled.getOpis().equals(Opis)) {
					return pregled;
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
			}
			return null;
		
		}
	public void snimiLekare(String lekari) {
		try {
			File file = new File("src/fajlovi/" + lekari);
			String content = "";
			for (Lekar lekar :this.lekari) {
				content += lekar.getPlata() + "|" + lekar.getSpecijalizacija() + "|"
						+ lekar.getSluzba() + "|" + lekar.getPacijent() + "|"
						+ lekar.getPregled()+ "\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja lekara.");
		}
	}
	public void snimiMedsestre(String medicniskesestre) {
		try {
			File file = new File("src/fajlovi/" + medicniskesestre);
			String content = "";
			for (MedicinskaSestra medicinskesestre :this.medicinskesestre) {
				content +=medicinskesestre.getPlata() + "|" + medicinskesestre.getSluzba() +"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja medicinskih sestaraS.");
		}
		
	}
	public void snimiPreglede(String pregledi) {
		try {
			File file = new File("src/fajlovi/" + pregledi);
			String content = "";
			for (Pregledi pregled :this.pregled) {
				content +=pregled.getPacijent() + "|" + pregled.getLekar() +"|"+pregled.getDatum()+"|"+pregled.getSoba()+"|"+pregled.getOpis() + "|" +pregled.getStatus()+"\n";
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja pregleda.");
		}
		
	}
	public void snimiZdknjzicu(String zdknjizica) {
		try {
			File file = new File("src/fajlovi/" + zdknjizica);
			String content = "";
			for (ZdravstvenaKnjizica zdknjizica1 :this.zdknjizica1) {
				content +=zdknjizica1.getBroj() + "|" + zdknjizica1.getDatum() +"|"+zdknjizica1.getKategorija()+"\n";
				
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom snimanja zdravstvene knjizice.");
		}
		
	}
	
		
	}
	
	
					
		
		
	
		

	
				




package guiZaIzmenuIDodavanje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

import domZdravlja.DomZdravlja;
import enumeracija.Pol;
import enumeracija.Sluzba;
import korisnik.Lekar;
import net.miginfocom.swing.MigLayout;

public class LekariForma extends JFrame {
	private Sluzba PravniPoslovi=Sluzba.PRAVNOEKONOMSKIPOSLOVI;
	private Sluzba TehnickiPoslovi=Sluzba.TEHNICKIPOSLOVI;
	private JLabel lblIme=new JLabel("Ime");
	private JTextField txtIme=new JTextField(20);
	private JLabel lblPrezime=new JLabel("Prezime");
	private JTextField txtPrezime=new JTextField(20);
	private JLabel lblJMBG=new JLabel("JMBG");
	private JTextField txtJMBG=new JTextField(20);
	private JLabel lblPol=new JLabel("Pol");
	private JLabel lblAdresa=new JLabel("Adresa");
	private JTextField txtAdresa=new JTextField(20);
	private JLabel lblTelefon=new JLabel("Adresa");
	private JTextField txtTelefon=new JTextField(20);
	private JLabel lblKorisnickoIme=new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme=new JTextField(20);
	private JLabel lblLozinka=new JLabel("Lozinka");
	private JPasswordField pfSifra=new JPasswordField(20);
	private JLabel lblSluzba=new JLabel("Sluzba");
	private JLabel lblSpecijalizacija=new JLabel("Specijalizacija");
	private JTextField txtSpecijalizacija=new JTextField(20);
	private JLabel lblPlata=new JLabel("Plata");
	private JTextField txtPlata=new JTextField(20);
	private JComboBox<Pol>cbPol=new JComboBox<Pol>(Pol.values());
	private JComboBox<Sluzba>cbSluzba=new JComboBox<Sluzba>(Sluzba.values());
	private JButton btnOK=new JButton("OK");
	private JButton btnCancel=new JButton("Cancel");
	private DomZdravlja dom;
	private Lekar lekar;
	private JTable tabela;
	
	public LekariForma(DomZdravlja dom,Lekar lekar) {
		this.dom=dom;
		this.lekar=lekar;
		cbSluzba.removeItem(PravniPoslovi);
		cbSluzba.removeItem(TehnickiPoslovi);
		if(this.lekar==null) {
			setTitle("Dodavanje lekara");
		}else {
			setTitle("Izmena podataka- " +this.lekar.getKorisnickoIme());
		}
		setSize(800,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(true);
		initGui();
		if(lekar !=null) {popuniPolja();}
		initListeners();
		pack();
		
	}
	private void initGui() {
		MigLayout mig=new MigLayout("wrap 2");
		setLayout(mig);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJMBG);
		add(txtJMBG);
		add(lblPol);
		add(cbPol);
		add(lblAdresa);
		add(txtAdresa);
		add(lblTelefon);
		add(txtTelefon);
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblLozinka);
		add(pfSifra);
		add(lblSluzba);
		add(cbSluzba);
		add(lblSpecijalizacija);
		add(txtSpecijalizacija);
		add(lblPlata);
		add(txtPlata);
		add(new JLabel());
		add(btnOK,"split 2");
		add(btnCancel);
		
	}
	private void popuniPolja() {
		txtIme.setText(lekar.getIme());
		txtPrezime.setText(lekar.getPrezime());
		txtJMBG.setText(lekar.getJmbg());
		cbPol.setSelectedItem(this.lekar.getPol());
		txtAdresa.setText(lekar.getAdresa());
		txtTelefon.setText(lekar.getBrojTelefona());
		txtKorisnickoIme.setText(lekar.getKorisnickoIme());
		pfSifra.setText(lekar.getLozinka());
		cbSluzba.setSelectedItem(this.lekar.getSluzba());
		txtSpecijalizacija.setText(lekar.getSpecijalizacija());
		txtPlata.setText(String.valueOf(lekar.getPlata()));
	}
	
	private void initListeners() {
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()==true) {
					String ime=txtIme.getText().trim();
					String prezime=txtPrezime.getText().trim();
					String jmbg=txtJMBG.getText().trim();
					Pol pol=(Pol) cbPol.getSelectedItem();
					String adresa=txtAdresa.getText().trim();
					String telefon=txtTelefon.getText().trim();
					String korisnickoIme=txtKorisnickoIme.getText().trim();
					String sifra=new String(pfSifra.getPassword()).trim();
					Sluzba sluzba=(Sluzba) cbSluzba.getSelectedItem();
					String specijalizacija=txtSpecijalizacija.getText().trim();
					double plata=Double.parseDouble(txtPlata.getText().trim());
					if(lekar==null) {
						Lekar lekar=new Lekar(ime,prezime,jmbg,pol,adresa,telefon,korisnickoIme,sifra,sluzba,specijalizacija,plata);
						dom.getLekari().add(lekar);
						
					}else {
						lekar.setIme(ime);
						lekar.setPrezime(prezime);
						lekar.setJmbg(jmbg);
						lekar.setPol(pol);
						lekar.setAdresa(adresa);
						lekar.setBrojTelefona(telefon);
						lekar.setKorisnickoIme(korisnickoIme);
						lekar.setLozinka(sifra);
						lekar.setSluzba(sluzba);
						lekar.setSpecijalizacija(specijalizacija);
						lekar.setPlata(plata);
						
					}
					String fajlLekari="lekari.txt";
					dom.snimiLekare(fajlLekari);
					LekariForma.this.dispose();
					LekariForma.this.setVisible(false);
					
				}
	}
				private boolean validacija() {
					boolean ok = true;
					String message = "Molimo popravite sledece greske u unosu:\n";
					
					if(txtIme.getText().trim().equals("")) {
						message += "- Morate uneti ime\n";
						ok = false;
					}
					if(txtPrezime.getText().trim().equals("")) {
						message += "- Morate uneti prezime\n";
						ok = false;
					}
					if(txtJMBG.getText().trim().equals("")) {
						message += "- Morate uneti jmbg\n";
						ok = false;
					}

					if(txtAdresa.getText().trim().equals("")) {
						message += "- Morate uneti adresu\n";
						ok = false;
						}
					if(txtKorisnickoIme.getText().trim().equals("")) {
						message += "- Morate uneti korisnicko ime\n";
						ok = false;
					}
					String password = new String(pfSifra.getPassword()).trim();
					if(password.trim().equals("")) {
						message += "- Unesite lozinku\n";
						ok = false;
					}
					try {
						Integer.parseInt(txtPlata.getText().trim());
					}catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Platu upisite kao decimalnu vrednost.", "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
						ok = false;
					}

					if(ok == false) {
						JOptionPane.showMessageDialog(null, message, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
					}
					return ok;

				}
				});
	}
}
	

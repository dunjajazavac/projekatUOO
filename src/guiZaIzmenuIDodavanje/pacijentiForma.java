package guiZaIzmenuIDodavanje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.w3c.dom.CDATASection;

import domZdravlja.DomZdravlja;
import enumeracija.Pol;
import korisnik.Lekar;
import korisnik.Pacijenti;
import net.miginfocom.swing.MigLayout;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;

public class pacijentiForma extends JFrame {
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("Jmbg");
	private JTextField txtJmbg = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblTelefon = new JLabel("Telefon");
	private JTextField txtTelefon = new JTextField(20);
	private JLabel lblKorisnickoIme= new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JLabel lblIzabraniLekar = new JLabel("Izabrani lekar");
	private JComboBox<String> cbLekar = new JComboBox<String>();
	private JLabel lblIdKnjizice = new JLabel("Id knjizice");
	private JTextField txtIdKnjizice = new JTextField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnOtkazi = new JButton("Otkazi");
	private DomZdravlja domZdravlja;
	private Pacijenti pacijent;
	private Lekar lekar;
	
	public pacijentiForma(DomZdravlja domZdravlja,Pacijenti pacijent) {
		this.domZdravlja=domZdravlja;
		this.pacijent=pacijent;
		if(pacijent != null) {
			setTitle(pacijent.getKorisnickoIme() + " - Izmena podataka");
		}else {
			setTitle("Dodavanje pacijenta");
			}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		if(pacijent != null) { 
		popuniPolja(); }
		initListeners();
		pack();
		
	}
private void initGUI() {
		
		for (Lekar lekar : this.domZdravlja.getLekari()) {
			cbLekar.addItem(lekar.getKorisnickoIme());
		}
		MigLayout mig = new MigLayout("wrap 2");
		setLayout(mig);
		add(lblIme);			
		add(txtIme);
		add(lblPrezime);		
		add(txtPrezime);
		add(lblJmbg);			
		add(txtJmbg);
		add(lblAdresa);			
		add(txtAdresa);
		add(lblTelefon);		
		add(txtTelefon);
		add(lblKorisnickoIme);	
		add(txtKorisnickoIme);
		add(lblLozinka);		
		add(pfLozinka);
		add(lblIzabraniLekar);	
		add(cbLekar);
		add(lblIdKnjizice);		
		add(txtIdKnjizice);
		add(lblPol);			
		add(cbPol);
		add(new JLabel());		
		add(btnOk, "split 2"); 
		add(btnOtkazi);	
}
private void initListeners() {
	btnOk.addActionListener(new ActionListener() {
		@Override
		
		public void actionPerformed(ActionEvent e) {
			if(validacija() == true) {
				
				String ime = txtIme.getText().trim();
				String prezime = txtPrezime.getText().trim();
				String jmbg = txtJmbg.getText().trim();
				Pol pol = (Pol) cbPol.getSelectedItem();
				String adresa = txtAdresa.getText().trim();
				String brojTelefona = txtTelefon.getText().trim();
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(pfLozinka.getPassword()).trim();
				String knjizica = txtIdKnjizice.getText().trim();
				String lekarKorisnicko=cbLekar.getSelectedItem().toString();
				Lekar izabraniLekar = (Lekar) domZdravlja.nadjiLekara(lekarKorisnicko);
				ZdravstvenaKnjizica idKnjizice = (ZdravstvenaKnjizica) domZdravlja.nadjZdravstvenaKnjizica(knjizica);
				if(pacijent == null) {
					Pacijenti pacijent = new Pacijenti(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme,
							sifra,izabraniLekar, idKnjizice);
					domZdravlja.getPacijent().add(pacijent);
				}else {
					pacijent.setIme(ime);
					pacijent.setPrezime(prezime);
					pacijent.setKorisnickoIme(korisnickoIme);
					pacijent.setPol(pol);
					pacijent.setAdresa(adresa);
					pacijent.setBrojTelefona(brojTelefona);
					pacijent.setKorisnickoIme(korisnickoIme);
					pacijent.setLozinka(sifra);
					pacijent.setJmbgLekara(izabraniLekar);
					pacijent.setIdKnjizica(idKnjizice);
					
				}
				String fajlPacijenata = "pacijenti.txt";
				domZdravlja.snimiPacijente(fajlPacijenata);
				pacijentiForma.this.dispose();
				pacijentiForma.this.setVisible(false);
			}
		}
	});
}
private void popuniPolja() {
	txtIme.setText(this.pacijent.getIme());
	txtPrezime.setText(this.pacijent.getPrezime());
	txtJmbg.setText(this.pacijent.getJmbg());
	cbPol.setSelectedItem(this.pacijent.getPol());
	txtAdresa.setText(this.pacijent.getAdresa());
	txtTelefon.setText(this.pacijent.getBrojTelefona());
	txtKorisnickoIme.setText(this.pacijent.getKorisnickoIme());
	pfLozinka.setText(this.pacijent.getLozinka());
	txtIdKnjizice.setText(this.pacijent.getIdKnjizica().getBroj());
	cbLekar.setSelectedItem(this.pacijent.getJmbgLekara());
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
	if(txtJmbg.getText().trim().equals("")) {
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
	String password = new String(pfLozinka.getPassword()).trim();
	if(password.trim().equals("")) {
		message += "- Unesite lozinku\n";
		ok = false;
	}
	

	if(ok == false) {
		JOptionPane.showMessageDialog(null, message, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
	}
	return ok;
}
}


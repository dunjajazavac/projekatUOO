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

import domZdravlja.DomZdravlja;
import enumeracija.Pol;
import enumeracija.Sluzba;
import korisnik.MedicinskaSestra;
import net.miginfocom.swing.MigLayout;

public class medSestraForma extends JFrame {
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("Jmbg");
	private JTextField txtJmbg = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(enumeracija.Pol.values());
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblTelefon = new JLabel("Telefon");
	private JTextField txtTelefon = new JTextField(20);
	private JLabel lblKorisnickoIme= new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfSifra = new JPasswordField(20);
	private JLabel lblSluzba = new JLabel("Sluzba");
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JComboBox<Sluzba> cbSluzba = new JComboBox<Sluzba>(enumeracija.Sluzba.values());
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	private DomZdravlja domZdravlja;
	private MedicinskaSestra sestra;
	private MedicinskaSestra izmenaSestre;
	
	public medSestraForma(DomZdravlja domZdravlja, MedicinskaSestra sestra) {
		this.domZdravlja=domZdravlja;
		this.sestra=sestra;
		this.izmenaSestre=sestra;
		String korisnickoIme = sestra == null ? "Dodavanje nove medicinske sestre" :
			"Izmena podataka o medicinskoj sestri: " + sestra.getKorisnickoIme();
		setTitle(korisnickoIme);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		if(sestra != null) { popuniPolja(); }
		initListeners();
		pack(); 
	}
	private void initGUI() {
	MigLayout mig = new MigLayout("wrap 2");
	setLayout(mig);

	add(lblIme);					
	add(txtIme);
	add(lblPrezime);				
	add(txtPrezime);
	add(lblJmbg);					
	add(txtJmbg);
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
	add(lblPlata);					
	add(txtPlata);
	add(lblSluzba);					
	add(cbSluzba);
	add(new JLabel());		
	add(btnOk, "split 2");
	add(btnCancel);	
}
	private void popuniPolja() {
		txtIme.setText(sestra.getIme());
		txtPrezime.setText(sestra.getPrezime());
		txtJmbg.setText(sestra.getJmbg());
		cbPol.setSelectedItem(this.sestra.getPol());
		txtAdresa.setText(sestra.getAdresa());
		txtTelefon.setText(sestra.getBrojTelefona());
		txtKorisnickoIme.setText(sestra.getKorisnickoIme());
		pfSifra.setText(sestra.getLozinka());
		txtPlata.setText(String.valueOf(sestra.getPlata()));
		cbSluzba.setSelectedItem(this.sestra.getSluzba());

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
					String sifra = new String(pfSifra.getPassword()).trim();
					Sluzba sluzba = (Sluzba) cbSluzba.getSelectedItem();
					double plata = Double.parseDouble(txtPlata.getText().trim());
					if(sestra == null) {
						MedicinskaSestra sestra = new MedicinskaSestra(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, sifra, plata, sluzba);
						domZdravlja.getMedicinskesestre().add(sestra);
					
						}else {
						sestra.setIme(ime);
						sestra.setPrezime(prezime);
						sestra.setJmbg(jmbg);
						sestra.setPol(pol);
						sestra.setAdresa(adresa);
						sestra.setBrojTelefona(brojTelefona);
						sestra.setKorisnickoIme(korisnickoIme);
						sestra.setLozinka(sifra);
						sestra.setSluzba(sluzba);
						sestra.setPlata(plata);
						
						
					}
				    String  fajlSestre = "medicinskesestre.txt";
					domZdravlja.snimiMedsestre(fajlSestre);
					medSestraForma.this.dispose();
					medSestraForma.this.setVisible(false);
				}
			}
		});}
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

}



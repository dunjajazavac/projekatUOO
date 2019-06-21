package guiZaIzmenuIDodavanje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import domZdravlja.DomZdravlja;
import enumeracija.Status;
import korisnik.Korisnik;
import korisnik.Lekar;
import korisnik.Pacijenti;
import net.miginfocom.swing.MigLayout;
import pregledi.Pregledi;

public class PregledPacijent extends JFrame {
	private JLabel lblId = new JLabel("ID");
	private JTextField txtID = new JTextField(20);
	private JLabel lblPacijent = new JLabel("Pacijent");
	private JComboBox<String> cbPacijent = new JComboBox<String>();
	private JLabel lblLekar = new JLabel("Lekar");
	private JComboBox<String> cbLekar = new JComboBox<String>();
	private JLabel lblDatum = new JLabel("Termin");
	private JTextField txtDatum=new JTextField(20);
	private JLabel lblSoba = new JLabel("Soba");
	private JTextField txtSoba = new JTextField(20);
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	private JLabel lblStatus = new JLabel("Status");
	private JComboBox<Status> cbStatus = new JComboBox<Status>(Status.values());
	private JLabel lblCena=new JLabel("Cena");
	private JTextField txtCena=new JTextField(20);
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("CANCEL");
	private Pregledi pregled;
	private DomZdravlja domZdravlja;
	private Korisnik korisnik;
	
	public PregledPacijent(DomZdravlja domZdravlja, Pregledi pregled, Korisnik korisnik) {
		this.domZdravlja=domZdravlja;
		this.pregled=pregled;
		this.korisnik=korisnik;
		if(this.pregled == null) {
			setTitle("Dodavanje novog pregleda");
		}else {
			setTitle("Izmena pregleda: " + this.pregled.getId());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initListeners();
		setResizable(false);
		pack();
	}
	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2");
		setLayout(mig);
		
		if(this.pregled != null) {
			popuniPolja();
		}
		cbPacijent.addItem(korisnik.getKorisnickoIme());
		for(Lekar lekar:this.domZdravlja.getLekari()) {
			cbLekar.addItem(lekar.getKorisnickoIme());
		}
		
		add(lblId);
		add(txtID);
		add(lblPacijent);
		add(cbPacijent);
		add(lblLekar);
		add(cbLekar);
		add(lblDatum);
		add(txtDatum);
		add(lblSoba);
		add(txtSoba);
		add(lblOpis);
		add(txtOpis);
		add(lblStatus);
		add(cbStatus);
		add(lblCena);
		add(txtCena);
		add(new JLabel());
		add(btnOK , "split 2");
		add(btnCancel);
	}
	private void popuniPolja() {
		txtID.setText(this.pregled.getId());
		txtID.setEnabled(false);
		cbPacijent.setSelectedItem(this.korisnik.getKorisnickoIme());
		cbPacijent.setEnabled(false);
		cbLekar.setSelectedItem(this.pregled.getDoktor());
		cbLekar.setEnabled(false);
		txtDatum.setText(this.pregled.getDatum());
		txtDatum.setEnabled(false);
		txtSoba.setText(this.pregled.getSoba());
		txtSoba.setEnabled(false);
		txtOpis.setText(this.pregled.getOpis());
		cbStatus.setSelectedItem(this.pregled.getStatus());
		cbStatus.setEnabled(false);
		txtCena.setText(String.valueOf(this.pregled.getCena()));
		txtCena.setEnabled(false);
	}
	private void initListeners() {
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija() == true) {
					String id = txtID.getText().trim();
					//String pacijentKorIme = cbPacijent.getSelectedItem().toString();
					Pacijenti pacijent = domZdravlja.nadjiPacijenta(korisnik.getKorisnickoIme());
					String lekarKorIme = cbLekar.getSelectedItem().toString();
					Lekar lekar = domZdravlja.nadjiLekara(lekarKorIme);
					String datum=txtDatum.getText().trim();
					String soba = txtSoba.getText().trim();
					String opis = txtOpis.getText().trim();
					Status status = (Status) cbStatus.getSelectedItem();
					double cena = 0;
					if(pregled == null) {
					Pregledi pregled = new Pregledi(id, pacijent, lekar, datum, soba, opis, status,cena);
					domZdravlja.getPregled().add(pregled);
					}else {
						pregled.setId(id);
						pregled.setPacijent(pacijent);
						pregled.setDoktor(lekar);
						pregled.setDatum(datum);
						pregled.setSoba(soba);
						pregled.setOpis(opis);
						pregled.setStatus(status);
						pregled.setCena(cena);
					}
					domZdravlja.snimiPreglede("pregledi.txt");
					PregledPacijent.this.dispose();
					PregledPacijent.this.setVisible(false);
				}
			}
		});
	}
	public boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popunite sledece greske u unosu:\n";
		
		if(txtSoba.getText().trim().equals("")) {
			poruka += "- Unesite sobu";
			ok = false;
		}
		if(txtOpis.getText().trim().equals("")) {
			poruka += "- Unesite opis";
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}
	


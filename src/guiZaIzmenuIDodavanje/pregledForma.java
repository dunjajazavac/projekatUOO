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
import gui.Main;
import gui.lekarProzor;
import gui.pacijentiProzor;
import korisnik.Lekar;
import korisnik.MedicinskaSestra;
import korisnik.Pacijenti;
import net.miginfocom.swing.MigLayout;
import pregledi.Pregledi;

public class pregledForma extends JFrame {
	private JLabel lblID= new JLabel("ID");
	private JTextField txtID = new JTextField(20);
	private JLabel lblPacijent = new JLabel("Pacijent");
	private JComboBox<String> cbPacijent = new JComboBox<String>();
	private JLabel lblLekar = new JLabel("Lekar");
	private JComboBox<String> cbLekar = new JComboBox<String>();
	private JLabel lblDatum = new JLabel("Datum");
	private JTextField txtDatum = new JTextField(20);
	private JLabel lblSoba = new JLabel("Broj sobe");
	private JTextField txtSoba= new JTextField(20);
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(20);
	private JLabel lblStatus = new JLabel("Status");
	private JComboBox<Status> cbStatus = new JComboBox<Status>(Status.values());
	private JLabel lblCena=new JLabel("Cena");
	private JTextField txtCena=new JTextField(20);
	private Pacijenti pacijent;
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("CANCEL");
	private DomZdravlja dom;
	private Pregledi pregled;
	private pacijentiProzor prozorP;
	private lekarProzor prozorL;
	private Main prozorS;
	private MedicinskaSestra sestra;
	private Lekar lekar;
	
	public pregledForma(DomZdravlja dom, Pregledi pregled) {
		this.dom=dom;
		this.pregled=pregled;
		String pregled1 = pregled == null ? "Dodavanje novog pregleda" :
			"Izmena podataka o pregledu: " + this.pregled.getId();
		setTitle(pregled1);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		if(pregled != null) { popuniPolja(); }
		initListeners();
		pack(); 
	}
private void initGUI() {
		
		for (Pacijenti pacijent : this.dom.getPacijent()) {
			cbPacijent.addItem(pacijent.getKorisnickoIme());
		}
		for (Lekar lekar : this.dom.getLekari()) {
			cbLekar.addItem(lekar.getKorisnickoIme());
		}

		MigLayout mig = new MigLayout("wrap 2");
		setLayout(mig);
				
		add(lblID);				
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
		add(btnOk, "split 2"); 
		add(btnCancel);	
	
		
	}
private void popuniPolja() {
	txtID.setText(this.pregled.getId());
	txtDatum.setText(this.pregled.getDatum());
	txtSoba.setText(String.valueOf(this.pregled.getSoba()));
	txtOpis.setText(this.pregled.getOpis());
	cbStatus.setSelectedItem(this.pregled.getStatus());
	txtCena.setText(String.valueOf(this.pregled.getCena()));
	cbPacijent.setSelectedItem(this.pregled.getPacijent());
	cbLekar.setSelectedItem(this.pregled.getDoktor());
	
	
	
}
private void initListeners() {		
	btnOk.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(validacija() == true) {
			String id=txtID.getText().trim();
			String pacijentKorisnicko=cbPacijent.getSelectedItem().toString();
			Pacijenti pacijent=dom.nadjiPacijenta(pacijentKorisnicko);
			String lekarKorisnicko=cbLekar.getSelectedItem().toString();
			Lekar lekari=dom.nadjiLekara(lekarKorisnicko);
			String datum=txtDatum.getText().trim();
			String soba=txtSoba.getText().trim();
			String opis=txtOpis.getText().trim();
			Status status=(Status) cbStatus.getSelectedItem();
			double cena;
			if (pacijent.getIdKnjizica().getKategorija().equals(pacijent.getIdKnjizica().getKategorija().PRVA)){
				 cena = 300.0;
					}
			else if(pacijent.getIdKnjizica().getKategorija().equals(pacijent.getIdKnjizica().getKategorija().DRUGA)) {
				 cena = 50.0;
			}
			else{cena = 0.0;}
			if(pregled == null) {
				Pregledi pregled = new Pregledi(id,pacijent, lekari, datum,soba,opis,status,cena );
				dom.getPregled().add(pregled);
			}else {
				pregled.setId(id);
				pregled.setPacijent(pacijent);
				pregled.setDoktor(lekari);
				pregled.setDatum(datum);
				pregled.setSoba(soba);
				pregled.setOpis(opis);
				pregled.setCena(cena);
			}
			String fajlPregleda = "pregledi.txt";
			dom.snimiPreglede(fajlPregleda);
			pregledForma.this.dispose();
			pregledForma.this.setVisible(false);
		}
	}
});
}
private boolean validacija() {
	boolean ok = true;
	String message = "Molimo popravite sledece greske u unosu:\n";
	
	if(txtID.getText().trim().equals("")) {
		message += "- Morate uneti id pregleda\n";
		ok = false;
	}

	if(txtDatum.getText().trim().equals("")) {
		message += "- Morate uneti datum pregleda\n";
		ok = false;
		}
	if(ok == false) {
		JOptionPane.showMessageDialog(null, message, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
	}
	return ok;

}
}

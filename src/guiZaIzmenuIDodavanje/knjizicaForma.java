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
import enumeracija.Kategorija;
import net.miginfocom.swing.MigLayout;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;


public class knjizicaForma extends JFrame {

	private JLabel lblId = new JLabel("ID");
	private JTextField txtId = new JTextField(20);
	private JLabel lblDatum = new JLabel("Datum");
	private JTextField txtDatum = new JTextField(20);
	private JLabel lblKategorija = new JLabel("Kategorija");
	private JComboBox<Kategorija> cbKategorija = new JComboBox<Kategorija>(enumeracija.Kategorija.values());
	private JButton btnOk = new JButton("OK");
	private JButton btnOtkazi = new JButton("Otkazi");
	private DomZdravlja domZdravlja;
	private ZdravstvenaKnjizica knjizica;
	
	public knjizicaForma(DomZdravlja domZdravlja, ZdravstvenaKnjizica knjizica) {
		this.domZdravlja=domZdravlja;
		this.knjizica=knjizica;
		String nova = knjizica == null ? "Dodavanje nove knjizice" :
			"Izmena podataka o knjizici: " + knjizica.getBroj();
		setTitle(nova);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		if(knjizica != null) { popuniPolja(); }
		initListeners();
		pack(); 
		
	}
	private void initGUI() {
		MigLayout mig = new MigLayout("wrap 2");
		setLayout(mig);
		add(lblId);				
		add(txtId);
		add(lblDatum);			
		add(txtDatum);
		add(lblKategorija);				
		add(cbKategorija);
		add(new JLabel());		
		add(btnOk, "split 2"); 
		add(btnOtkazi);	
	}
	private void popuniPolja() {
		txtId.setText(knjizica.getBroj());
		txtDatum.setText(knjizica.getDatum());
	}
	private void initListeners() {		
		btnOk.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(validacija() == true) {
				String id = txtId.getText().trim();
				String datum = txtDatum.getText().trim();
				Kategorija kategorija = (Kategorija) cbKategorija.getSelectedItem();
				if(knjizica == null) {
					ZdravstvenaKnjizica knjizica = new ZdravstvenaKnjizica(id, datum, kategorija);
					domZdravlja.getKnjizica().add(knjizica);
				
					}else {
					knjizica.setBroj(id);
					knjizica.setDatum(datum);
					knjizica.setKategorija(kategorija);
					
				}
			    String  KNJIZICA_FAJL = "zdknjizica.txt";
				domZdravlja.snimiZdknjzicu(KNJIZICA_FAJL);
				knjizicaForma.this.dispose();
				knjizicaForma.this.setVisible(false);
			}
		}
	});}
	private boolean validacija() {
		boolean ok = true;
		String message = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtId.getText().trim().equals("")) {
			message += "- Morate uneti id\n";
			ok = false;
		}
		if(txtDatum.getText().trim().equals("")) {
			message += "- Morate uneti datum isteka\n";
			ok = false;
		}
		if(ok == false) {
		JOptionPane.showMessageDialog(null, message, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
	}
	return ok;
	}
}

	


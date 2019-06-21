package guiProzorZaPrikaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import domZdravlja.DomZdravlja;
import korisnik.Korisnik;
import pregledi.Pregledi;

public class pregledizaLekara extends JFrame {
	private JTable tabela;
	private DomZdravlja domZdravlja;
	private Korisnik korisnik;
	ArrayList<Pregledi> p = new ArrayList<Pregledi>();
	
	public pregledizaLekara(DomZdravlja domZdravlja, Korisnik korisnik) {
		this.domZdravlja = domZdravlja;
		this.korisnik = korisnik;
		setTitle("Pregledi");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
	}
	private void initGUI() {
		for(Pregledi pr:domZdravlja.getPregled()) {
			if(pr.getDoktor().getKorisnickoIme().equalsIgnoreCase(korisnik.getKorisnickoIme())) {
				p.add(pr);
			}
		}
			
		String[] zaglavlje = new String[] {
				"Id", "Pacijent", "Lekar", "Datum", "Soba", "Opis", "Status","Cena"};
		
		Object[][] sadrzaj = new Object[this.p.size()][zaglavlje.length];
		for(int i=0; i<this.p.size(); i++) {
Pregledi pregled = this.p.get(i);
			
			sadrzaj[i][0] = pregled.getId();
			sadrzaj[i][1] = pregled.getPacijent().getKorisnickoIme();
			sadrzaj[i][2] = pregled.getDoktor().getKorisnickoIme();
			sadrzaj[i][3] = pregled.getDatum();
			sadrzaj[i][4] = pregled.getSoba();
			sadrzaj[i][5] = pregled.getOpis();
			sadrzaj[i][6] = pregled.getStatus();
			sadrzaj[i][7]=pregled.getCena();
			DefaultTableModel model = new DefaultTableModel(sadrzaj, zaglavlje);
			tabela = new JTable(model);
			tabela = new JTable(model);
			tabela.setRowSelectionAllowed(true);
			tabela.setColumnSelectionAllowed(false);
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tabela.setDefaultEditor(Object.class, null);
			
			JScrollPane scroll = new JScrollPane(tabela);
			add(scroll, BorderLayout.CENTER);
		}
		}
			

}

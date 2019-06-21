package guiProzorZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import domZdravlja.DomZdravlja;
import enumeracija.Status;
import guiZaIzmenuIDodavanje.PregledPacijent;
import korisnik.Korisnik;
import pregledi.Pregledi;

public class PregledizaPacijenta extends JFrame {
	private JToolBar toolbar = new JToolBar();
	private ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
	private JButton btnAdd = new JButton(addIcon);
	private ImageIcon refreshIcon = new ImageIcon("Osvezi");
	private JButton btnRefresh = new JButton(refreshIcon);
	private ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
	private JButton btnEdit = new JButton(editIcon);
	private JTable tabela;
	private DomZdravlja domZdravlja;
	public Korisnik korisnik;
	private Pregledi pregled;
	ArrayList<Pregledi> p= new ArrayList<Pregledi>();
	
	public PregledizaPacijenta(DomZdravlja domZdravlja, Korisnik korisnik) {
		this.domZdravlja=domZdravlja;
		this.korisnik=korisnik;
		setTitle("Pregledi");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initListeners();
	}
	private void initGUI() {
		toolbar.add(btnAdd);
		toolbar.add(btnEdit);
		toolbar.add(btnRefresh);
		add(toolbar, BorderLayout.NORTH);
		
		for(Pregledi pregled1:domZdravlja.getPregled()) {
			if(pregled1.getPacijent().getKorisnickoIme().equalsIgnoreCase(korisnik.getKorisnickoIme())) {
				
				p.add(pregled1);
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
			}
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
	private void initListeners() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PregledPacijent pp = new PregledPacijent(domZdravlja, pregled, korisnik);
				pp.setVisible(true);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = tabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					DefaultTableModel model = (DefaultTableModel)tabela.getModel();
					String id = model.getValueAt(red, 0).toString();
					Pregledi pregled = domZdravlja.nadjiPreglede(id);
					if(pregled.getStatus() != Status.ZAKAZAN) {
						PregledPacijent pp = new PregledPacijent(domZdravlja, pregled, korisnik);
						pp.setVisible(true);
					}else if(pregled == null) {
						JOptionPane.showMessageDialog(null, "Nije moguce pronaci pregled", "Greska", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Pregled je vec potvrdjen", "Greska", JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PregledizaPacijenta.this.dispose();
				PregledizaPacijenta pp = new PregledizaPacijenta(domZdravlja, korisnik);
				pp.setVisible(true);
				
			}
		});
	}
}

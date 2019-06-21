package guiProzorZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import guiZaIzmenuIDodavanje.pacijentiForma;
import korisnik.Pacijenti;

public class pacijentiPrikaz extends JFrame {
	private ImageIcon addIcon = 
			new ImageIcon(getClass().getResource("/slike/add.gif"));
	private JButton btnAdd = new JButton(addIcon);
	private ImageIcon editIcon = 
			new ImageIcon(getClass().getResource("/slike/edit.gif"));
	private JButton btnEdit = new JButton(editIcon);
	private ImageIcon removeIcon = 
			new ImageIcon(getClass().getResource("/slike/remove.gif"));
	private JButton btnRemove = new JButton(removeIcon);
	private JToolBar toolbar = new JToolBar();
	private JTable tabela;
	private DomZdravlja domZdravlja;
	
	public pacijentiPrikaz(DomZdravlja domZdravlja) {
		this.domZdravlja=domZdravlja;
		setTitle("Pacijenti");
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initListeners();
	}
	private void initGUI() {
	toolbar.add(btnAdd);
	toolbar.add(btnEdit);
	toolbar.add(btnRemove);
	add(toolbar, BorderLayout.NORTH);
	String[] zaglavlje = new String[] {
		"Ime", "Prezime", "Jmbg", "Pol", "Adresa", "Telefon",
		"Korisnicko ime", "Lozinka","Izabrani lekar", "Id knjizice"};
	Object[][] sadrzaj = 
			new Object[domZdravlja.getPacijent().size()][zaglavlje.length];
	for(int i=0; i<domZdravlja.getPacijent().size(); i++) {
		Pacijenti pacijent = domZdravlja.getPacijent().get(i);
		sadrzaj[i][0] = pacijent.getIme();
		sadrzaj[i][1] = pacijent.getPrezime();
		sadrzaj[i][2] = pacijent.getJmbg();
		sadrzaj[i][3] = pacijent.getPol();
		sadrzaj[i][4] = pacijent.getAdresa();
		sadrzaj[i][5] = pacijent.getBrojTelefona();
		sadrzaj[i][6] = pacijent.getKorisnickoIme();
		sadrzaj[i][7] = pacijent.getLozinka();
		sadrzaj[i][8] = pacijent.getJmbgLekara().getKorisnickoIme();
		sadrzaj[i][9] = pacijent.getIdKnjizica().getBroj();
	}
	DefaultTableModel model = new DefaultTableModel(sadrzaj, zaglavlje);
	tabela = new JTable(model);
	tabela.setRowSelectionAllowed(true);
	tabela.setColumnSelectionAllowed(false);
	tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	tabela.setDefaultEditor(Object.class, null);
	JScrollPane scrollPane = new JScrollPane(tabela);
	add(scrollPane, BorderLayout.CENTER);
	}
	private void initListeners() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pacijentiForma p= 
						new pacijentiForma(domZdravlja, null);
				p.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int red = tabela.getSelectedRow();
				if(red == -1){
					JOptionPane.showMessageDialog(null, "Morate odbrati red u tabeli", "Greska",
							JOptionPane.WARNING_MESSAGE);
				}else{
					DefaultTableModel model=(DefaultTableModel)tabela.getModel();
					String korisnickoIme = tabela.getValueAt(red, 6).toString();
					Pacijenti pacijent = domZdravlja.nadjiPacijenta(korisnickoIme);
					if(pacijent != null){
						pacijentiForma pf = new pacijentiForma(domZdravlja, pacijent);
						pf.setVisible(true);
					}
				}
				
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int red = tabela.getSelectedRow();
				if(red == -1){
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				}else{
					String korisnickoIme = tabela.getValueAt(red, 6).toString();
					Pacijenti pacijent = domZdravlja.nadjiPacijenta(korisnickoIme);
					if(pacijent != null){
						domZdravlja.obrisiPacijenta(pacijent);
						DefaultTableModel model = (DefaultTableModel) tabela.getModel();
						model.removeRow(red);
						domZdravlja.snimiPacijente("pacijenti.txt");
					}
				}
				
			}
		});
	}

}



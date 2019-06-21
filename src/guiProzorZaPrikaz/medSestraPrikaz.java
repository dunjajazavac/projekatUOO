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
import guiZaIzmenuIDodavanje.medSestraForma;
import korisnik.MedicinskaSestra;

public class medSestraPrikaz extends JFrame {
	private ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
	private JButton btnAdd = new JButton(addIcon);
	private ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
	private JButton btnEdit = new JButton(editIcon);
	private ImageIcon removeIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
	private JButton btnRemove = new JButton(removeIcon);
	private JToolBar toolbar = new JToolBar();
	private JTable tabela;
	private DomZdravlja domZdravlja;
	
	public medSestraPrikaz(DomZdravlja domZdravlja) {
		this.domZdravlja=domZdravlja;
		setTitle("Medicinske sestre");
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
			"Korisnicko ime", "Lozinka","Plata", "Sluzba"
			};
		Object[][] sadrzaj = 
				new Object[domZdravlja.getMedicinskesestre().size()][zaglavlje.length];
		for(int i=0; i<domZdravlja.getMedicinskesestre().size(); i++) {
			MedicinskaSestra sestra = domZdravlja.getMedicinskesestre().get(i);
			sadrzaj[i][0] = sestra.getIme();
			sadrzaj[i][1] = sestra.getPrezime();
			sadrzaj[i][2] = sestra.getJmbg();
			sadrzaj[i][3] = sestra.getPol();
			sadrzaj[i][4] = sestra.getBrojTelefona();
			sadrzaj[i][5] = sestra.getAdresa();
			sadrzaj[i][6] = sestra.getKorisnickoIme();
			sadrzaj[i][7] = sestra.getLozinka();
			sadrzaj[i][8] = sestra.getSluzba();
			sadrzaj[i][9] = sestra.getPlata();
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
				medSestraForma f = 
						new medSestraForma(domZdravlja, null);
				f.setVisible(true);
				
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
					String korisnickoIme = tabela.getValueAt(red, 6).toString();
					MedicinskaSestra sestra = domZdravlja.nadjiMedsestre(korisnickoIme);
					if(sestra != null){
						medSestraForma f = new medSestraForma(domZdravlja, sestra);
						f.setVisible(true);
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
					String sestra1 = tabela.getValueAt(red, 6).toString();
					MedicinskaSestra sestra = domZdravlja.nadjiMedsestre(sestra1);
					if(sestra != null){
						domZdravlja.obrisiMedSestre(sestra);
						DefaultTableModel model = (DefaultTableModel) tabela.getModel();
						model.removeRow(red);
						domZdravlja.snimiMedsestre("medicinskesestre.txt");

					}
				}
			}
		});
	}
}

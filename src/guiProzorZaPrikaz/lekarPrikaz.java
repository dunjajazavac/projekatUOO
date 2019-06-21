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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import domZdravlja.DomZdravlja;
import guiZaIzmenuIDodavanje.LekariForma;
import guiZaIzmenuIDodavanje.medSestraForma;
import korisnik.Lekar;
import korisnik.MedicinskaSestra;

public class lekarPrikaz extends JFrame {
	private ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
	private JButton btnAdd = new JButton(addIcon);
	private ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
	private JButton btnEdit = new JButton(editIcon);
	private ImageIcon removeIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
	private JButton btnRemove = new JButton(removeIcon);
	private JToolBar toolbar = new JToolBar();
	private JTable tabela;
	private DomZdravlja domZdravlja;
	
	public lekarPrikaz(DomZdravlja domZdravlja) {
		this.domZdravlja=domZdravlja;
		setTitle("Lekari");
		setSize(800,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGui();
		initListeners();
	}
	private void initGui() {
		toolbar.add(btnAdd);
		toolbar.add(btnEdit);
		toolbar.add(btnRemove);
		add(toolbar, BorderLayout.NORTH);
		String[] zaglavlje=new String[] {
				"Ime","Prezime","JMBG","Pol","Adresa","Broj telefona","Korisnicko ime","Lozinka","Sluzba","Specijalizacija","Plata"};
			Object[][] sadrzaj= new Object[domZdravlja.getLekari().size()][zaglavlje.length];
			for(int i=0;i<domZdravlja.getLekari().size();i++) {
				Lekar lekar=domZdravlja.getLekari().get(i);
				sadrzaj[i][0]=lekar.getIme();
				sadrzaj[i][1]=lekar.getPrezime();
				sadrzaj[i][2]=lekar.getJmbg();
				sadrzaj[i][3]=lekar.getPol();
				sadrzaj[i][4]=lekar.getAdresa();
				sadrzaj[i][5]=lekar.getBrojTelefona();
				sadrzaj[i][6]=lekar.getKorisnickoIme();
				sadrzaj[i][7]=lekar.getLozinka();
				sadrzaj[i][8]=lekar.getSluzba();
				sadrzaj[i][9]=lekar.getSpecijalizacija();
				sadrzaj[i][10]=lekar.getPlata();
				
				
				
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
			public void actionPerformed(ActionEvent arg0) {
				LekariForma forma=new LekariForma(domZdravlja, null);
				forma.setVisible(true);
				
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red=tabela.getSelectedRow();
				if(red == -1){
					JOptionPane.showMessageDialog(null, "Morate odbrati red u tabeli", "Greska",
							JOptionPane.WARNING_MESSAGE);
				}else{
					String korisnickoIme = tabela.getValueAt(red, 6).toString();
					Lekar doktor = domZdravlja.nadjiLekara(korisnickoIme);
					if(doktor != null){
						LekariForma f = new LekariForma(domZdravlja, doktor);
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
					String l= tabela.getValueAt(red, 6).toString();
					Lekar lekar1 = domZdravlja.nadjiLekara(l);
					if(lekar1 != null){
						domZdravlja.obrisiLekara(lekar1);
						DefaultTableModel model = (DefaultTableModel) tabela.getModel();
						model.removeRow(red);
						domZdravlja.snimiLekare("lekari.txt");

					}
				}
			}
		});
	}

		
		
	}

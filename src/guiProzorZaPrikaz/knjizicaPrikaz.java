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
import guiZaIzmenuIDodavanje.knjizicaForma;
import zdravstvenaKnjizica.ZdravstvenaKnjizica;

public class knjizicaPrikaz extends JFrame {
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
	
	 public knjizicaPrikaz (DomZdravlja domZdravlja) {
		this.domZdravlja = domZdravlja;
		setTitle("Zdravstvene knjizice");
		setSize(500, 300);
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
			"ID", "Datum", "Kategorija"};
		Object[][] sadrzaj = 
				new Object[domZdravlja.getKnjizica().size()][zaglavlje.length];
		for(int i=0; i<domZdravlja.getKnjizica().size(); i++) {
		 ZdravstvenaKnjizica knjizica = domZdravlja.getKnjizica().get(i);
			sadrzaj[i][0] = knjizica.getBroj();
			sadrzaj[i][1] = knjizica.getDatum();
			sadrzaj[i][2] = knjizica.getKategorija();
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
			 knjizicaForma k= new knjizicaForma(domZdravlja,null);
				k.setVisible(true);
				
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
					String id = tabela.getValueAt(red, 0).toString();
					ZdravstvenaKnjizica knjizica = domZdravlja.nadjZdravstvenaKnjizica(id);
					if(knjizica != null){
						knjizicaForma k = new knjizicaForma(domZdravlja,knjizica);
						k.setVisible(true);
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
					String idKnjizice = tabela.getValueAt(red, 0).toString();
					ZdravstvenaKnjizica knjizica = domZdravlja.nadjZdravstvenaKnjizica(idKnjizice);
					if(knjizica != null){
						domZdravlja.obrisiZdknjizicu(knjizica);
						DefaultTableModel model = (DefaultTableModel) tabela.getModel();
						model.removeRow(red);
						domZdravlja.snimiZdknjzicu("zdknjizica.txt");
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
					String idKnjizice = tabela.getValueAt(red, 0).toString();
				    ZdravstvenaKnjizica knjizica = domZdravlja.nadjZdravstvenaKnjizica(idKnjizice);
					if(knjizica != null){
						domZdravlja.obrisiZdknjizicu(knjizica);
						DefaultTableModel model = (DefaultTableModel) tabela.getModel();
						model.removeRow(red);
						domZdravlja.snimiZdknjzicu("zdknjizica.txt");
					}
				}
				
			}
		});
	}
	

	
	}

	

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import domZdravlja.DomZdravlja;
import guiProzorZaPrikaz.pacijentiPrikaz;
import guiProzorZaPrikaz.preglediPrikaz;
import korisnik.Lekar;

public class lekarProzor extends JFrame {
	private JMenuBar glavniMeni=new JMenuBar();
	private JMenu lekarMeni=new JMenu("Meni");
	private JMenuItem preglediItem=new JMenuItem("Pregledi lekara");
	private JMenuItem pacijentiItem=new JMenuItem("Pacijenti lekara");
	private DomZdravlja dom;
	private Lekar prijavljen;
	
	public lekarProzor(DomZdravlja dom,Lekar prijavljen) {
		this.dom=dom;
		this.prijavljen=prijavljen;
		setTitle("Dom Zdravlja: ");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initListeners();
	}
	private void initGUI() {
		setJMenuBar(glavniMeni);
		glavniMeni.add(lekarMeni);
		lekarMeni.add(preglediItem);
		lekarMeni.add(pacijentiItem);
	}
	private void initListeners() {
		pacijentiItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		preglediItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				preglediPrikaz p=new preglediPrikaz(dom);
				p.setVisible(true);
			}
		});
		pacijentiItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pacijentiPrikaz prikaz=new pacijentiPrikaz(dom);
				prikaz.setVisible(true);
				
			}
		});
	}
	
	

}

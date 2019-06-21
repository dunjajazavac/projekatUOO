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
import guiProzorZaPrikaz.pregledizaLekara;
import korisnik.Lekar;

public class lekarProzor extends JFrame {
	private JMenuBar glavniMeni=new JMenuBar();
	private JMenuItem preglediItem=new JMenuItem("Pregledi lekara");
	private JMenuItem pacijentiItem=new JMenuItem("Pacijenti lekara");
	private JMenu knjiziceMenu=new JMenu("Knjizice");
	private JMenuItem lekariItem=new JMenuItem("Lekari");
	private JMenuItem sestreItem=new JMenuItem("Medicinske Sestre");
	private JMenu preglediMeni=new JMenu("Pregledi");
	private JMenuItem knjiziceItem=new JMenuItem("Knjizice");
	private JMenu korisniciMenu=new JMenu("Korisnici");
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
		this.korisniciMenu.add(lekariItem);
		this.korisniciMenu.add(pacijentiItem);
		this.korisniciMenu.add(sestreItem);
		this.preglediMeni.add(preglediItem);
		this.knjiziceMenu.add(knjiziceItem);
		this.glavniMeni.add(korisniciMenu);
		this.glavniMeni.add(preglediMeni);
		this.glavniMeni.add(knjiziceMenu);
	}
	private void initListeners() {
	preglediItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pregledizaLekara p = new pregledizaLekara(dom, prijavljen);
				p.setVisible(true);
				
			}
		});
		korisniciMenu.setEnabled(false);
		knjiziceMenu.setEnabled(false);
		
	}
}

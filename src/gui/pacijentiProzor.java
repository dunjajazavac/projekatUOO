package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import domZdravlja.DomZdravlja;
import guiProzorZaPrikaz.PregledizaPacijenta;
import guiProzorZaPrikaz.preglediPrikaz;
import korisnik.Pacijenti;

public class pacijentiProzor extends JFrame {
	private JMenuBar glavniMeni;
	private JMenu korisniciMenu;
	private JMenuItem lekariItem;
	private JMenuItem pacijentiItem;
	private JMenuItem medicinskeSestreItem;
	private JMenu preglediMenu;
	private JMenuItem preglediItem;
	private JMenu knjiziceMenu;
	private JMenuItem knjiziceItem;
	private DomZdravlja dom;
	private Pacijenti prijavljen;
	
	
	public pacijentiProzor(DomZdravlja dom,Pacijenti prijavljen) {
		this.dom=dom;
		this.prijavljen=prijavljen;
		setTitle("Dom Zdravlja");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGui();
		initListeners();
		
		
	}
	private void initGui() {
		this.glavniMeni = new JMenuBar();
		this.korisniciMenu = new JMenu("Korisnici");
		this.lekariItem = new JMenuItem("Lekari");
		this.pacijentiItem = new JMenuItem("Pacijenti");
		this.medicinskeSestreItem = new JMenuItem("Medicinske sestre");
		this.preglediMenu = new JMenu("Pregledi");
		this.preglediItem = new JMenuItem("Pregledi");
		this.knjiziceMenu = new JMenu("Knjizice");
		this.knjiziceItem = new JMenuItem("Knjizice");
		
		this.korisniciMenu.add(lekariItem);
		this.korisniciMenu.add(pacijentiItem);
		this.korisniciMenu.add(medicinskeSestreItem);
		
		this.preglediMenu.add(preglediItem);
		
		this.knjiziceMenu.add(knjiziceItem);
		
		this.glavniMeni.add(korisniciMenu);
		this.glavniMeni.add(preglediMenu);
		this.glavniMeni.add(knjiziceMenu);
		
		setJMenuBar(this.glavniMeni);
		setJMenuBar(glavniMeni);
	}
	private void initListeners() {
     preglediItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				preglediItem.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						PregledizaPacijenta pp = new PregledizaPacijenta(dom, prijavljen);
						pp.setVisible(true);
						
					}
				});
				korisniciMenu.setEnabled(false);
				knjiziceMenu.setEnabled(false);
}
     });
	}
}
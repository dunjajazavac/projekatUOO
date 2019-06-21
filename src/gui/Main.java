package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import domZdravlja.DomZdravlja;
import guiProzorZaPrikaz.knjizicaPrikaz;
import guiProzorZaPrikaz.lekarPrikaz;
import guiProzorZaPrikaz.medSestraPrikaz;
import guiProzorZaPrikaz.pacijentiPrikaz;
import guiProzorZaPrikaz.preglediPrikaz;
import korisnik.MedicinskaSestra;

public class Main extends JFrame {
	private JMenuBar glavniMeni=new JMenuBar();
	private JMenu korisnikMeni=new JMenu("Korisnici");
	private JMenuItem lekarItem=new JMenuItem("Lekari");
	private JMenuItem medicinskasestraItem=new JMenuItem("Medicinske sestre");
	private JMenuItem pacijentItem=new JMenuItem("Pacijenti");
	private JMenuItem pregledItem=new JMenuItem("Pregledi");
	private JMenuItem knjizicaItem=new JMenuItem("Zdravstvena knjizica");
	
	private DomZdravlja domZdravlja;
	private MedicinskaSestra prijavljeniKorisnik;
	
	public Main(DomZdravlja domZdravlja, MedicinskaSestra prijavljeniKorisnik) {
		this.domZdravlja = domZdravlja;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Dom zdravlja:" + prijavljeniKorisnik.getKorisnickoIme());
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initListeners();
	}
	private void initGUI() {
		setJMenuBar(glavniMeni);
		
		glavniMeni.add(korisnikMeni);
		korisnikMeni.add(pacijentItem);
		korisnikMeni.add(lekarItem);
		korisnikMeni.add(medicinskasestraItem);
		korisnikMeni.add(knjizicaItem);
		korisnikMeni.add(pregledItem);

		}
	
	private void initListeners() {
		lekarItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lekarPrikaz lp=new lekarPrikaz(domZdravlja);
				lp.setVisible(true);
				
			}
		});
		pregledItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				preglediPrikaz pp=new preglediPrikaz(domZdravlja);
				pp.setVisible(true);
				
			}
		});
		knjizicaItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				knjizicaPrikaz p=new knjizicaPrikaz(domZdravlja);
				p.setVisible(true);
				
			}
		});
		pacijentItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pacijentiPrikaz pp=new pacijentiPrikaz(domZdravlja);
				pp.setVisible(true);
				
			}
		});
		medicinskasestraItem.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				medSestraPrikaz pp=new medSestraPrikaz(domZdravlja);
				pp.setVisible(true);
				
			}
		});
	}
	
	
	
	
}



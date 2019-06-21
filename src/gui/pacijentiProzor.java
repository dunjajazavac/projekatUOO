package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import domZdravlja.DomZdravlja;
import guiProzorZaPrikaz.preglediPrikaz;
import korisnik.Pacijenti;

public class pacijentiProzor extends JFrame {
	private JMenuBar glavniMeni=new JMenuBar();
	private JMenu pacijentMeni=new JMenu("Pacijenti");
	private JMenuItem preglediItem=new JMenuItem("Pregled za izabranog pacijenta");
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
		setJMenuBar(glavniMeni);
		glavniMeni.add(pacijentMeni);
		pacijentMeni.add(preglediItem);
	}
	private void initListeners() {
		preglediItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				preglediPrikaz prikaz=new preglediPrikaz(dom);
				prikaz.setVisible(true);
				
			}
		});
	}

}

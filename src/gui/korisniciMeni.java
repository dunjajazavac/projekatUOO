package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import domZdravlja.DomZdravlja;
import korisnik.Lekar;
import korisnik.MedicinskaSestra;
import korisnik.Pacijenti;
import net.miginfocom.swing.MigLayout;

public class korisniciMeni extends JFrame {
	private JLabel lblPoruka=new JLabel("Dobrodosli.Izaberite jednu od ponudjenih opcija.");
	private JButton btnLekar=new JButton("Lekar");
	private JButton btnSestra=new JButton("Medicinska sestra");
	private JButton btnPacijent=new JButton("Pacijent");
	private JButton btnCancel=new JButton("Cancel");
	private Lekar lekar;
	private MedicinskaSestra sestra;
	private Pacijenti pacijent;
	private DomZdravlja dom;
	
	public korisniciMeni(DomZdravlja dom) {
		this.dom=dom;
		setTitle("Prijava");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		initGui();
		initListeners();
		pack();
		
	}
	private void initGui() {
		MigLayout layout=new MigLayout("wrap 2");
		setLayout(layout);
		add(lblPoruka);
		add(btnLekar,"split 3");
		add(btnSestra);
		add(btnPacijent);
	}
	private void initListeners() {
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				korisniciMeni.this.dispose();
				korisniciMeni.this.setVisible(false);
				
				
			}
		});
		btnPacijent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pacijentiProzor prozor=new pacijentiProzor(dom, pacijent);
					prozor.setVisible(true);
					korisniciMeni.this.dispose();
					korisniciMeni.this.setVisible(false);
				
				
				
			}
		});
		btnLekar.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lekarProzor lp=new lekarProzor(dom, lekar);
					lp.setVisible(true);
					korisniciMeni.this.dispose();
					korisniciMeni.this.setVisible(false);
				
				
			}
		});
		
		btnSestra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main mejn=new Main(dom, sestra);
				mejn.setVisible(true);
				korisniciMeni.this.dispose();
				korisniciMeni.this.setVisible(false);
				
			}
		});
		
		
		
	}

}

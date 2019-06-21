package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domZdravlja.DomZdravlja;
import korisnik.Lekar;
import korisnik.MedicinskaSestra;
import korisnik.Pacijenti;
import main.Main;
import net.miginfocom.swing.MigLayout;

public class Login extends JFrame {
	private JLabel lblPoruka;
	private JLabel lblKorisnickoIme;
	private JTextField txtKorisnickoIme;
	private JLabel lblSifra;
	private JPasswordField pfSifra;
	private JLabel lblPrazno=new JLabel();
	private JButton btnCancel;
	private JButton btnLekar;
	private JButton btnSestra;
	private JButton btnPacijent;
	
	private DomZdravlja domZdravlja;
	
	
	public Login(DomZdravlja domZdravlja) {
		this.domZdravlja=domZdravlja;
		setTitle("Login");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		initGui();
		initActions();
		pack();
		
	}
	private void initGui() {
		MigLayout l=new MigLayout("wrap 2", "[][]", "[]20[][]20[]");
		setLayout(l);
		this.lblPoruka=new JLabel("Dobrodosli u informacioni sistem Doma Zdravlja. Molimo da se ulogujete.");
		this.lblKorisnickoIme=new JLabel("Korisnicko ime: ");
		this.txtKorisnickoIme=new JTextField(20);
		this.lblSifra=new JLabel("Sifra: ");
		this.pfSifra=new JPasswordField(20);
		this.btnCancel=new JButton("Cancel");
		this.btnLekar=new JButton("Lekar");
		this.btnSestra=new JButton("Medicinska sestra");
		this.btnPacijent=new JButton("Pacijent");
		
		add(lblPoruka, "span 2");
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblSifra);
		add(pfSifra);
		add(btnLekar,"split 4");
		add(btnSestra);
		add(btnPacijent);
		add(lblPrazno);
		add(btnCancel);
				
		
	}
	private void initActions() {
		btnSestra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme=txtKorisnickoIme.getText().trim();
				String sifra = new String(pfSifra.getPassword()).trim();
				if(korisnickoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.");
				}else {
					MedicinskaSestra sestra=domZdravlja.login(korisnickoIme, sifra);
					if(sestra!=null) {
						Login.this.setVisible(false);
						Login.this.dispose();
						gui.Main g=new gui.Main(domZdravlja,sestra);
						g.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Pogrešni login podaci.");
					}
				}
				
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.this.setVisible(false);
				Login.this.dispose();
			}
				

		});
		btnLekar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String korime=txtKorisnickoIme.getText().trim();
				String sifra=new String(pfSifra.getPassword()).trim();
				Lekar lekar=domZdravlja.loginLekara(korime, sifra);
				if(lekar==null) {
					JOptionPane.showMessageDialog(null,"Neispravni login podaci","Prijava",JOptionPane.WARNING_MESSAGE);
					
				}else {
					lekarProzor pp=new lekarProzor(domZdravlja, lekar);
					pp.setVisible(true);
				}
				
				
			}
		});
		btnPacijent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String user=txtKorisnickoIme.getText().trim();
				String sifra=new String(pfSifra.getPassword()).trim();
				Pacijenti pacijent=domZdravlja.loginPacijent(user, sifra);
				if(pacijent==null) {
					JOptionPane.showMessageDialog(null,"Neispravni login podaci","Prijava",JOptionPane.WARNING_MESSAGE);
					
				}else {
					pacijentiProzor pp=new pacijentiProzor(domZdravlja, pacijent);
					pp.setVisible(true);
					Login.this.dispose();
					Login.this.setVisible(false);
				}
				
			}
		});
		
	}
}


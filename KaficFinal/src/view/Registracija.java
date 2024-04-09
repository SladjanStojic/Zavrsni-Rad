package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;
import Registracija.IProxyR;
import Registracija.ProxyReg;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Registracija extends JFrame {

	private JPanel contentPane;
	private JTextField tfIme;
	private JTextField tfPrezime;
	private JTextField tfUserName;
	private JPasswordField passF1;
	private JPasswordField passF2;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	
	public Registracija() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setBounds(25, 14, 46, 14);
		contentPane.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(25, 43, 46, 14);
		contentPane.add(lblPrezime);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setBounds(24, 79, 97, 14);
		contentPane.add(lblUserName);
		
		JLabel lblLozinka = new JLabel("lozinka");
		lblLozinka.setBounds(25, 135, 46, 14);
		contentPane.add(lblLozinka);
		
		JLabel lblPonovljenaLozinka = new JLabel("Ponovljena lozinka");
		lblPonovljenaLozinka.setBounds(25, 191, 113, 14);
		contentPane.add(lblPonovljenaLozinka);
		
		tfIme = new JTextField();
		tfIme.setBounds(148, 11, 143, 20);
		contentPane.add(tfIme);
		tfIme.setColumns(10);
		
		tfPrezime = new JTextField();
		tfPrezime.setColumns(10);
		tfPrezime.setBounds(148, 40, 143, 20);
		contentPane.add(tfPrezime);
		
		tfUserName = new JTextField();
		tfUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				provjeriDuzinuUserName();
			}
		});
		tfUserName.setColumns(10);
		tfUserName.setBounds(148, 76, 143, 20);
		contentPane.add(tfUserName);
		
		passF1 = new JPasswordField();
		passF1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				provjeriDuzinuLozinke();
			}
		});
		passF1.setBounds(148, 132, 143, 20);
		contentPane.add(passF1);
		
		passF2 = new JPasswordField();
		passF2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				daLiSeSifrePoklapaju();
			}
		});
		passF2.setBounds(148, 188, 143, 20);
		contentPane.add(passF2);
		
		JButton btnRegistruj = new JButton("Registruj me");
		btnRegistruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrujMe();
				setVisible(false);
			}
		});
		btnRegistruj.setBounds(155, 246, 120, 23);
		contentPane.add(btnRegistruj);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(148, 107, 265, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(148, 163, 265, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(148, 219, 265, 14);
		contentPane.add(lblNewLabel_2);
	}


	protected void daLiSeSifrePoklapaju() {
	    // TODO Auto-generated method stub
	    String pass1 = new String(passF1.getPassword());
	    String pass2 = new String(passF2.getPassword());
	    
	    if(!pass1.equals(pass2)) {
	        lblNewLabel_2.setText("Sifre se ne poklapaju");
	    } else {
	        lblNewLabel_2.setText("Sifre se poklapaju");
	    }
	}



	protected void provjeriDuzinuLozinke() {
		// TODO Auto-generated method stub
		int preostaloKaraktera= 5 - passF1.getPassword().length;
		String poruka= preostaloKaraktera > 0 ? "Vasa lozinka mora da sadrzi jos " + preostaloKaraktera + "karakter(a)." : "";
		lblNewLabel_1.setText(poruka);
		
	}


	protected void provjeriDuzinuUserName() {
		// TODO Auto-generated method stub
		int preostaloKaraktera=4 - tfUserName.getText().length();
		String poruka=preostaloKaraktera>0 ? "Korisnièko ime mora sadržati još " + preostaloKaraktera + " karakter(a)." : "";
		lblNewLabel.setText(poruka);
	}


	protected void registrujMe() {
		// TODO Auto-generated method stub
		if(tfUserName.getText().length()>4 &&passF1.getPassword().length >= 5 && Arrays.equals(passF1.getPassword(), passF2.getPassword())) {
		    User u=new User();
		    u.setIme(tfIme.getText());
		    u.setPrezime(tfPrezime.getText());
		    u.setUserName(tfUserName.getText());
		    u.setPass(String.valueOf(passF1.getPassword()));
		    
		    IProxyR reg= new ProxyReg();
		    reg.registruj(u);
		    JOptionPane.showMessageDialog(null, "Uspesno ste se registrovali");
		    dispose();
		} else {
			JOptionPane.showConfirmDialog(null, "Paswordi se ne poklapaju ili su kraci od 5");
		}
			
		}
	}


package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ObjasnjenjeBaza extends JFrame {

	private JPanel contentPane;

	
	public ObjasnjenjeBaza() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 992, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ObjasnjenjeBaza.class.getResource("/slike/ModelovanjeBaze.PNG")));
		lblNewLabel_1.setBounds(20, 154, 946, 532);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText("<html>Bazu sam modelovao sa 9 tabela. Unutar baze imam dvije agregacija. Prva mi sluzi da spajam korisnike sa rolama, <br>\r\n"
				+ "kako bi u odnosu na neku rolu imale razlicite funkcionalnosti. Prilikom dodavanja novog zaposlenog imamo mogucnost odabira 4 role <br>\r\n"
				+ "a prilikom registracije automatski se dodjeljuju role admin i konobar.Druga agregacija racun_stavke je povezana sa tabelom <br>\r\n"
				+ "racun i sa tabelom artikal,kako bi mogli da pratimo koje su stavke sve na racunu. U tabeli racun stavke imam kolone trenutna <br>\r\n"
				+ "cena i trenutni pdv kako bi se moglo u bazi pratiti istorija cijena odredjenih artikala. <br>\r\n"
				+ "Takodje baza je hostovana na web serveru<html>");
		lblNewLabel.setBounds(10, 11, 946, 179);
		contentPane.add(lblNewLabel);
	}
}

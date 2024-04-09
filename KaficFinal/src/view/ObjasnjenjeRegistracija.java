package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ObjasnjenjeRegistracija extends JFrame {

	private JPanel contentPane;


	public ObjasnjenjeRegistracija() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblObjasnjenje = new JLabel("New label");
		lblObjasnjenje.setVerticalAlignment(SwingConstants.TOP);
		lblObjasnjenje.setHorizontalAlignment(SwingConstants.LEFT);
		lblObjasnjenje.setText("<html>Registracija: Na Formi za logovanje nalazi se dugme za registraciju koje kada kliknemo otvara nam se registracijona forma koja je implementirana preko Proxy patterna.<br>Nakon toga se ostvaruje konekcija sa bazom koja kriptuje pasword (BCrypt) i unosi novog usera u bazu a nakon toga mu dodjeljuje rolu admin(U svrhe testiranja svih funkcionalnosti). Korisnik moze imati vise razlicitih ROLA i u odnosu na rolu dostupni su mu odredjeni delovi programa.</html>");
		
		lblObjasnjenje.setBounds(27, 11, 590, 93);
		contentPane.add(lblObjasnjenje);
		
		
		JLabel lblSlika1 = new JLabel("New label");
		lblSlika1.setIcon(new ImageIcon(ObjasnjenjeRegistracija.class.getResource("/slike/RegistracijaKod.PNG")));
		lblSlika1.setBounds(10, 166, 607, 308);
		contentPane.add(lblSlika1);
		
		JLabel lblSlika1_1 = new JLabel("New label");
		lblSlika1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlika1_1.setIcon(new ImageIcon(ObjasnjenjeRegistracija.class.getResource("/slike/BCrypt.PNG")));
		lblSlika1_1.setBounds(10, 97, 607, 66);
		contentPane.add(lblSlika1_1);

	}
}

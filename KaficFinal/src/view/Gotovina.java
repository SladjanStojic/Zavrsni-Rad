package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Kontroler.Kontroler;
import Kontroler.KontrolerRacun;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;

public class Gotovina extends JFrame {

	private JPanel contentPane;
	private JTextField tfNovac;
	private double ukupno;
	JLabel lblUkupno;
	JLabel lblKusur;
	JLabel lblIznosKusura;
	private double iznos;
	private double kusur;
	private int id_racuna;
	private int id_usera;
	DefaultTableModel dtm2=new DefaultTableModel();
	

	public Gotovina(int id, int id_racuna, DefaultTableModel dtm2) {
		this.id_racuna=id_racuna;
		this.id_usera=id;
		this.dtm2=dtm2;
		System.out.println(id_racuna);
		ukupno=Kontroler.getInstanca().vratiUkupanIznosSaRacuna(id_racuna);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGotovina = new JLabel("Gotovina");
		lblGotovina.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGotovina.setHorizontalAlignment(SwingConstants.CENTER);
		lblGotovina.setBounds(141, 23, 93, 14);
		contentPane.add(lblGotovina);
		
		JLabel lblIznos = new JLabel("Za naplatu");
		lblIznos.setBounds(105, 73, 68, 14);
		contentPane.add(lblIznos);
		
		lblUkupno = new JLabel("New label");
		lblUkupno.setBounds(183, 73, 68, 14);
		lblUkupno.setText(String.valueOf(ukupno));
		contentPane.add(lblUkupno);
		
		tfNovac = new JTextField();
		tfNovac.setBounds(183, 105, 86, 20);
		contentPane.add(tfNovac);
		tfNovac.setColumns(10);
		
		JLabel lblNovac = new JLabel("Unesi novac");
		lblNovac.setBounds(105, 108, 68, 14);
		contentPane.add(lblNovac);
		
		JButton btnNaplati = new JButton("Naplati");
		btnNaplati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izracunajKusur();
				Kontroler.getInstanca().updateRacun2(id_racuna);
				lblIznosKusura.setText(String.valueOf(kusur));
				JOptionPane.showMessageDialog(null, "Uspesno ste izvrsili placanje");
				KontrolerRacun.getInstanca().stampajRacun(id, id_racuna, dtm2);
			}
		});
		btnNaplati.setBounds(161, 157, 89, 23);
		contentPane.add(btnNaplati);
		
		lblKusur = new JLabel("KUSUR");
		lblKusur.setBounds(148, 209, 46, 14);
		lblKusur.setText("Kusur");
		contentPane.add(lblKusur);
		
		lblIznosKusura = new JLabel("New label");
		lblIznosKusura.setBounds(223, 209, 46, 14);
		
		contentPane.add(lblIznosKusura);
		//kreirajRacunUDatoteku(id_racuna);
		
	}
	protected void izracunajKusur() {
		// TODO Auto-generated method stub
		String tekst=tfNovac.getText();
		iznos=Double.parseDouble(tekst);
		kusur=iznos-ukupno;
		System.out.println(kusur);
	}
	
}

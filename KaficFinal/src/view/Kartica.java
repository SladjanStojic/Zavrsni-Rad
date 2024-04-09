package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Kontroler.Kontroler;
import Kontroler.KontrolerRacun;
import StrategyPattern.KarticnoPlacanje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;

public class Kartica extends JFrame {

	

	private JPanel contentPane;
	private JTextField textFieldNosioc;
	private JTextField tfBrojKartice;
	private JTextField tfDatumIsteka;
	private JTextField tfCCV;
	private double ukupno;
	private int id_racuna;
	private JToggleButton tglbtn;
	JLabel lblUkupno;
	private DefaultTableModel dtm2 =new DefaultTableModel();
	private int id_usera;
	



	
	public Kartica(int id, int id_racuna, DefaultTableModel dtm2) {
		this.id_racuna=id_racuna;
		this.id_usera=id;
		this.dtm2=dtm2;
		System.out.println("Kartica ID RACUNA" + id_racuna);
		System.out.println("KARTICA ID RACUNA " + id);
		ukupno=Kontroler.getInstanca().vratiUkupanIznosSaRacuna(id_racuna);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKartica = new JLabel("Kartica");
		lblKartica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKartica.setHorizontalAlignment(SwingConstants.CENTER);
		lblKartica.setBounds(147, 24, 107, 14);
		contentPane.add(lblKartica);
		
		
		
		JButton btnNaplati = new JButton("Naplati");
		btnNaplati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     	String broj = tfBrojKartice.getText();
	                String imeNosioca = textFieldNosioc.getText();
	                String datumIsteka = tfDatumIsteka.getText();
	                String ccv = tfCCV.getText();
	                
	                
	                KarticnoPlacanje karticnoPlacanje= new KarticnoPlacanje(broj, imeNosioca, datumIsteka, ccv);
	                karticnoPlacanje.plati(ukupno);
	                
	                tfBrojKartice.setText("");
	                textFieldNosioc.setText("");
	                tfDatumIsteka.setText("");
	                tfCCV.setText("");
	                
	                JOptionPane.showMessageDialog(null, "Uspe�no ste platili karticom!");
	                lblUkupno.setText("0.0");
	                Kontroler.getInstanca().updateRacun(id_racuna);
	                KontrolerRacun.getInstanca().stampajRacun(id, id_racuna, dtm2);
	               
			}
		});
		btnNaplati.setBounds(165, 210, 89, 23);
		contentPane.add(btnNaplati);
		
		textFieldNosioc = new JTextField();
		textFieldNosioc.setBounds(157, 53, 86, 20);
		contentPane.add(textFieldNosioc);
		textFieldNosioc.setColumns(10);
		
		tfBrojKartice = new JTextField();
		tfBrojKartice.setColumns(10);
		tfBrojKartice.setBounds(157, 89, 86, 20);
		contentPane.add(tfBrojKartice);
		
		tfDatumIsteka = new JTextField();
		tfDatumIsteka.setColumns(10);
		tfDatumIsteka.setBounds(157, 120, 86, 20);
		contentPane.add(tfDatumIsteka);
		
		tfCCV = new JTextField();
		tfCCV.setColumns(10);
		tfCCV.setBounds(157, 156, 86, 20);
		contentPane.add(tfCCV);
		
		JLabel lblNosioc = new JLabel("Ime nosioca");
		lblNosioc.setBounds(71, 56, 76, 14);
		contentPane.add(lblNosioc);
		
		JLabel lblDatum = new JLabel("Datum Isteka");
		lblDatum.setBounds(71, 123, 76, 14);
		contentPane.add(lblDatum);
		
		JLabel lblBrojKartice = new JLabel("Broj Kartice");
		lblBrojKartice.setBounds(71, 92, 76, 14);
		contentPane.add(lblBrojKartice);
		
		JLabel lblCcv = new JLabel("CCV");
		lblCcv.setBounds(71, 159, 76, 14);
		contentPane.add(lblCcv);
		
		lblUkupno = new JLabel();
		lblUkupno.setHorizontalAlignment(SwingConstants.CENTER);
		lblUkupno.setText(String.valueOf(ukupno));
		lblUkupno.setBounds(147, 187, 107, 14);
		contentPane.add(lblUkupno);
	}


	}



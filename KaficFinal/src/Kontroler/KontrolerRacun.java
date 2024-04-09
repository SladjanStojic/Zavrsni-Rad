package Kontroler;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KontrolerRacun {
	
private static KontrolerRacun instanca;
private static String nazivFoldera="c:\\racuni";	
	private KontrolerRacun() {
		
	}
	public static KontrolerRacun getInstanca() {
		if(instanca==null) {
			instanca= new KontrolerRacun();
			
			File folder=new File(nazivFoldera);
			
			if(!folder.exists()) {
				folder.mkdir();
			}
		}
		return instanca;
	}
	public void stampajRacun(int id, int id_racuna, DefaultTableModel model) {
		
		 String imeDatoteke = nazivFoldera + File.separator + id_racuna + "_racun.txt"; 
	        double ukupanRacun = 0.0;
	        Timestamp vremeNaplate = Kontroler.getInstanca().vratiVremeNaplate(id_racuna);
	        String ime = Kontroler.getInstanca().vratiImeUsera(id);
	        String prezime = Kontroler.getInstanca().vratiPrezimeUsera(id);

	        try (PrintWriter pw = new PrintWriter(imeDatoteke)) {
	            pw.println("VREME\t" + vremeNaplate);
	            pw.println("KONOBAR\t" + ime + "\t" + prezime);
	            pw.println("RB\tNAZIV\tKOLICINA\tCENA\tPDV\tUKUPNO");
	            pw.println("---------------------------------------");

	            for (int i = 0; i < model.getRowCount(); i++) {
	                int redniB = Integer.parseInt(model.getValueAt(i, 0).toString());
	                String naziv = model.getValueAt(i, 1).toString();
	                int kolicina = Integer.parseInt(model.getValueAt(i, 2).toString());
	                double cena = Double.parseDouble(model.getValueAt(i, 3).toString());
	                double pdv = Double.parseDouble(model.getValueAt(i, 4).toString());
	                double ukupno = Double.parseDouble(model.getValueAt(i, 5).toString());

	                ukupanRacun += ukupno;
	                pw.println(redniB + "\t" + naziv + "\t" + kolicina + "\t" + cena + "\t" + pdv + "\t" + ukupno);
	            }
	            pw.println("---------------------------------------");
	            pw.println("\t\t\t\t\tUKUPNO: " + ukupanRacun);
	            JOptionPane.showMessageDialog(null, "Raèun je generiran i spremljen u datoteku: " + imeDatoteke);
	            System.out.println("Raèun je generiran i spremljen u datoteku: " + imeDatoteke);
	        } catch (Exception e) {
	            System.err.println("Došlo je do greške prilikom pisanja u datoteku: " + e.getMessage());
	        }
	    }

	}


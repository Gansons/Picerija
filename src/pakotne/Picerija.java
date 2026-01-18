package pakotne;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

//Izveides metodse
public class Picerija {

		public static int jautajums(String teksts) {
		    return JOptionPane.showConfirmDialog(null, teksts, "Izvēle", JOptionPane.YES_NO_CANCEL_OPTION);
		}
	
	
		static String virknesParbaude(String zinojums, String nokl) {
	        String ievade;
	        do {
	            ievade = JOptionPane.showInputDialog(null, zinojums, nokl);
	            if (ievade == null)
	                return null;
	            ievade = ievade.trim();
	        } while (!Pattern.matches("^[\\p{L} ]+$", ievade));
	        return ievade;
	    }
	
	public static String telParbaude(String zinojums, String noklusejums) {
	    String ievade;

	    while (true) {
	        ievade = (String) JOptionPane.showInputDialog(
	                null, zinojums, "Datu ievade",
	                JOptionPane.INFORMATION_MESSAGE, null, null, noklusejums);

	        if (ievade == null)
	            return null;

	        // pārbauda vai ievadītais nr ir derīgs
	        if (ievade.matches("\\+371\\d{8}")) {
	            return ievade;
	        } else {
	            JOptionPane.showMessageDialog(
	                    null,
	                    "Ievadi pareizu numuru -> +371XXXXXXXX",
	                    "kļūda",
	                    JOptionPane.WARNING_MESSAGE
	            );
	        }
	    }
	}

	public static Double skaitlaParbaude(String zinojums, double min, double max, String noklusejums) {
		String ievade;
		Double skaitlis;
		while(true) {
			ievade = (String)JOptionPane.showInputDialog(null, zinojums, 
					"Datu ievade", JOptionPane.INFORMATION_MESSAGE, null, null, noklusejums); 
			if(ievade == null)
				return -1.0;
			try {
				skaitlis = Double.parseDouble(ievade);
				if(skaitlis < min || skaitlis > max) {
					JOptionPane.showMessageDialog(null, 
					"Norādīts nederīgs skaitlis", "Nekorekti dati",
					JOptionPane.WARNING_MESSAGE);
					continue;
				}
				
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
					"Netika ievadīts pareizs skaitlis", "Nekorekti dati",
					JOptionPane.WARNING_MESSAGE);
			}
		}
}
	
    static void pasutijums(String izmers, String Gala, String merce,
                             String adresse, String telefonaNR,
                             String 
                             Vards, int siers, int lidznemt, boolean piegade, String topingi, String dzeriens, String uzkoda) {

        double cena = aprekinatCenu(izmers, Gala, merce, topingi, siers, lidznemt, piegade, dzeriens, uzkoda);

        String zinjojums =
                "Picas pasūtījums\n" +
                "=========================\n" +
                "Klients: " + Vards + "\n" +
                "Telefons: " + telefonaNR + "\n" +
                "Adrese: " + adresse + "\n\n" +
                "------\n"+
                "Pica: \n" +
                "Izmērs: " + izmers + "\n" +
                "Gaļa: " + Gala + "\n" +
                "Mērce: " + merce + "\n" +
                "Topingi: "+ topingi + "\n" +
                "Siers: " + (siers == 0 ? "Jā" : "Nē") + "\n" +
                "Uzkodas/dzērieni:\n"+
                "Dzēriens: "+ dzeriens + "\n" +
                "Uzkodas: "+ uzkoda + "\n" +
                "------\n"+
                "Līdzņemšana: " + (lidznemt == 0? "Jā" : "Nē") + "\n" +
                "Piegāde: " + (piegade ? "Jā" : "Nē") + "\n\n" +
                "Cena: " + cena + " EUR\n" +
                "=========================\n" +
                "Paldies par pasūtījumu!";

        JOptionPane.showMessageDialog(null, zinjojums);
    }

    static double aprekinatCenu(String izmers, String Gala, String merce, String topingi,
                                int siers, int lidznemt, boolean piegade, String dzeriens , String uzkoda) {
    	if (izmers == null) izmers = "";
    	if (Gala == null) Gala = "";
    	if (merce == null) merce = "";
    	if (topingi == null) topingi = "Bez topingiem";
    	if (dzeriens == null) dzeriens = "Bez dzeramā";
    	if (uzkoda == null) uzkoda = "Bez uzkodas";

        double cena = 5.0;

        switch (izmers.toUpperCase()) {
	        case "L (24\")": cena += 6; break;
	        case "M (18\")": cena += 4; break;
	        case "S (15\")": cena += 2; break;

        }

        if (!Gala.equalsIgnoreCase("Bez gaļas")) cena += 1.5;
        if (!merce.equalsIgnoreCase("Bez mērces")) cena += 0.5;
        if(!topingi.contains("Bez topingiem")) cena += 1.0;
        if(!dzeriens.contains("Bez dzeramā")) cena += 1.5;
        if(!uzkoda.contains("Bez uzkodas")) cena += 3.0;
        if (siers == 0) cena += 1.0;
        if (piegade) cena += 2.0;

        return cena;
    }
    
    public static void showProgressTimer(int seconds,  Runnable izcepts) {
        JFrame frame = new JFrame("Pica gatavojas");
        frame.setSize(300, 120);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JProgressBar bar = new JProgressBar(0, seconds);
        bar.setValue(seconds);
        bar.setStringPainted(true);

        frame.setLayout(new java.awt.BorderLayout());
        //frame.add(label, java.awt.BorderLayout.NORTH);
        frame.add(bar, java.awt.BorderLayout.CENTER);
        
        frame.setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            int timeLeft = seconds;

            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                bar.setValue(timeLeft);
                bar.setString("Atlikušais laiks: " + timeLeft + " s");
      

                if (timeLeft <= 0) {
                    ((Timer)e.getSource()).stop();
                    frame.dispose();
                    izcepts.run();
                    
                }
            }
        });

        timer.start();
    }

}
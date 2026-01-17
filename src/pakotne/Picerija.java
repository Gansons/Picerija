package pakotne;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Picerija {

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
                             Vards, String nosaukums, boolean siers, boolean lidznemt, boolean piegade, String topingi, String dzeriens, String uzkoda) {

        double cena = aprekinatCenu(izmers, Gala, merce, topingi, lidznemt, piegade, siers, dzeriens, uzkoda);

        String zinjojums =
                "Picas pasūtījums\n" +
                "=========================\n" +
                "Klients: " + Vards + "\n" +
                "Telefons: " + telefonaNR + "\n" +
                "Adrese: " + adresse + "\n\n" +
                "Pica: " + nosaukums + "\n" +
                "Izmērs: " + izmers + "\n" +
                "Gaļa: " + Gala + "\n" +
                "Mērce: " + merce + "\n" +
                "Topingi: "+ topingi + "\n" +
                "Siers: " + (siers ? "Jā" : "Nē") + "\n\n" +
                "Līdzņemšana: " + (lidznemt ? "Jā" : "Nē") + "\n" +
                "Piegāde: " + (piegade ? "Jā" : "Nē") + "\n\n" +
                "Cena: " + cena + " EUR\n" +
                "=========================\n" +
                "Paldies par pasūtījumu!";

        JOptionPane.showMessageDialog(null, zinjojums);
    }

    static double aprekinatCenu(String izmers, String Gala, String merce, String topingi,
                                boolean siers, boolean lidznemt, boolean piegade, String dzeriens , String uzkoda) {

        double cena = 5.0;

        switch (izmers.toUpperCase()) {
            case "L": cena += 4; break;
            case "M": cena += 2; break;
            case "S": cena += 0; break;
        }

        if (!Gala.equalsIgnoreCase("Bez gaļas")) cena += 1.5;
        if (!merce.equalsIgnoreCase("Bez mērces")) cena += 0.5;
        if(!topingi.contains("Bez topingiem")) cena += 1.0;
        if(!dzeriens.contains("Bez dzeramā")) cena += 1.5;
        if(!uzkoda.contains("Bez uzkodas")) cena += 3.0;
        if (siers) cena += 1.0;
        if (piegade) cena += 2.0;

        return cena;
    }
}
package pakotne;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Pica {
	
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

	public static void main(String[] args) {
		
		String izvele, Gala, merce, adresse, telefonaNR, Vards, nosaukums;
		double laiks, izmērs, cena;
		boolean siers, lidznemt, piegade;
		
		String[] darbibas = {"Veikt sūtījumu","Nolasīt picas atrabūtus", "Mainīt atrabūtus",
				"Cept picu ilgāk", "Nodotie pasūtījumi", "Aktīvie pasūtījumi", "Apturēt"};
		
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Darbības izvēle", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele == null)
				izvele = "Apturēt";
			
		
		switch(izvele) {
		
		case "Veikt sūtījumu":
			
			break;
		
		case "Nolasīt picas atrabūtus":
			
			break;
			
		case  "Mainīt atrabūtus":
			
			break;
			
		case "Cept picu ilgāk":
			
			break;
			
		case "Nodotie pasūtījumi":
			
			break;
			
		case "Aktīvie pasūtījumi":
			
			break;
		
		case "Apturēt":
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			break;
		
		
		
		}
		}while(!izvele.equals("Apturēt"));

	}

}

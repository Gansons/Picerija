package pakotne;

import javax.swing.JOptionPane;

public class Pica {
	
	

	public static void main(String[] args) {
		
		String izvele, Gala =  "", merce = "",adresse = "", telefonaNR = "", Vards = "", nosaukums = "", izmers = "", topingi ="", dzeriens = "", uzkoda = "";
		double laiks, cena;
		boolean siers, lidznemt, piegade ;
		Pica pizza = null;
		
		String[] darbibas = {"Veikt sūtījumu","Nolasīt picas atrabūtus", "Mainīt atrabūtus",
				"Cept picu ilgāk", "Nodotie pasūtījumi", "Aktīvie pasūtījumi", "Apturēt", "Atcelt pasūtījumu"};
		String[] izmeri =  {"L","M","S"};
    	String[] galas = {"Bez gaļas","Bekons","Vista", "Lielops","Krokodils","Zivs"};
    	String[] merces = {"Bez mērces","Kečups","Majonēze", "BBQ mērce","Ķiploku mērce"};
    	String[] citi = {"Bez topingiem","Šampinjoni","Baziliks","Ananāsi","Banāni"};
    	String[] dzerieni = {"Bez dzeramā","Kola","Sprite","Kvass"};
    	String[] uzkodas = {"Bez uzkodas","nageti","friškas","soyas nageti"};
    	
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Darbības izvēle", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele == null)
				izvele = "Apturēt";
			
		
		switch(izvele) {
		
		case "Veikt sūtījumu":
			//Picas info ===============================
		            izmers = (String) JOptionPane.showInputDialog(null, "Izvēlies picas izmēru", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, izmeri, izmeri[0]);
		            
		            merce = (String) JOptionPane.showInputDialog(null, "Izvēlies mērci", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);

		            Gala = (String) JOptionPane.showInputDialog(null, "Izvēlies gaļas veidu", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, galas, galas[0]);

		            siers = JOptionPane.showConfirmDialog(null, "Vai pievienot sieru?") == 0;
		            
		            topingi = (String) JOptionPane.showInputDialog(null, "Izvēlies papildus topingus", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, citi, citi[0]);
		            
		    //Papildus opcijas =====================
		            lidznemt = JOptionPane.showConfirmDialog(null, "Vai būs papildus uzkodas vai dzēriens?") == 0;
		            if (!lidznemt) {
			            
			            
			        } else {
			        	dzeriens = (String) JOptionPane.showInputDialog(null, "Izvēlies papildus dzeramo", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, dzerieni, dzerieni[0]);;
			            uzkoda = (String) JOptionPane.showInputDialog(null, "Izvēlies papildus uzkodu", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, uzkodas, uzkodas[0]);
			        }
		            
		    //Pasūtītāja info ==================================
		            Vards = Picerija.virknesParbaude("Ievadi savu vārdu", "Jānis");

		       lidznemt = JOptionPane.showConfirmDialog(null, "Vai pica būs līdzņemšanai?") == 0;

		       piegade = false;
		        if (!lidznemt) {
		            adresse = "Nav";
		            telefonaNR = "Nav";
		            
		        } else {
		            piegade = JOptionPane.showConfirmDialog(null, "Vai nepieciešama piegāde?") == 0;
		            
		            if(piegade == true)
		            adresse = JOptionPane.showInputDialog("Ievadi piegādes adressi","Bērzu gatve 4");
		            telefonaNR = Picerija.telParbaude("Ievadi savu telefona nr","+371");
		            
		        }
		        	

		        
		           // nosaukums = JOptionPane.showInputDialog("Ievadi picas nosaukumu:");

		       
		        Picerija.pasutijums(izmers, Gala, merce, adresse, telefonaNR, Vards, nosaukums, siers,  lidznemt, piegade, topingi, dzeriens, uzkoda);
			    break;
		
		case "Nolasīt picas atrabūtus":
			//if(()) {
				//Nolasa atrabūtus
			//}else	
				JOptionPane.showMessageDialog(null, "Pica nav izveidota", "Kļūda", JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case  "Mainīt atrabūtus":
			//metode, kas ļauj mainīt atrabūtus picai
			break;
			
		case "Cept picu ilgāk":
			//Metode kas cep picu ilgāk, ja laiks >= 20, tad pica apdeg
			break;
			
		case "Nodotie pasūtījumi":
			//Nolasa no faila nodotās picas
			break;
			
		case "Aktīvie pasūtījumi":
			//Norāda aktīvo pasūtījumu, kūri tiek veikti laika ietverā
			break;
			
		case "Atcelt pasūtījumu":
			//Atceļ pasūtījumu un visu picas informācīju
			break;
		
		case "Apturēt":
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			break;
		
		
		
		}
		}while(!izvele.equals("Apturēt"));

	}

}

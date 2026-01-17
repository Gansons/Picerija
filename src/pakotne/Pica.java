package pakotne;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Pica {
	
	

	private static boolean b;

	public static void main(String[] args) {
		
		String izvele, metodes, Gala =  "", merce = "",adresse = "", telefonaNR = "", Vards = "", nosaukums = "", izmers = "", topingi ="", dzeriens = "", uzkoda = "";
		double cena = 0.0;
		int laiks = 15;
		boolean siers = false, lidznemt = false, piegade = false ;
		Pica pizza = null;
		
		String[] darbibas = {"Veikt sūtījumu", "Izsaukt picas metodes", "Nodotie pasūtījumi", "Aktīvie pasūtījumi", "Apturēt"};
		
		String[] izvelne = {"Apēst","Cept ilgāk","Nolasīt picas atrabūtus" ,"Mainīt atrabūtus"};
		
		String[] izmeri =  {"L (24\")","M (18\")","S (15\")"};
    	String[] galas = {"Bez gaļas","Bekons","Vista", "Lielops","Krokodils","Zivs"};
    	String[] merces = {"Bez mērces","Kečups","Majonēze", "BBQ mērce","Ķiploku mērce"};
    	String[] citi = {"Bez topingiem","Šampinjoni","Baziliks","Ananāsi","Banāni"};
    	String[] dzerieni = {"Bez dzeramā","Kola","Sprite","Kvass"};
    	String[] uzkodas = {"Bez uzkodas","nageti","friškas","soyas nageti"};
    	ArrayList<pizza> PicaList = new ArrayList<>();
    	
    	
    	
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
			            dzeriens = "Bez dzeramā";
			            uzkoda = "Bez uzkodas";
			            
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
		            
		            if(piegade == true) {
		            adresse = JOptionPane.showInputDialog("Ievadi piegādes adressi","Bērzu gatve 4");
		            telefonaNR = Picerija.telParbaude("Ievadi savu telefona nr","+371");
		            }
		            
		        }
		        	

		        
		           // nosaukums = JOptionPane.showInputDialog("Ievadi picas nosaukumu:");
		        
		        if (uzkoda == null) uzkoda = "Bez uzkodas";
		        if (dzeriens == null) dzeriens = "Bez dzeramā";
		        if (topingi == null) topingi = "Bez topingiem";


		       
		        Picerija.pasutijums(izmers, Gala, merce, adresse, telefonaNR, Vards, siers,  lidznemt, piegade, topingi, dzeriens, uzkoda);
		        Picerija.showProgressTimer(laiks, () -> {
		        JOptionPane.showMessageDialog(null, "Tavs pasūtījums ir gatavs!");
		        });
		        b = PicaList.add(new pizza(((String) izmers), Gala, merce, adresse, telefonaNR, Vards, siers, lidznemt, piegade, topingi, dzeriens, uzkoda));
		        DarbsArFailu.saglabat(PicaList);
		        
			    break;
		
		
			
		case  "Mainīt atrabūtus":
			//metode, kas ļauj mainīt atrabūtus picai
			break;
			
		case "Izsaukt picas metodes":
			
				izvele = (String)JOptionPane.showInputDialog(null, "metodes izvēle", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, izvelne, izvelne[0]);
				
				if(izvele == null)
					izvele = "Apturēt";
			
			switch(izvele) {
			
			case "Nolasīt picas atrabūtus":
				if(!PicaList.isEmpty())
					JOptionPane.showMessageDialog(null, PicaList);
				else
					JOptionPane.showMessageDialog(null, "Pica nav izveidota", "Kļūda", JOptionPane.INFORMATION_MESSAGE);
				break;
			
			case "Apēst":
				
				if(!PicaList.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ņammm...Viss tika apēsts");
				PicaList.clear();
				}else
					JOptionPane.showMessageDialog(null, "Nav ko ēst, pasūti ēdienu vispirms!", "Kļūda", JOptionPane.ERROR_MESSAGE);
				break;
				
			case "Cept ilgāk":
				if(!PicaList.isEmpty()) {
					laiks+=10;
				Picerija.showProgressTimer(laiks, () -> {});
				if(laiks >= 45)
					JOptionPane.showMessageDialog(null, "Pica apdega!","Ak nē!", JOptionPane.WARNING_MESSAGE);
				}else
					JOptionPane.showMessageDialog(null, "Nav picas ko ilgāk cept!", "Kļūda", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			break;
			
		case "Nodotie pasūtījumi":
			DarbsArFailu.nolasit();
			break;
			
		case "Aktīvie pasūtījumi":			//Norāda aktīvo pasūtījumu, kūri tiek veikti laika ietverā
			break;
			
		
		case "Apturēt":
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			break;
		
		
		
		}
		}while(!izvele.equals("Apturēt"));

	}

}

package pakotne;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;


public class Pica {
	
	static String[] izmeri = {"L (24\")","M (18\")","S (15\")"};
	static String[] galas = {"Bez gaļas","Bekons","Vista", "Lielops","Krokodils","Zivs"};
	static String[] merces = {"Bez mērces","Kečups","Majonēze", "BBQ mērce","Ķiploku mērce"};
	static String[] citi = {"Bez topingiem","Šampinjoni","Baziliks","Ananāsi","Banāni"};
	static String[] dzerieni = {"Bez dzeramā","Kola","Sprite","Kvass"};
	static String[] uzkodas = {"Bez uzkodas","nageti","friškas","soyas nageti"};
	static ArrayList<pizza> PicaList = new ArrayList<>();
	
  		public static void pasutijums() {

  		    String izmers = (String) JOptionPane.showInputDialog(null, "Izvēlies picas izmēru", "Izvēle",
  		            JOptionPane.QUESTION_MESSAGE, null, izmeri, izmeri[0]);

  		    String merce = (String) JOptionPane.showInputDialog(null, "Izvēlies mērci", "Izvēle",
  		            JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);

  		    String Gala = (String) JOptionPane.showInputDialog(null, "Izvēlies gaļas veidu", "Izvēle",
  		            JOptionPane.QUESTION_MESSAGE, null, galas, galas[0]);

  		    boolean siers = JOptionPane.showConfirmDialog(null, "Vai pievienot sieru?") == 0;

  		    String topingi = (String) JOptionPane.showInputDialog(null, "Izvēlies papildus topingus", "Izvēle",
  		            JOptionPane.QUESTION_MESSAGE, null, citi, citi[0]);

  		    boolean lidznemt = JOptionPane.showConfirmDialog(null, "Vai būs papildus uzkodas vai dzēriens?") == 0;

  		    String dzeriens, uzkoda;

  		    if (!lidznemt) {
  		        dzeriens = "Bez dzeramā";
  		        uzkoda = "Bez uzkodas";
  		    } else {
  		        dzeriens = (String) JOptionPane.showInputDialog(null, "Izvēlies papildus dzeramo", "Izvēle",
  		                JOptionPane.QUESTION_MESSAGE, null, dzerieni, dzerieni[0]);

  		        uzkoda = (String) JOptionPane.showInputDialog(null, "Izvēlies papildus uzkodu", "Izvēle",
  		                JOptionPane.QUESTION_MESSAGE, null, uzkodas, uzkodas[0]);
  		    }

  		    String Vards = Picerija.virknesParbaude("Ievadi savu vārdu", "Jānis");

  		    boolean piegade = false;
  		    String adresse = "Nav";
  		    String telefonaNR = "Nav";

  		    boolean lidz = JOptionPane.showConfirmDialog(null, "Vai pica būs līdzņemšanai?") == 0;

  		    if (lidz) {
  		        piegade = JOptionPane.showConfirmDialog(null, "Vai nepieciešama piegāde?") == 0;

  		        if (piegade) {
  		            adresse = JOptionPane.showInputDialog("Ievadi piegādes adresi", "Bērzu gatve 4");
  		            telefonaNR = Picerija.telParbaude("Ievadi savu telefona nr", "+371");
  		        }
  		    }

  		    Picerija.pasutijums(izmers, Gala, merce, adresse, telefonaNR, Vards, siers,
  		            lidznemt, piegade, topingi, dzeriens, uzkoda);

  		    Picerija.showProgressTimer(15, () -> {
  		        JOptionPane.showMessageDialog(null, "Tavs pasūtījums ir gatavs!");
  		    });

  		    PicaList.add(new pizza(izmers, Gala, merce, adresse, telefonaNR, Vards,
  		            siers, lidznemt, piegade, topingi, dzeriens, uzkoda));

  		    DarbsArFailu.saglabat(PicaList);
  		}
	
	private static boolean b;

	public static void main(String[] args) {
		
		Picerija.loading.show();
		
		Picerija.sakumaEkrans();
		
		
		
		String[] darbibas = {"Veikt sūtījumu", "Izsaukt picas metodes", "Nodotie pasūtījumi", "Aktīvie pasūtījumi", "Apturēt"};

    	
		String izvele = "";
		int laiks = 15;
		String[] izvelne = {"Cept ilgāk","Nolasīt picas atrabūtus" ,"Mainīt atrabūtus"};

    	
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Darbības izvēle", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele == null)
				izvele = "Apturēt";
			
		
		switch(izvele) {
		
		case "Veikt sūtījumu":
			
			
		        
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
				
			case "Cept ilgāk":
				if(!PicaList.isEmpty()) {
					laiks+=10;
					Picerija.showProgressTimer(laiks, () -> {});
				if(laiks >= 45)
					JOptionPane.showMessageDialog(null, "Pica apdega!","Ak nē!", JOptionPane.WARNING_MESSAGE);
				}else
					JOptionPane.showMessageDialog(null, "Nav picas ko ilgāk cept!", "Kļūda", JOptionPane.ERROR_MESSAGE);
				break;
				
			case "Nodot pasūtījumu":
				PicaList.clear();
				JOptionPane.showMessageDialog(null, "Pica tika nodota!");
				break;
			}
			
			break;
			
		case "Nodotie pasūtījumi":
				
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

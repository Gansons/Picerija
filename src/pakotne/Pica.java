package pakotne;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Pica {
	
	static String[] izmeri = {"L (24\")","M (18\")","S (15\")"};
	static String[] galas = {"Bez gaļas","Bekons","Vista", "Lielops","Krokodils","Zivs"};
	static String[] merces = {"Bez mērces","Kečups","Majonēze", "BBQ mērce","Ķiploku mērce"};
	static String[] citi = {"Bez topingiem","Šampinjoni","Baziliks","Ananāsi","Banāni"};
	static String[] dzerieni = {"Bez dzeramā","Kola","Sprite","Kvass"};
	static String[] uzkodas = {"Bez uzkodas","nageti","friškas","soyas nageti"};
	static ArrayList<pizza> PicaList = new ArrayList<>();
	static String[] izvelne = {"Cept ilgāk","Nolasīt picas atrabūtus" ,"Mainīt atrabūtus"};
	
	
	
	public static void picaMetodes() {
		String izvele = (String)JOptionPane.showInputDialog(null, "metodes izvēle", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, izvelne, izvelne[0]);
		int laiks = 15;
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
			laiks =+ 10;
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
		
		
	}}	
  		public static void pasutijums() {
  			String izmers = null, merce = null, Gala = null, topingi = null, dzeriens = null, uzkoda = null, Vards = null, adresse = null, telefonaNR = null;
  			int siers = 0;
  			boolean piegade = false;
  			int lidznemt = 1;

  			int jaut = 1;
  			
  			while(jaut <= 8) {
  			switch(jaut) {
  			case 1:
		  		    izmers = (String) JOptionPane.showInputDialog(null, "Izvēlies picas izmēru", "Izvēle",
		  		    JOptionPane.QUESTION_MESSAGE, null, izmeri, izmeri[0]);
	  		    if(izmers == null) return;
	  		  jaut++;
  		    break;
  		    
  			case 2:
	  		    merce = (String) JOptionPane.showInputDialog(null, "Izvēlies mērci", "Izvēle",
	  		    JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);
	  		    if(merce == null) {jaut--; break;}
	  		  jaut++;
  		    break;
  		   
  			case 3:
	  		    Gala = (String) JOptionPane.showInputDialog(null, "Izvēlies gaļas veidu", "Izvēle",
	  		    JOptionPane.QUESTION_MESSAGE, null, galas, galas[0]);
	  		  if(Gala == null) { jaut--; break;}
	  		  jaut++;
  		    break;
  		    
  			case 4:
  				siers =  Picerija.jautajums("Vai pievienot sieru?");
  				if(siers == 2) { jaut --; break; }
  				jaut++;
  		    break;
  		    
  			case 5:
  					topingi = (String) JOptionPane.showInputDialog(null, "Izvēlies papildus topingus", "Izvēle",
  		            JOptionPane.QUESTION_MESSAGE, null, citi, citi[0]);
  					if(topingi == null) { jaut--; break;}
  					jaut++;
  		    break;
  		    
  			case 6:
  				lidznemt = Picerija.jautajums("Vai būs papildus uzkodas vai dzēriens?");
	
	  		    if (lidznemt == 1) {
	  		        dzeriens = "Bez dzeramā";
	  		        uzkoda = "Bez uzkodas";
	  		    } else if(lidznemt == 0) {
	  		        dzeriens = (String) JOptionPane.showInputDialog(null, "Izvēlies papildus dzeramo", "Izvēle",
	  		                JOptionPane.QUESTION_MESSAGE, null, dzerieni, dzerieni[0]);
	  		      if(dzeriens == null) { jaut--; break;}
	
	  		        uzkoda = (String) JOptionPane.showInputDialog(null, "Izvēlies papildus uzkodu", "Izvēle",
	  		                JOptionPane.QUESTION_MESSAGE, null, uzkodas, uzkodas[0]);
	  		      if(uzkoda == null) {jaut--; break;}
	  		    }else {jaut--; break;}
	  		    
	  		  jaut++;
  		    break;

  			case 7:
  				Vards = Picerija.virknesParbaude("Ievadi savu vārdu", "Jānis");
  				if(Vards == null) {jaut--; break;}
  				jaut++;
  		    break;
  		    
  			case 8:
  		    piegade = false;
  		    adresse = "Nav";
  		    telefonaNR = "Nav";

  		    lidznemt = Picerija.jautajums("Vai pica būs līdzņemšanai?");
  		    if(lidznemt == JOptionPane.CANCEL_OPTION) { jaut--; break;}
  		    if (lidznemt == 0) {
  		        piegade = JOptionPane.showConfirmDialog(null, "Vai nepieciešama piegāde?") == 0;

  		        if (piegade) {
  		            adresse = JOptionPane.showInputDialog("Ievadi piegādes adresi", "Bērzu gatve 4");
  		          if(adresse == null) { jaut--; break;}
  		          
  		            telefonaNR = Picerija.telParbaude("Ievadi savu telefona nr", "+371");
  		          if(telefonaNR == null) { jaut--; break;}
  		        }
  		    }
  		    
  		    jaut++;
  		    break;
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

	public static void main(String[] args) {
		
		//Sākuma ekrāna ielāde 
		Picerija.loading.show();
		
		//Sākuma ekrāns
		Picerija.sakumaEkrans();

		
	}

}

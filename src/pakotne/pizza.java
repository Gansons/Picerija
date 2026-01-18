package pakotne;

public class pizza {

	private String izmers;
	private String gala;
	private String merce;
	private String adresse;
	private String telefonaNR;
	private String Vards;
	private int siers;
	private int lidznemt;
	private boolean piegade;
	private String topingi;
	private String dzeriens;
	private String uzkoda;

	
	//Konstruktors
	public pizza(String izmers, String gala, String merce, String adresse, String telefonaNR, String Vards,
			 int siers, int lidznemt, boolean piegade, String topingi, String dzeriens,
			String uzkoda) {
		this.izmers = izmers;
		this.gala = gala;
		this.merce = merce;
		this.adresse = adresse;
		this.telefonaNR = telefonaNR;
		this.Vards = Vards;
		this.siers = siers;
		this.lidznemt = lidznemt;
		this.piegade = piegade;
		this.topingi = topingi;
		this.dzeriens = dzeriens;
		this.uzkoda = uzkoda;
	}
	//Metodes
	
		public String noteiktIzm(){
			return izmers;
		}
		
		public String noteiktGal(){
			return gala;
		}
		
		public String noteiktMerci(){
			return merce;	
		}
		public String noteiktAdressi(){
			return adresse;	
		}
		public String noteiktTelnr(){
			return telefonaNR;	
		}
		public String noteiktVardu(){
			return Vards;	
		}
		public int noteiktSiers(){
			return siers;	
		}
		public int noteiktLidz(){
			return lidznemt;	
		}
		public boolean noteiktPiegade(){
			return piegade;	
		}
		public String noteiktTop(){
			return topingi;	
		}
		public String noteiktDzer(){
			return dzeriens;	
		}
		public String noteiktUzk(){
			return uzkoda;	
		}
		
	

		
	public String  toString() {
		return  "Picas pasūtījums\n" +
                "=========================\n" +
                "Klients: " + Vards + "\n" +
                "Telefons: " + telefonaNR + "\n" +
                "Adrese: " + adresse + "\n\n" +
                "------\n"+
                "Pica: \n" +
                "Izmērs: " + izmers + "\n" +
                "Gaļa: " + gala + "\n" +
                "Mērce: " + merce + "\n" +
                "Topingi: "+ topingi + "\n" +
                "Siers: " + (siers == 0 ? "Jā" : "Nē") + "\n" +
                "Uzkodas/dzērieni:\n"+
                "Dzēriens: "+ dzeriens + "\n" +
                "Uzkodas: "+ uzkoda + "\n" +
                "------\n"+
                "Līdzņemšana: " + (lidznemt == 0 ? "Jā" : "Nē") + "\n" +
                "Piegāde: " + (piegade ? "Jā" : "Nē") + "\n\n" +
                "Cena: " + Picerija.aprekinatCenu(izmers, gala, merce, topingi, siers, lidznemt, piegade, dzeriens, uzkoda) + " EUR\n" +
                "=========================\n" +
                "Paldies par pasūtījumu!";
	}
	
	

    
}

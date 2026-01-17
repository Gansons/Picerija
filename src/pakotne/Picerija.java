package pakotne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class Picerija {
	
public static void sakumaEkrans(){
	JFrame frame = new JFrame("Pizza Cooker Menu");
	
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    
    //Tituls
    JLabel title = new JLabel("Pizza Cooker", SwingConstants.CENTER);
    title.setFont(new Font("Arial", Font.BOLD, 20));
    frame.add(title, BorderLayout.NORTH);
    	
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3, 1, 10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20 ,20));
    panel.setBackground(new Color(240, 240, 240));
    
    ImageIcon raw = new ImageIcon("Registret.png");
    Image scaled = raw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    ImageIcon icon = new ImageIcon(scaled);

    JButton btnNew = new JButton("Reģistrēt pasūtījumu", icon);
    btnNew.setHorizontalTextPosition(SwingConstants.RIGHT);
    btnNew.setIconTextGap(10);

    raw = new ImageIcon("Aktivie.png");
    scaled = raw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    icon = new ImageIcon(scaled);

    JButton btnAktivie = new JButton("Aktīvie pasūtījumi", icon);
    btnAktivie.setHorizontalTextPosition(SwingConstants.RIGHT);
    btnAktivie.setIconTextGap(10);
    
    raw = new ImageIcon("Nodotie.png");
    scaled = raw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    icon = new ImageIcon(scaled);

    JButton btnNodotie = new JButton("Nodotie pasūtījumi", icon);
    btnNodotie.setHorizontalTextPosition(SwingConstants.RIGHT);
    btnNodotie.setIconTextGap(10);
    
    //Reģistrēt jaunu poga
    btnNew.setFocusPainted(false);
    btnNew.setFont(new Font("Arial", Font.BOLD, 17));
    btnNew.setBackground(new Color(220, 220, 255));
    btnNew.setOpaque(false);
    
    btnNew.addActionListener(e -> {
        Pica.pasutijums();
    });

    //Aktīvie poga
    btnAktivie.setFocusPainted(false);
    btnAktivie.setFont(new Font("Arial", Font.BOLD, 17));
    btnAktivie.setBackground(new Color(220, 220, 255));
    btnAktivie.setOpaque(false);
    
    btnAktivie.addActionListener(e -> {
    	DarbsArFailu.nolasitAkt();
    });
    
    //Nodotie poga
    btnNodotie.setFocusPainted(false);
    btnNodotie.setFont(new Font("Arial", Font.BOLD, 17));
    btnNodotie.setBackground(new Color(220, 220, 255));
    btnNodotie.setOpaque(false);
    
    btnNodotie.addActionListener(e -> {
    	DarbsArFailu.nolasit();
    });
    
    panel.add(btnNew);
    
    

    panel.add(btnAktivie);
    panel.add(btnNodotie);

    frame.add(panel);
    frame.setVisible(true);
}

	
	public static class loading {

		public static void show() {
		    JWindow splash = new JWindow();

		    ImageIcon icon = new ImageIcon("Loading.gif");
		    Image scaled = icon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		    ImageIcon resizedIcon = new ImageIcon(scaled);

		    JLabel gif = new JLabel(resizedIcon);
		    splash.add(gif);

		    splash.pack();
		    splash.setLocationRelativeTo(null);
		    splash.setVisible(true);

		    try {
		        Thread.sleep(3000);
		    } catch (InterruptedException e) {}

		    splash.dispose();
		}

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
                             Vards, boolean siers, boolean lidznemt, boolean piegade, String topingi, String dzeriens, String uzkoda) {

        double cena = aprekinatCenu(izmers, Gala, merce, topingi, lidznemt, piegade, siers, dzeriens, uzkoda);

        
        
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
                "Siers: " + (siers ? "Jā" : "Nē") + "\n\n" +
                "Uzkodas/dzērieni:\n"+
                "Dzēriens: "+ dzeriens + "\n" +
                "Uzkodas: "+ uzkoda + "\n" +
                "------\n"+
                "Līdzņemšana: " + (lidznemt ? "Jā" : "Nē") + "\n" +
                "Piegāde: " + (piegade ? "Jā" : "Nē") + "\n\n" +
                "Cena: " + cena + " EUR\n" +
                "=========================\n" +
                "Paldies par pasūtījumu!";

        JOptionPane.showMessageDialog(null, zinjojums);
    }

    static double aprekinatCenu(String izmers, String Gala, String merce, String topingi,
                                boolean siers, boolean lidznemt, boolean piegade, String dzeriens , String uzkoda) {
    	if (izmers == null) izmers = "";
    	if (Gala == null) Gala = "";
    	if (merce == null) merce = "";
    	if (topingi == null) topingi = "Bez topingiem";
    	if (dzeriens == null) dzeriens = "Bez dzeramā";
    	if (uzkoda == null) uzkoda = "Bez uzkodas";

        double cena = 5.0;

        switch (izmers.toUpperCase()) {
            case "L (24\\\")": cena += 6; break;
            case "M (18\\\")": cena += 4; break;
            case "S (15\\\")": cena += 2; break;
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
    
    public static void showProgressTimer(int seconds,  Runnable izcepts) {
        JFrame frame = new JFrame("Picas cepšana");
        frame.setSize(300, 120);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JProgressBar bar = new JProgressBar(0, seconds);
        bar.setValue(seconds);
        bar.setStringPainted(true);

        //JLabel label = new JLabel("Atlikušais laiks: " + seconds + " s", JLabel.CENTER);
        

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
                //label.setText("Atlikušais laiks: " + timeLeft + " s");

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
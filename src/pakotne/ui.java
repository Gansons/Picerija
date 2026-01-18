package pakotne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class ui {

	public static void sakumaEkrans(){
		JFrame frame = new JFrame("Pizza Cooker Menu");
		
	    frame.setSize(400, 500);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    
	    //Tituls
	    JLabel title = new JLabel("Pizza Cooker", SwingConstants.CENTER);
	    title.setFont(new Font("Arial", Font.BOLD, 20));
	    frame.add(title, BorderLayout.NORTH);
	    	
	    //Grid izkārtojums
	    JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(4, 1, 10, 10)); //GRID, maina pogas izkārtojumu un daudzumu (pirmais cipars vēlamo pogu daudzums)
	    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20 ,20));
	    panel.setBackground(new Color(240, 240, 240));
	    
	    //Reģistrēt poga
	    ImageIcon raw = new ImageIcon(Picerija.class.getResource("/asseti/Registret.png"));
	    Image scaled = raw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	    ImageIcon icon = new ImageIcon(scaled);

	    JButton btnNew = new JButton("Reģistrēt pasūtījumu", icon);
	    btnNew.setHorizontalTextPosition(SwingConstants.RIGHT);
	    btnNew.setIconTextGap(10);
	    
	    //Aktīvie poga
	    raw = new ImageIcon(Picerija.class.getResource("/asseti/Aktivie.png"));
	    scaled = raw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	    icon = new ImageIcon(scaled);

	    JButton btnAktivie = new JButton("Aktīvie pasūtījumi", icon);
	    btnAktivie.setHorizontalTextPosition(SwingConstants.RIGHT);
	    btnAktivie.setIconTextGap(10);
	    
	    //Nodotie poga
	    raw = new ImageIcon(Picerija.class.getResource("/asseti/Nodotie.png"));
	    scaled = raw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	    icon = new ImageIcon(scaled);

	    JButton btnNodotie = new JButton("Nodotie pasūtījumi", icon);
	    btnNodotie.setHorizontalTextPosition(SwingConstants.RIGHT);
	    btnNodotie.setIconTextGap(10);
	    
	    //Metodes poga
	    raw = new ImageIcon(Picerija.class.getResource("/asseti/metodes.png"));
	    scaled = raw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	    icon = new ImageIcon(scaled);
	    
	    JButton btnMetodes = new JButton("Izsaukt picas metodes", icon);
	    btnNodotie.setHorizontalTextPosition(SwingConstants.RIGHT);
	    btnNodotie.setIconTextGap(10);
	    
	    //Iziet poga
	    raw = new ImageIcon(Picerija.class.getResource("/asseti/Exit.png"));
	    scaled = raw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	    icon = new ImageIcon(scaled);
	    
	    JButton btnExit = new JButton("Iziet", icon);
	    btnNodotie.setHorizontalTextPosition(SwingConstants.RIGHT);
	    btnNodotie.setIconTextGap(10);
	    
	    //Reģistrēt jaunu poga
	    btnNew.setFocusPainted(false);
	    btnNew.setFont(new Font("Arial", Font.BOLD, 17));
	    btnNew.setBackground(new Color(220, 220, 255));
	    btnNew.setOpaque(false);
	    
	    //Metodes poga ==============
	    btnMetodes.setFocusPainted(false);
	    btnMetodes.setFont(new Font("Arial", Font.BOLD, 17));
	    btnMetodes.setBackground(new Color(220, 220, 255));
	    btnMetodes.setOpaque(false);
	    
	    //Exit poga ===========
	    btnExit.setFocusPainted(false);
	    btnExit.setFont(new Font("Arial", Font.BOLD, 17));
	    btnExit.setBackground(new Color(220, 220, 255));
	    btnExit.setOpaque(false);

	    //Aktīvie poga
	    btnAktivie.setFocusPainted(false);
	    btnAktivie.setFont(new Font("Arial", Font.BOLD, 17));
	    btnAktivie.setBackground(new Color(220, 220, 255));
	    btnAktivie.setOpaque(false);
	    
	    //Nodotie poga
	    btnNodotie.setFocusPainted(false);
	    btnNodotie.setFont(new Font("Arial", Font.BOLD, 17));
	    btnNodotie.setBackground(new Color(220, 220, 255));
	    btnNodotie.setOpaque(false);
	    
	    //Pogu darbības
	    btnNew.addActionListener(e -> {
	        Pica.pasutijums();
	    });
	    
	    btnAktivie.addActionListener(e -> {
	    	 String[] aktivoIzv = { "Skatīt aktīvos pasūtījumus", "Pabeigt pasūtījumu"};
	    	 String izvele = (String)JOptionPane.showInputDialog(null, "metodes izvēle", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, aktivoIzv, aktivoIzv[0]);
	    	 if(izvele == null) return;
	    	 
	    	 switch(izvele) {
	    	 case "Skatīt aktīvos pasūtījumus":
	    		 if(Pica.PicaList.isEmpty()) {  JOptionPane.showMessageDialog(null, "Nav aktīvu pasūtījumu!", "Kļūda",JOptionPane.WARNING_MESSAGE); return;}
	    		 	Pica.aktivieSutijumi();
	    		 break;
	    		 
	    	 case "Pabeigt pasūtījumu":
	    		 if (Pica.PicaList.isEmpty()) {
	                 JOptionPane.showMessageDialog(null, "Nav neviena pasūtījuma, ko nodot!", "Kļūda",JOptionPane.WARNING_MESSAGE); return;}
	              else
	                 Pica.aktivieSutijumi();
	             break;
	    	 }
	    	 
	    });
	    
	    btnNodotie.addActionListener(e -> {
	    	DarbsArFailu.nolasit();
	    });
	    
	    btnExit.addActionListener(e -> {
	    	System.exit(0);
	    });
	    
	    //--------
	    
	    //Pievieno pogu panelim, pogu kārtība
	    panel.add(btnNew);
	    panel.add(btnAktivie);
	    panel.add(btnNodotie);
	    panel.add(btnExit);    
	    
	    frame.add(panel);
	    frame.setVisible(true);
	}

		public static class loading {

			public static void show() {
			    JWindow splash = new JWindow();
			    
			    ImageIcon icon = new ImageIcon(loading.class.getResource("/asseti/Loading.gif"));
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
	
}

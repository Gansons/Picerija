package pakotne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DarbsArFailu {

static String failaNosaukums = "picas.txt";
	
	public static void saglabat(ArrayList<pizza> picaList) {
		try {
		FileWriter fw = new FileWriter(failaNosaukums, true);
		PrintWriter pw = new PrintWriter (fw);
		pw.println(picaList.toString());
		pw.println("+++++++++++++++++++++++++++++++++++++++++++++");
		pw.close();
		
	} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Kūda ierakstot failā!", "Kļūda", JOptionPane.ERROR_MESSAGE);
			}
		
	}
	
	public static void nolasit() {
		String teksts, str = "";
		try {
			FileReader fr = new FileReader(failaNosaukums);
			BufferedReader br = new BufferedReader(fr);
			while((teksts = br.readLine()) !=null) {
				str += teksts+"\n";
			}
			br.close();
			
			JTextArea ta = new JTextArea(str,10, 40);
			ta.setEditable(false);
			JScrollPane sp = new JScrollPane(ta);
			sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			JOptionPane.showMessageDialog(ta, sp, "Saglabātās picas", JOptionPane.PLAIN_MESSAGE);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Kūda nolasot failu!", "Kļūda", JOptionPane.ERROR_MESSAGE);
			}
	}
}

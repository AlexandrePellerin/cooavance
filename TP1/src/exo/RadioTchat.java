package exo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RadioTchat extends Subject{
	
	JTextField field;
	JTextArea area;
	
	public RadioTchat(){
		 RadioTchat ceci = this;
		JFrame fenetre = new JFrame("Radio Tchat");
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(300, 500);
		fenetre.setLocationRelativeTo(null);
		
		JButton boutons = new JButton("Nouvel Auditeur");
		boutons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attach(new Auditeur(ceci));
			}
		});
		
		this.area = new JTextArea();
		this.area.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(this.area);
		
		this.field = new JTextField();
		this.field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.append(field.getText()+"\n");
				notifyObservers();
				field.setText("");
			}
		});
		
		fenetre.add(boutons,BorderLayout.NORTH);
		fenetre.add(scroll,BorderLayout.CENTER);
		fenetre.add(field,BorderLayout.SOUTH);
		
		fenetre.setVisible(true);
	}
	
	public void maj(String chaine){
		this.field.setText(chaine);
		this.area.append(chaine);
		this.notifyObservers();
		this.field.setText("");
	}
	
	public static void main(String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RadioTchat();
			}
		});
	}
}

package exo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Auditeur extends Observer{

	private JFrame fenetre;
	private JTextArea area;
	private JTextField field;
	
	public RadioTchat subject;
	
	public Auditeur(RadioTchat subject){
		this.subject = subject;
		
		this.fenetre = new JFrame("Auditeur");
		this.area = new JTextArea();
		this.area.setEditable(false);
		this.field = new JTextField();
		this.field.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				subject.maj(field.getText()+"\n");
				field.setText("");
			}
		});
		
		this.fenetre.setSize(300, 500);
		
		Auditeur a = this;
		
		this.fenetre.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				subject.detach(a);
				fenetre.dispose();
			}
		});
		this.fenetre.add(this.area,BorderLayout.CENTER);
		this.fenetre.add(this.field,BorderLayout.SOUTH);
		this.fenetre.setVisible(true);
	}
	
	public void Update() {
		this.area.append(subject.field.getText()+"\n");
	}
}

package streamming;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;

import main.Cliente;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class TelaListar {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public TelaListar() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		DefaultListModel listmodel = new DefaultListModel();
		list.setBounds(12, 13, 290, 247);
		frame.getContentPane().add(list);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Cliente.conexao.setIdPlayer(0);
				} catch (Exception e) {
					
				}
				hide();
			}
		});
		btnVoltar.setBounds(314, 235, 97, 25);
		frame.getContentPane().add(btnVoltar);
		
		try {
			ArrayList list_music = (ArrayList) Cliente.conexao.exibir();
			for(int i=0;i<list_music.size();i++){
				String music = (String) list_music.get(i);
				listmodel.addElement(music);
			}
			
			list.setModel(listmodel);
		}
		catch(Exception e) {
			
		}
	}

	public void show(){
		  this.frame.setVisible(true);
		}
	public void hide(){
		  this.frame.setVisible(false);
		}
}

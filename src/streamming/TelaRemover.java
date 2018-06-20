package streamming;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;

import javax.swing.JFrame;
import javax.swing.JList;

import main.Streamming;

import javax.swing.JButton;

public class TelaRemover {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemover window = new TelaRemover();
					window.frame.setVisible(true);
					try {
						Streamming stream = (Streamming) Naming.lookup("//localhost/streamming");
						
					} catch (MalformedURLException murle) {

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRemover() {
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
		list.setBounds(12, 13, 293, 247);
		frame.getContentPane().add(list);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(319, 122, 97, 25);
		frame.getContentPane().add(btnRemover);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hide();
			}
		});
		btnVoltar.setBounds(319, 193, 97, 25);
		frame.getContentPane().add(btnVoltar);
	}
	public void show(){
		  this.frame.setVisible(true);
		}
	public void hide(){
		  this.frame.setVisible(false);
		}
}

package streamming;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import main.Cliente;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class TelaRemover {

	private JFrame frame;

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
		DefaultListModel listmodel = new DefaultListModel();
		list.setBounds(12, 13, 293, 247);
		frame.getContentPane().add(list);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String selecionado = list.getSelectedValue().toString();
					Cliente.conexao.remover(selecionado);
					JOptionPane.showMessageDialog(null, "A faixa: " + selecionado + " foi removida com sucesso!");
					Cliente.conexao.setIdPlayer(0);
					hide();
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NullPointerException x) {
					JOptionPane.showMessageDialog(null, "Selecione uma faixa para ser removida");
				}
			}
		});
		btnRemover.setBounds(319, 122, 97, 25);
		frame.getContentPane().add(btnRemover);

		try {
			ArrayList list_music = (ArrayList) Cliente.conexao.exibir();

			for (int i = 0; i < list_music.size(); i++) {
				String music = (String) list_music.get(i);
				listmodel.addElement(music);
			}

			list.setModel(listmodel);
		} catch (Exception e) {

		}

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
			/*	try {
					Cliente.conexao.setIdPlayer(0);
				} catch (Exception e) {
					
				}*/
				hide();
			}

		});
		btnVoltar.setBounds(319, 193, 97, 25);
		frame.getContentPane().add(btnVoltar);

	}

	public void show() {
		this.frame.setVisible(true);
	}

	public void hide() {
		this.frame.setVisible(false);
	}
}

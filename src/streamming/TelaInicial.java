package streamming;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaInicial {

	public JFrame frame;
	private JTextField txtBemVindosAo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws RemoteException, NotBoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnListarFaixas = new JButton("Listar Faixas");
		btnListarFaixas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListar tela = new TelaListar();
				tela.show();
			}
		});
		btnListarFaixas.setBounds(58, 116, 130, 25);
		
		JButton btnInserirFaixas = new JButton("Inserir Faixas");
		btnInserirFaixas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInserir tela = new TelaInserir();
				tela.show();
			}
		});
		btnInserirFaixas.setBounds(58, 185, 130, 25);
		btnInserirFaixas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnRemoverFaixa = new JButton("Remover Faixa");
		btnRemoverFaixa.setBounds(286, 116, 130, 25);
		btnRemoverFaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemover tela = new TelaRemover();
				tela.show();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnInserirFaixas);
		frame.getContentPane().add(btnRemoverFaixa);
		frame.getContentPane().add(btnListarFaixas);
		
		txtBemVindosAo = new JTextField();
		txtBemVindosAo.setForeground(Color.BLUE);
		txtBemVindosAo.setBackground(Color.WHITE);
		txtBemVindosAo.setEditable(false);
		txtBemVindosAo.setFont(new Font("Freestyle Script", Font.PLAIN, 48));
		txtBemVindosAo.setHorizontalAlignment(SwingConstants.CENTER);
		txtBemVindosAo.setText("Bem Vindos ao StreamMaster");
		txtBemVindosAo.setBounds(23, 28, 455, 63);
		frame.getContentPane().add(txtBemVindosAo);
		txtBemVindosAo.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(286, 185, 130, 25);
		frame.getContentPane().add(btnSair);
		
	}
	public void show(){
		  this.frame.setVisible(true);
		}	
}

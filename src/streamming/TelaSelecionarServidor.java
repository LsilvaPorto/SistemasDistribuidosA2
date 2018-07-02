package streamming;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Cliente;
import main.Streamming;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;

public class TelaSelecionarServidor {

	private JFrame frame;
	public static Streamming con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSelecionarServidor window = new TelaSelecionarServidor();
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
	public TelaSelecionarServidor() {
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

		JTextField txtSelecionarServidor = new JTextField();
		txtSelecionarServidor.setEnabled(false);
		txtSelecionarServidor.setText("Selecione o Servidor Desejado");
		txtSelecionarServidor.setHorizontalAlignment(SwingConstants.CENTER);
		txtSelecionarServidor.setForeground(Color.BLUE);
		txtSelecionarServidor.setFont(new Font("Freestyle Script", Font.PLAIN, 48));
		txtSelecionarServidor.setEditable(false);
		txtSelecionarServidor.setColumns(10);
		txtSelecionarServidor.setBackground(Color.WHITE);
		txtSelecionarServidor.setBounds(0, 0, 502, 76);
		frame.getContentPane().add(txtSelecionarServidor);

		JButton btnServidor1 = new JButton("Servidor 1");
		btnServidor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Streamming con = (Streamming) Naming.lookup("//10.0.200.118/streamming");
					Cliente.conexao = con;
					TelaInicial tela = new TelaInicial();
					tela.show();
					hide();
				} catch (RemoteException | MalformedURLException | NotBoundException e) {
					JOptionPane.showMessageDialog(null, "Servidor OffLine!");
				}
			}
		});
		btnServidor1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnServidor1.setBounds(12, 173, 130, 35);
		frame.getContentPane().add(btnServidor1);

		JButton btnServidor = new JButton("Servidor 2");
		btnServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Streamming con = (Streamming) Naming.lookup("//10.0.200.86/streamming");
					Cliente.conexao = con;
					TelaInicial tela = new TelaInicial();
					tela.show();
					hide();
				} catch (RemoteException | MalformedURLException | NotBoundException e) {
					JOptionPane.showMessageDialog(null, "Servidor OffLine!");
				}
			}
		});
		btnServidor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnServidor.setBounds(187, 173, 130, 35);
		frame.getContentPane().add(btnServidor);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(360, 173, 130, 35);
		frame.getContentPane().add(btnSair);
	}
	void hide() {
		this.frame.setVisible(false);
	}
	public void show() {
		this.frame.setVisible(true);
	}

}

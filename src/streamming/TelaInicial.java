package streamming;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Cliente;
import main.Streamming;

public class TelaInicial {

	public JFrame frame;
	private JTextField txtBemVindosAo;
	private Timer time_check = new Timer();
	private Timer time = new Timer();

	private JLabel lblClienteId = new JLabel("");

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
		this.time_check.schedule(this.check_alteracao(), new Date(), 1000);
		this.time.schedule(this.check(), new Date(), 1000);
		lblClienteId.setText(String.valueOf(Cliente.id));

	}

	private TimerTask check() {
		return new TimerTask() {
			@Override
			public void run() {
				try {
						if (Cliente.id != Cliente.conexao.getIdPlayer()) {	
							if (Cliente.conexao.getI() == 1) {
								JOptionPane.showMessageDialog(null, Cliente.id+" O outro cliente Aceitou as altera��es ");//+Cliente.id);
								Cliente.conexao.setI();
							}
							if (Cliente.conexao.getI() == 2) {
								JOptionPane.showMessageDialog(null, Cliente.id+"O outro cliente descartou as altera��es ");//+Cliente.id);
								Cliente.conexao.setI();
							}
					}
					
						
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
			}
		};
	}
	
	private TimerTask check_alteracao() {
		return new TimerTask() {
			@Override
			public void run() {
				try {
					
					if (Cliente.conexao.ListaMudou() && Cliente.id != Cliente.conexao.getIdPlayer()) {
						int resposta = JOptionPane.showConfirmDialog(null, "Cliente " + String.valueOf(Cliente.id)
								+ ": Altera��es foram feitas, salvar altera��es?\nsim/ nao");
						// String resposta = JOptionPane.showInputDialog("Altera��es foram feitas,
						// salvar altera��es?\nsim/ nao");
						if (resposta == JOptionPane.YES_OPTION) { // resposta.equals("sim")) {
							Cliente.conexao.confirmaLista(true, Cliente.id);
							JOptionPane.showMessageDialog(null, "As altera��es foram salvas!");
						} else {// if (resposta.equals("nao")){
							Cliente.conexao.confirmaLista(false, Cliente.id);
							JOptionPane.showMessageDialog(null, "As altera��es foram descartadas!");
						}
												
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
			}
		};
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
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Thread() {

						@Override
						public void run() {
							try {
								if (Cliente.conexao.getPosso(Cliente.id)) {
									TelaListar tela = new TelaListar();
									Cliente.conexao.returnList(Cliente.id);
									tela.show();
								} else
									JOptionPane.showMessageDialog(null, "Aguarde a sua vez!");
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}.start();

					// Cliente.conexao.checkList(Cliente.conexao.exibir());
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});
		btnListarFaixas.setBounds(58, 116, 130, 25);

		JButton btnInserirFaixas = new JButton("Inserir Faixas");
		btnInserirFaixas.setBounds(58, 174, 130, 25);
		btnInserirFaixas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Cliente.conexao.getPosso(Cliente.id)) {
						String resposta = JOptionPane.showInputDialog(null, "Insira uma faixa");
						if (resposta.equals("")) {
							JOptionPane.showMessageDialog(null, "a faixa n�o deve estar vazia");
						}else if (Cliente.conexao.exibir().contains(resposta)){
							JOptionPane.showMessageDialog(null, "Faixa j� inserida");
						}else {
							Cliente.conexao.inserir(resposta);
						}
							
//						Cliente.conexao.ListaMudou();
					} else {
						JOptionPane.showMessageDialog(null, "Aguarde a sua vez", "N�o � a sua vez",
								JOptionPane.OK_OPTION);
					}

				} catch (NullPointerException i) {
					
				}catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*
			 * try { new Thread() {
			 * 
			 * @Override public void run() { try { if (Cliente.conexao.getIdPlayer() == 0) {
			 * Cliente.conexao.setIdPlayer(Cliente.id); }
			 * System.out.println(Cliente.conexao.getPosso(Cliente.id));
			 * System.out.println(Cliente.conexao.getIdPlayer()); if
			 * (Cliente.conexao.getPosso(Cliente.id)) { TelaInserir tela = new
			 * TelaInserir(); Cliente.conexao.returnList(Cliente.id); tela.show(); } else
			 * if(Cliente.conexao.getPosso2(Cliente.id)) { TelaInserir tela = new
			 * TelaInserir(); Cliente.conexao.returnList(Cliente.id); tela.show(); }else
			 * JOptionPane.showMessageDialog(null, "Aguarde a sua vez!"); } catch
			 * (RemoteException e) { // TODO Auto-generated catch block e.printStackTrace();
			 * } } }.start();
			 * 
			 * // Cliente.conexao.checkList(Cliente.conexao.exibir()); } catch (Exception e)
			 * { // TODO: handle exception }
			 * 
			 * }
			 */
		});

		JButton btnRemoverFaixa = new JButton("Remover Faixa");
		btnRemoverFaixa.setBounds(286, 116, 130, 25);
		btnRemoverFaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Thread() {

						@Override
						public void run() {
							try {
								if (Cliente.conexao.getPosso(Cliente.id)) {
									TelaRemover tela = new TelaRemover();
									Cliente.conexao.returnList(Cliente.id);
									tela.show();
								} else {
									JOptionPane.showMessageDialog(null, "Aguarde a sua vez!");
								}
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}.start();

					// Cliente.conexao.checkList(Cliente.conexao.exibir());
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});

		JButton btnResetServidor = new JButton("Reset Servidor");
		btnResetServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String resp;
				try {
					Cliente.conexao.reset();
					JOptionPane.showMessageDialog(null, "O servidor foi reiniciado e voc� est� desconectado!");
					resp = JOptionPane.showInputDialog(null, "Caso queira se reconectar\n Insira 's1'"
							+ " para Servidor 1 ou 's2' para Servidor 2");
					if (resp.equals("s1")) {
						Streamming con = (Streamming) Naming.lookup("//10.0.200.81/streamming");
						Cliente.conexao = con;
						con.setIdPlayer(Cliente.id);
						}else if (resp.equals("s2")) {
							Streamming con = (Streamming) Naming.lookup("//10.0.200.81/streamming");
							Cliente.conexao = con;
							con.setIdPlayer(Cliente.id);
					}
					
				} catch (RemoteException |MalformedURLException | NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnResetServidor.setBounds(286, 235, 130, 25);
		frame.getContentPane().add(btnResetServidor);

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
		btnSair.setBounds(286, 174, 130, 25);
		frame.getContentPane().add(btnSair);

		JLabel lblClienteid = new JLabel("ClienteID:");
		lblClienteid.setBounds(47, 244, 56, 16);
		frame.getContentPane().add(lblClienteid);

		lblClienteId.setBounds(103, 244, 151, 16);
		frame.getContentPane().add(lblClienteId);

	}

	public void show() {
		this.frame.setVisible(true);
	}
}

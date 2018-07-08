package streamming;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class TelaInicial {

	public JFrame frame;
	private JTextField txtBemVindosAo;
	private Timer time_check = new Timer();
	
	private JLabel lblClienteId = new JLabel("");
	
	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
		this.time_check.schedule(this.check_alteracao(), new Date(), 1000);
		lblClienteId.setText(String.valueOf(Cliente.id));
		
	}
	
	private TimerTask check_alteracao()  {
		return new TimerTask() {
			@Override
			public void run()  {
				try {
					if(Cliente.conexao.ListaMudou() && Cliente.id != Cliente.conexao.getIdPlayer()) {
						int resposta = JOptionPane.showConfirmDialog(null,"Cliente "+String.valueOf(Cliente.id)+": Alterações foram feitas, salvar alterações?\nsim/ nao");
						//String resposta = JOptionPane.showInputDialog("Alterações foram feitas, salvar alterações?\nsim/ nao");
						if (resposta == JOptionPane.YES_OPTION) { //resposta.equals("sim")) {
							Cliente.conexao.confirmaLista(true, Cliente.id);
							JOptionPane.showMessageDialog(null,"As alterações foram salvas!");
						} else {//if (resposta.equals("nao")){
							Cliente.conexao.confirmaLista(false, Cliente.id);
							JOptionPane.showMessageDialog(null,"As alterações foram descartadas!");
						}
					}
						
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// try to reconnect to another server
					//connectToServer(GameConfigs.getConfigArray("servers").getString(1));
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
								if (Cliente.conexao.getIdPlayer() == 0) {
									Cliente.conexao.setIdPlayer(Cliente.id);
								}
								System.out.println(Cliente.conexao.getPosso(Cliente.id));
								System.out.println(Cliente.conexao.getIdPlayer());
								if (Cliente.conexao.getPosso(Cliente.id)) {
									TelaListar tela = new TelaListar();
									Cliente.conexao.returnList(Cliente.id);
									tela.show();
								} else if(Cliente.conexao.getPosso2(Cliente.id)) {
									TelaListar tela = new TelaListar();
									Cliente.conexao.returnList(Cliente.id);
									tela.show();
								}else
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
						System.out.println(resposta);
						if (resposta!=null) {
							Cliente.conexao.inserir(resposta);
						}
						Cliente.conexao.ListaMudou();
					}
					else {
						JOptionPane.showMessageDialog(null, "Aguarde a sua vez", "Não é a sua vez", JOptionPane.OK_OPTION);
					}
						
				}
				catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				/*try {
					new Thread() {

						@Override
						public void run() {
							try {
								if (Cliente.conexao.getIdPlayer() == 0) {
									Cliente.conexao.setIdPlayer(Cliente.id);
								}
								System.out.println(Cliente.conexao.getPosso(Cliente.id));
								System.out.println(Cliente.conexao.getIdPlayer());
								if (Cliente.conexao.getPosso(Cliente.id)) {
									TelaInserir tela = new TelaInserir();
									Cliente.conexao.returnList(Cliente.id);
									tela.show();
								} else if(Cliente.conexao.getPosso2(Cliente.id)) {
									TelaInserir tela = new TelaInserir();
									Cliente.conexao.returnList(Cliente.id);
									tela.show();
								}else
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

			}*/
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
								if ((Cliente.conexao.getIdPlayer() == 0) && (Cliente.conexao.checkList())) {
									Cliente.conexao.setIdPlayer(Cliente.id);
								}
								System.out.println(Cliente.conexao.getPosso(Cliente.id));
								System.out.println(Cliente.conexao.getIdPlayer());
								if (Cliente.conexao.getPosso(Cliente.id)) {
									TelaRemover tela = new TelaRemover();
									Cliente.conexao.returnList(Cliente.id);
									tela.show();
								} else if(Cliente.conexao.getPosso2(Cliente.id)) {
									TelaRemover tela = new TelaRemover();
									Cliente.conexao.returnList(Cliente.id);

									tela.show();
								}else
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
		
		JButton btnResetServidor = new JButton("Reset Servidor");
		btnResetServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Cliente.conexao.reset();
				} catch (RemoteException e) {
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

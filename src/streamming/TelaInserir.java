package streamming;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Cliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import java.awt.Color;

public class TelaInserir {

	private JFrame frame;
	private JTextField txtExemplo;
	private JTextField txtInserirFaixas;
	

	/**
	 * Create the application.
	 */
	public TelaInserir() {
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
		
		txtExemplo = new JTextField();
		txtExemplo.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtExemplo.setHorizontalAlignment(SwingConstants.LEFT);
		txtExemplo.setBounds(12, 107, 478, 32);
		frame.getContentPane().add(txtExemplo);
		txtExemplo.setColumns(10);
		
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				try {
						String txt = txtExemplo.getText();
						if (!txt.isEmpty()) {
							Cliente.conexao.inserir(txt);
							JOptionPane.showMessageDialog(null, "A Faixa: "+txt+" foi inserida com sucesso!");
							txtExemplo.setText("");
						}else {
							JOptionPane.showMessageDialog(null, "A Faixa não deve estar vazia");
						}					
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInserir.setBounds(12, 161, 97, 25);
		frame.getContentPane().add(btnInserir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Cliente.conexao.setId(0);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				hide();
			}
		});
		btnVoltar.setBounds(379, 161, 97, 25);
		frame.getContentPane().add(btnVoltar);
		
		txtInserirFaixas = new JTextField();
		txtInserirFaixas.setText("Inserir Faixas");
		txtInserirFaixas.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserirFaixas.setForeground(Color.BLUE);
		txtInserirFaixas.setFont(new Font("Freestyle Script", Font.PLAIN, 48));
		txtInserirFaixas.setEditable(false);
		txtInserirFaixas.setColumns(10);
		txtInserirFaixas.setBackground(Color.WHITE);
		txtInserirFaixas.setBounds(12, 13, 478, 63);
		frame.getContentPane().add(txtInserirFaixas);
	}
	public void show(){
		  this.frame.setVisible(true);
		}
	public void hide(){
		  this.frame.setVisible(false);
		}
	public void insert(String x) {
		
	}
}

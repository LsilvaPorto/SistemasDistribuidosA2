import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class Cliente {
	public static void main(String[] args) throws RemoteException, NotBoundException {

		String resposta, faixa;
		int op = 0;

		do {

			resposta = JOptionPane.showInputDialog(null,
					"Escolha a opção desejada\n1 - Listar Faixas\n2 - Inserir Faixa\n" + "3 - Remover Faixa\n4 - Sair");
			if(resposta == null)
				op = 4;
			else if (resposta.equals("1") || resposta.equals("2") || resposta.equals("3") || resposta.equals("4")) {
				op = Integer.parseInt(resposta);

				try {
					Streamming stream = (Streamming) Naming.lookup("//localhost/streamming");
					if (op == 1) {
						JOptionPane.showMessageDialog(null, stream.exibir());
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							System.out.println("Ops, ocorreu um erro: " + e);
						}

					} else if (op == 2) {
						faixa = JOptionPane.showInputDialog(null, "Insira o nome da faixa\n");
						stream.inserir(faixa);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							System.out.println("Ops, ocorreu um erro: " + e);
						}
					} else if (op == 3) {
						faixa = JOptionPane.showInputDialog(null, "Insira o nome da faixa a ser removida\n");
						stream.remover(faixa);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							System.out.println("Ops, ocorreu um erro: " + e);
						}
					} else if (op == 4) {
						JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso serviço");
					}


				} catch (MalformedURLException murle) {

				}
			} else {
				JOptionPane.showMessageDialog(null, "Opção inválida \nTente Novamente");
			}
		} while (op != 4 && resposta != null);
	}
}
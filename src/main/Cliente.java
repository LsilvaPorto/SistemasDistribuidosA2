package main;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import streamming.TelaSelecionarServidor;
import streamming.TelaInicial;

public class Cliente {
	
	public static Streamming conexao;
	
	public static long id = System.currentTimeMillis();
	
	public static void main(String[] args)throws RemoteException, NotBoundException {
	 
		//TelaSelecionarServidor tela = new TelaSelecionarServidor();
		TelaInicial tela = new TelaInicial();
		tela.show();
		try {
			conexao = (Streamming) Naming.lookup("//localhost/streamming");

			if (conexao.getIdPlayer() == 0) {
				conexao.setIdPlayer(id);
				System.out.println(conexao.getIdPlayer());
			}
			System.out.println(id);
			
			
		} catch (Exception murle) {

		}
		
	}
	void setId() {
		
	}
}
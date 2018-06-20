package main;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import streamming.TelaInicial;

public class Cliente {
	
	public static Streamming conexao;
	
	public static void main(String[] args)throws RemoteException, NotBoundException {
	 
		try {
			conexao = (Streamming) Naming.lookup("//localhost/streamming");
			TelaInicial tela = new TelaInicial();
			tela.show();
			
			
		} catch (Exception murle) {

		}
		
	}
}
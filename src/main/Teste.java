package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Teste {

	public Teste() throws MalformedURLException, NotBoundException, RemoteException {
		try {
			Streamming obj = new StreammingImpl();
			Naming.rebind("//192.168.56.1/streamming:2000", obj);
			System.out.println("Servidor Online");
//			this.time.schedule(this.check(), new Date(), 8000);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
		boolean test = true;
		while(test) {
		try {
			Streamming con = (Streamming) Naming.lookup("//192.168.56.1/streamming");
			if (con.getIdPlayer()!= 0) {
				System.out.println("X antes da conexao: "+x);
				x = con.getIdPlayer();
				System.out.println("X depois da conexao: "+x);
				test = false;
			}
		}catch (Exception x){
			System.out.println("Aguardando outro servidor");
		}
		}
	} 
	long x = 0;

	public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
		new Teste();

	}

	
}

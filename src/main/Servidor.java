package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Servidor {

	public Servidor() throws MalformedURLException, NotBoundException {
		try {
			Streamming obj = new StreammingImpl();
			Naming.rebind("//10.0.200.118/streamming", obj);
			System.out.println("Servidor Online");
			this.time.schedule(this.check(), new Date(), 2000);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	} 
	long x = 1;

	public static void main(String[] args) throws MalformedURLException, NotBoundException {
		new Servidor();

	}

	private Timer time = new Timer();

	private TimerTask check() {
		return new TimerTask() {
			@Override
			public void run() {
				try {
					Streamming con = (Streamming) Naming.lookup("//10.0.200.1/streamming");
					if (con.getIdPlayer()!= 0) {
						x = con.getIdPlayer();
						System.out.println(x);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
			}
		};
	}
}

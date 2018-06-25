package main;

import java.rmi.Naming;

public class Servidor {

	public Servidor() {
		try {
			Streamming obj = new StreammingImpl();
			Naming.rebind("//localhost/streamming", obj);
			System.out.println("Servidor Online");
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	public static void main(String[] args) {
		new Servidor();
		
	}
}

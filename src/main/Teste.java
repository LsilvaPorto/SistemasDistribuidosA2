package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Teste {

	public Teste() throws MalformedURLException, NotBoundException {
		try {
			Streamming obj = new StreammingImpl();
			Naming.rebind("//10.0.200.1/streamming", obj);
			System.out.println("Servidor Online");
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	public static void main(String[] args) throws MalformedURLException, NotBoundException {
		new Teste();
		
	}
}

package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StreammingImpl extends UnicastRemoteObject implements Streamming {

	public ArrayList<String> lista = new ArrayList<String>();
	
	private boolean posso = true;
	
	private int id = 0;
		
	public StreammingImpl() throws java.rmi.RemoteException {
		super();
	}

	@Override
	public void inserir(String musica) throws java.rmi.RemoteException {
		lista.add(musica);
		

	}

	@Override
	public void remover(String musica) throws java.rmi.RemoteException {
		lista.remove(musica);

	}

	@Override
	public ArrayList<String> exibir() throws java.rmi.RemoteException {
		return lista;

	}

	@Override
	public boolean getPosso() throws RemoteException {
		return posso;
	}

	@Override
	public void setPosso(boolean status) throws RemoteException {
		posso = status;
		
	}
	/*@Override
	public boolean checkId(int i) {
		if (id == i)
			return true;
		else
			return false;
	}*/
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}

}

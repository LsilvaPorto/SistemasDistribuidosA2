package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StreammingImpl extends UnicastRemoteObject implements Streamming {

	public ArrayList<String> lista = new ArrayList<String>();
	public ArrayList<String> listaVirtual = new ArrayList<String>();

	private long idPlayer = 0;

	public StreammingImpl() throws java.rmi.RemoteException {
		super();
	}

	@Override
	public void inserir(String musica) throws java.rmi.RemoteException {
		listaVirtual.add(musica);

	}

	@Override
	public void remover(String musica) throws java.rmi.RemoteException {
		listaVirtual.remove(musica);

	}

	@Override
	public ArrayList<String> exibir() throws java.rmi.RemoteException {
		return listaVirtual;

	}

	@Override
	public boolean getPosso(long id) throws RemoteException {
		if (idPlayer == id && lista.equals(listaVirtual)) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean getPosso2(long id) throws RemoteException {// verificação do cliente 2 para saber se ele pode ou nao
																// salvar as alterações feitas pelo cliente 1
		if (idPlayer != id && !lista.equals(listaVirtual)) {
			return true;
		} else
			return false;
	}

	@Override
	public String returnList(long id) throws RemoteException {
		if (!lista.equals(listaVirtual)) {
			String resposta = JOptionPane.showInputDialog("Alterações foram feitas, salvar alterações?\nsim/ nao");
			if (resposta.equals("sim")) {
				lista = listaVirtual;
				JOptionPane.showMessageDialog(null,"As alterações foram salvas!");
				return  null;
			} else if (resposta.equals("nao")){
				listaVirtual = lista;
				JOptionPane.showMessageDialog(null,"As alterações foram descartadas!");
				return null;
			}
		}
		return null;
	}

	@Override
	public boolean checkList() {
		if (lista.equals(listaVirtual)) {
			return true;
		}else
			return false;
	}
	@Override
	public void setIdPlayer(long id) throws RemoteException {
		this.idPlayer = id;
	}

	@Override
	public long getIdPlayer() {
		return idPlayer;
	}

}

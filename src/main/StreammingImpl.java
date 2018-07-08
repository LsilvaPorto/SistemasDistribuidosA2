package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StreammingImpl extends UnicastRemoteObject implements Streamming {

	public ArrayList<String> lista = new ArrayList<String>();
	public ArrayList<String> listaVirtual = new ArrayList<String>();
	public int i = 0;
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

	public boolean ListaMudou() {
		return lista.equals(listaVirtual) ? false : true;
	}

	@Override
	public void confirmaLista(boolean salve, long cliente_id) {
		if (salve) {
			// lista.add(listaVirtual.get(listaVirtual.size()-1));
			lista.clear();
			lista.addAll(listaVirtual);
			i = 1;
		} else {
			// listaVirtual.remove(listaVirtual.size()-1);
			listaVirtual.clear();
			listaVirtual.addAll(lista);
			i = 2;
		}
		this.idPlayer = cliente_id; // esse cara faz com que cada alteração na lista resulte na mudança de player

	}

	@Override
	public String returnList(long id) throws RemoteException {
		if (!lista.equals(listaVirtual)) {
			String resposta = JOptionPane.showInputDialog("Alterações foram feitas, salvar alterações?\nsim/ nao");
			if (resposta.equals("sim")) {
				lista = listaVirtual;
				JOptionPane.showMessageDialog(null, "As alterações foram salvas!");
				return null;
			} else if (resposta.equals("nao")) {
				listaVirtual = lista;
				JOptionPane.showMessageDialog(null, "As alterações foram descartadas!");
				return null;
			}
		}
		return null;
	}

	@Override
	public boolean checkList() {
		if (lista.equals(listaVirtual)) {
			return true;
		} else
			return false;
	}

	@Override
	public void setIdPlayer(long id) throws RemoteException {
		// System.out.println("setando id: "+String.valueOf(id));
		this.idPlayer = id;
	}

	@Override
	public long getIdPlayer() {
		// System.out.println("Pegando id player");
		return idPlayer;
	}

	@Override
	public void reset() throws RemoteException {
		this.idPlayer = 0;
		this.lista.clear();
		this.listaVirtual.clear();
		this.i = 0;

	}

	@Override
	public int getI() throws RemoteException {
		return i;
	}

	@Override
	public void setI() throws RemoteException {
		this.i = 0;
	}

}

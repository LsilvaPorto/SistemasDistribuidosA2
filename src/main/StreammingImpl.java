package main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StreammingImpl extends UnicastRemoteObject implements Streamming {

	public ArrayList<String> lista = new ArrayList<String>();
	public ArrayList<String> BDlista = new ArrayList<String>();

	private boolean posso = true;
	public ArrayList<Long> ids = new ArrayList<Long>();
	private long id;
	private long idPosso = 0;

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
	public boolean getPosso(long id) throws RemoteException {
		if (idPosso == id ||this.id == 0||idPosso == 0) {
			idPosso = id;
			return true;
		} else
			return false;
	}


	@Override
	public void setPosso(boolean status) throws RemoteException {
		posso = status;

	}

	@Override
	public void sendId(long id) throws RemoteException {
		this.id = id;
		ids.add(id);
	}

	@Override
	public boolean id (long id) throws RemoteException {
		if (id == this.id) {
			return true;
		}else
			return false;
		
	}

	@Override
	public void setId(long id) throws RemoteException {
		idPosso = id;
		
	}

	@Override
	public String checkList(ArrayList lista) throws RemoteException {
		if (this.BDlista.equals(null) && lista != null) {
			String resposta = JOptionPane.showInputDialog("Alterações foram feitas, salvar alterações?\nsim/ nao");
			if (resposta.equals("sim")) {
				this.BDlista.addAll(lista);
				return resposta;
			}else {
					return null;
				}
			}
		//}else if (!lista.equals(this.BDlista)) {
		//}
		return null;
	}

}

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StreammingImpl extends UnicastRemoteObject implements Streamming {

	public ArrayList<String> lista = new ArrayList<String>();
	
		
	public StreammingImpl() throws java.rmi.RemoteException {
		super();
	}
	@Override
	public ArrayList<String> listaInicial() {
		String track = "faixa";
		for(int i = 0; i < 10; i++) {
			lista.add(track+" "+(i+1));
		}
		return lista;		
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

}

import java.util.ArrayList;

public interface Streamming extends java.rmi.Remote{

	public void inserir(String musica) throws java.rmi.RemoteException;

	public void remover(String musica) throws java.rmi.RemoteException;

	public ArrayList<String> exibir() throws java.rmi.RemoteException;

	public ArrayList<String> listaInicial() throws java.rmi.RemoteException;
}

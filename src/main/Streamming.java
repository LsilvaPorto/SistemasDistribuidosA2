package main;

import java.util.ArrayList;

public interface Streamming extends java.rmi.Remote {

	public void inserir(String musica) throws java.rmi.RemoteException;

	public void remover(String musica) throws java.rmi.RemoteException;

	public ArrayList<String> exibir() throws java.rmi.RemoteException;

	public boolean getPosso(long id) throws java.rmi.RemoteException;
	
	public boolean getPosso2(long id) throws java.rmi.RemoteException;

	public void setIdPlayer(long id) throws java.rmi.RemoteException;

	public long getIdPlayer() throws java.rmi.RemoteException;

	String returnList(long id) throws java.rmi.RemoteException;

	public boolean ListaMudou() throws java.rmi.RemoteException;
	
	public boolean checkList() throws java.rmi.RemoteException;
	
	public void confirmaLista(boolean salve, long cliente_id) throws java.rmi.RemoteException;
	
	public void reset() throws java.rmi.RemoteException;
	
	public int getI() throws java.rmi.RemoteException;

	public void setI() throws java.rmi.RemoteException;

}

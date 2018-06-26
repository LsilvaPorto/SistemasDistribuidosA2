package main;

import java.util.ArrayList;

public interface Streamming extends java.rmi.Remote {

	public void inserir(String musica) throws java.rmi.RemoteException;

	public void remover(String musica) throws java.rmi.RemoteException;

	public ArrayList<String> exibir() throws java.rmi.RemoteException;

	public boolean getPosso(long id) throws java.rmi.RemoteException;

	public void setPosso(boolean status) throws java.rmi.RemoteException;

	public boolean id(long id) throws java.rmi.RemoteException;

	public void setId(long id) throws java.rmi.RemoteException;

	public String checkList(ArrayList lista) throws java.rmi.RemoteException;

	public void setIdPlayer(long id) throws java.rmi.RemoteException;

	public long getIdPlayer() throws java.rmi.RemoteException;

}

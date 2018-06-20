package main;

import java.util.ArrayList;

public interface Streamming extends java.rmi.Remote{

	public void inserir(String musica) throws java.rmi.RemoteException;

	public void remover(String musica) throws java.rmi.RemoteException;

	public ArrayList<String> exibir() throws java.rmi.RemoteException;
	
	public boolean getPosso() throws java.rmi.RemoteException;
	
	public void setPosso(boolean status) throws java.rmi.RemoteException;

	public int getId() throws java.rmi.RemoteException;

	public void setId(int id) throws java.rmi.RemoteException;

}


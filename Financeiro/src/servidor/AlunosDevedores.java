package servidor;

import interfaceservidor.IAlunosDevedores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.BancoDados;
import entidade.Aluno;

@SuppressWarnings("serial")
public class AlunosDevedores extends UnicastRemoteObject implements IAlunosDevedores {

	public AlunosDevedores() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Aluno> listaDevedores() throws RemoteException {
		// TODO Auto-generated method stub
		return BancoDados.listadevedores;
	}

}

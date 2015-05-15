package aplicacao;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import servidor.AlunosDevedores;
import dao.BancoDados;
import entidade.Aluno;
import entidade.Mensalidade;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Aluno 1
		Aluno al1 = new Aluno("Mauro", "SI2015012", "Rua das Casas Azui", "65051234", 40);
		Mensalidade m1al1 = new Mensalidade(2, 3, 2014, true);
		Mensalidade m2al1 = new Mensalidade(6, 6, 2014, true);
		ArrayList<Mensalidade> listaal1 = new ArrayList<Mensalidade>();
		listaal1.add(m1al1);
		listaal1.add(m2al1);
		al1.setMensalidadesemaberto(listaal1);
		//Aluno 2
		Aluno al2 = new Aluno("Pedro", "DI2014065", "Rua do Norte, Centro", "65021064", 27);
		Mensalidade m1al2 = new Mensalidade(1, 2, 2014, true);
		ArrayList<Mensalidade> listaal2 = new ArrayList<Mensalidade>();
		listaal2.add(m1al2);
		al2.setMensalidadesemaberto(listaal2);
		//Criacao do Banco
		BancoDados bd = new BancoDados();
		bd.salvar(al1);
		bd.salvar(al2);
		//Registrar o Servidor de Nomes
		try {
			LocateRegistry.createRegistry(1099);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//Criar o objeto Servidor
			AlunosDevedores ald = new AlunosDevedores();
			Naming.rebind("//localhost/servicofinanceiro", ald);
			System.out.println("Servidor esta registrado...");
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

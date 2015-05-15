package dao;

import entidade.Aluno;

import java.util.ArrayList;

public class BancoDados {
	public static final ArrayList<Aluno> listadevedores = new ArrayList<Aluno>();
	
	public void salvar(Aluno a){
		listadevedores.add(a);
	}
}

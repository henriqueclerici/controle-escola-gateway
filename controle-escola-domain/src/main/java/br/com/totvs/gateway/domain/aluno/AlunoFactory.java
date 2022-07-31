package br.com.totvs.gateway.domain.aluno;

import br.com.totvs.gateway.application.aluno.AlunoCommand;

public class AlunoFactory {
	
	private AlunoFactory() {
		super();
	}
	
	public static AlunoFactory builder() {
		return new AlunoFactory();
	}
	
	public Aluno criarAluno(AlunoCommand command) {
		Aluno aluno = new Aluno();
		aluno.setCpf(command.getCpf());
		aluno.setId(command.getId());
		aluno.setIdade(command.getIdade());
		aluno.setNome(command.getNome());
		return aluno;
		
	}

}

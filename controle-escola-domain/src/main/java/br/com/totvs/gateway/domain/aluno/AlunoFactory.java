package br.com.totvs.gateway.domain.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.totvs.gateway.application.aluno.AlunoCommand;
import br.com.totvs.gateway.application.turma.TurmaCommand;
import br.com.totvs.gateway.domain.turma.Turma;
import br.com.totvs.gateway.domain.turma.TurmaFactory;

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
	//	aluno.setTurma(criarListaTurma(command.getTurmaCommand()));
		return aluno;
		
	}
	
	
	public List<Turma> criarListaTurma(List<TurmaCommand> listaTurmaCommand) {
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		if (null != listaTurmaCommand && !listaTurmaCommand.isEmpty()) {
			listaTurmaCommand.forEach(command -> {
				turmas.add(TurmaFactory.builder().criarTurma(command));
			});

		}

		return turmas;

	}

}

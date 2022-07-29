package br.com.totvs.gateway.domain.turma;

import java.util.ArrayList;
import java.util.List;

import br.com.totvs.gateway.application.aluno.AlunoCommand;
import br.com.totvs.gateway.application.turma.TurmaCommand;
import br.com.totvs.gateway.domain.aluno.Aluno;
import br.com.totvs.gateway.domain.aluno.AlunoFactory;

public class TurmaFactory {

	public TurmaFactory() {
		super();
	}

	public static TurmaFactory builder() {
		return new TurmaFactory();
	}

	public Turma criarTurma(TurmaCommand command) {
		Turma turma = new Turma();
		turma.setId(command.getId());
		turma.setDisciplina(command.getDisciplina());
		turma.setAluno(criarListaAluno(command.getAlunosCommand()));
		return turma;

	}

	public List<Aluno> criarListaAluno(List<AlunoCommand> listaAlunoCommand) {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		if (null != listaAlunoCommand && !listaAlunoCommand.isEmpty()) {
			listaAlunoCommand.forEach(command -> {
				alunos.add(AlunoFactory.builder().criarAluno(command));
			});

		}

		return alunos;

	}

}

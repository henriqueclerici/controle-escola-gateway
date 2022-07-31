package br.com.totvs.gateway.domain.turma;

import br.com.totvs.gateway.application.turma.TurmaCommand;

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
		return turma;

	}
	

}

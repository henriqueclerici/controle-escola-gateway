package br.com.totvs.gateway.builder;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.application.turma.TurmaCommand;
import br.com.totvs.gateway.dto.TurmaRequest;

public class TurmaCommandBuilder {
	
	private TurmaCommandBuilder() {
		
	}
	
	public static TurmaCommandBuilder builder() {
		return new TurmaCommandBuilder();
	}
	
	
	public TurmaCommand build(TurmaRequest turmaRequest) {
		return TurmaCommand.builder()
		.id(turmaRequest.getId())		
		.dataInicio(turmaRequest.getDataInicio())
		.dataLimiteInscricao(turmaRequest.getDataLimiteInscricao())
		.disciplina(turmaRequest.getDisciplina())
		.alunosCommand(AlunoCommandBuilder.builder().build(turmaRequest.getAlunos()))
		.build();
		
		
	}
	
	
	public List<TurmaCommand> build(List<TurmaRequest> turmas) {

		return FluentIterable.from(turmas).transform(new Function<TurmaRequest, TurmaCommand>() {
			@Override
			public TurmaCommand apply(TurmaRequest input) {
				return build(input);
			}
		}).toList();
	}
	
	 

}

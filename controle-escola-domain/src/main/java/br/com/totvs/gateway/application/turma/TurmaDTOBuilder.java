package br.com.totvs.gateway.application.turma;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.application.aluno.AlunoDTOBuilder;
import br.com.totvs.gateway.domain.turma.Turma;

public class TurmaDTOBuilder {
	
	private TurmaDTOBuilder() {
		
	}
	
	public static TurmaDTOBuilder builder() {
		return new TurmaDTOBuilder();
	}
	
	
	public TurmaDTO build(Turma turma) {
		return TurmaDTO.builder()
		.alunosDTO(AlunoDTOBuilder.builder().build(turma.getAluno()))
		.disciplina(turma.getDisciplina())
		.build();
		
		
	}
	
	
	public List<TurmaDTO> build(List<Turma> Turmas) {
		
		return FluentIterable.from(Turmas).transform(new Function<Turma, TurmaDTO>() {

			@Override
			public TurmaDTO apply(Turma input) {
				return build(input);
			}
		}).toList();
		
	
	}

	
	
	 

}

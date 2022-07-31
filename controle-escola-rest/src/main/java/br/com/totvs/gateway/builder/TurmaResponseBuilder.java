package br.com.totvs.gateway.builder;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.application.turma.TurmaDTO;
import br.com.totvs.gateway.dto.TurmaResponse;

public class TurmaResponseBuilder {
	
	private TurmaResponseBuilder() {
		
	}
	
	public static TurmaResponseBuilder builder() {
		return new TurmaResponseBuilder();
	}
	
	
	public TurmaResponse build(TurmaDTO turmaDTO) {
		return TurmaResponse.builder()
	    .id(turmaDTO.getId())
		.disciplina(turmaDTO.getDisciplina())
		.build();
		
		
	}
	
	
	public List<TurmaResponse> build(List<TurmaDTO> turmas) {

		return FluentIterable.from(turmas).transform(new Function<TurmaDTO, TurmaResponse>() {
			@Override
			public TurmaResponse apply(TurmaDTO input) {
				return build(input);
			}
		}).toList();
	}
	
	 

}

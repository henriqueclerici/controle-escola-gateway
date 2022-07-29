package br.com.totvs.gateway.builder;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.application.MatricularAlunoDTO;
import br.com.totvs.gateway.dto.MatricularAlunoRequest;

public class MatriculaAlunoDTOBuilder {
	
	private MatriculaAlunoDTOBuilder() {
		
	}
	
	public static MatriculaAlunoDTOBuilder builder() {
		return new MatriculaAlunoDTOBuilder();
	}
	
	
	public MatricularAlunoDTO build(MatricularAlunoRequest matricularAlunoRequest) {
		return MatricularAlunoDTO.builder()
		 .id(matricularAlunoRequest.getId())
		 .listaTurma(TurmaCommandBuilder.builder().build(matricularAlunoRequest.getListaTurma()))
		 .build();
		
		
	}
	
	
	public List<MatricularAlunoDTO> build(List<MatricularAlunoRequest> turmas) {

		return FluentIterable.from(turmas).transform(new Function<MatricularAlunoRequest, MatricularAlunoDTO>() {
			@Override
			public MatricularAlunoDTO apply(MatricularAlunoRequest input) {
				return build(input);
			}
		}).toList();
	}
	
	 

}

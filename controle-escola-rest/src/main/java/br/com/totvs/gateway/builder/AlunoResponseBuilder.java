package br.com.totvs.gateway.builder;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.application.aluno.AlunoDTO;
import br.com.totvs.gateway.dto.AlunoResponse;

public class AlunoResponseBuilder {
	
	private AlunoResponseBuilder() {
		
	}
	
	public static AlunoResponseBuilder builder() {
		return new AlunoResponseBuilder();
	}
	
	
	public AlunoResponse build(AlunoDTO alunoDTO) {
		return AlunoResponse.builder()
		.cpf(alunoDTO.getCpf())
		.id(alunoDTO.getId())
		.idade(alunoDTO.getIdade())
		.nome(alunoDTO.getNome())
		.listaTurma(TurmaResponseBuilder.builder().build(alunoDTO.getTurma()))
		.build();
		
		
	}
	
	
	public List<AlunoResponse> build(List<AlunoDTO> turmas) {

		return FluentIterable.from(turmas).transform(new Function<AlunoDTO, AlunoResponse>() {
			@Override
			public AlunoResponse apply(AlunoDTO input) {
				return build(input);
			}
		}).toList();
	}
	
	 

}

package br.com.totvs.gateway.builder;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.application.SecretariaAlunoDTO;
import br.com.totvs.gateway.dto.SecretariaAlunoResponse;

public class SecretariaAlunoResponseBuilder {
	
	private SecretariaAlunoResponseBuilder() {
		
	}
	
	public static SecretariaAlunoResponseBuilder builder() {
		return new SecretariaAlunoResponseBuilder();
	}
	
	
	public SecretariaAlunoResponse build(SecretariaAlunoDTO secretariaAlunoDTO) {
		return SecretariaAlunoResponse.builder()
		.cpfAluno(secretariaAlunoDTO.getCpfAluno())
		.idAluno(secretariaAlunoDTO.getIdAluno())
		.nomeAluno(secretariaAlunoDTO.getCpfAluno())
		.build();
		
		
	}
	
	
	public List<SecretariaAlunoResponse> build(List<SecretariaAlunoDTO> SecretariaAlunoDTOs) {
		
		return FluentIterable.from(SecretariaAlunoDTOs).transform(new Function<SecretariaAlunoDTO, SecretariaAlunoResponse>() {

			@Override
			public SecretariaAlunoResponse apply(SecretariaAlunoDTO input) {
				return build(input);
			}
		}).toList();
		
	
	}

	
	
	 

}

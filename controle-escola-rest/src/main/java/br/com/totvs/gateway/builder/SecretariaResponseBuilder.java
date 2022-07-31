package br.com.totvs.gateway.builder;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.application.SecretariaDTO;
import br.com.totvs.gateway.dto.SecretariaResponse;

public class SecretariaResponseBuilder {
	
	private SecretariaResponseBuilder() {
		
	}
	
	public static SecretariaResponseBuilder builder() {
		return new SecretariaResponseBuilder();
	}
	
	
	public SecretariaResponse build(SecretariaDTO secretariaDTO) {
		return SecretariaResponse.builder()
		.disciplina(secretariaDTO.getDisciplina())
		.idTurma(secretariaDTO.getIdTurma())
		.listaSecretariaAlunoResponse(SecretariaAlunoResponseBuilder.builder().build(secretariaDTO.getListaSecretariaAlunoDTO()))
		.build();
		
		
	}
	
	
	public List<SecretariaResponse> build(List<SecretariaDTO> SecretariaDTOs) {
		
		return FluentIterable.from(SecretariaDTOs).transform(new Function<SecretariaDTO, SecretariaResponse>() {

			@Override
			public SecretariaResponse apply(SecretariaDTO input) {
				return build(input);
			}
		}).toList();
		
	
	}

	
	
	 

}
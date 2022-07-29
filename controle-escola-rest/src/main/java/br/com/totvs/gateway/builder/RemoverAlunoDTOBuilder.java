package br.com.totvs.gateway.builder;

import br.com.totvs.gateway.application.RemoverAlunoDTO;
import br.com.totvs.gateway.dto.RemoverAlunoRequest;

public class RemoverAlunoDTOBuilder {
	
	private RemoverAlunoDTOBuilder() {
		
	}
	
	public static RemoverAlunoDTOBuilder builder() {
		return new RemoverAlunoDTOBuilder();
	}
	
	
	public RemoverAlunoDTO build(RemoverAlunoRequest removerRequest) {
		return RemoverAlunoDTO.builder()
		 .idAluno(removerRequest.getIdAluno())
		 .idTurma(removerRequest.getIdTurma())
		 .build();
		
		
	}
	

	
	 

}

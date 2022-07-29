package br.com.totvs.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoverAlunoRequest {
	
	private Long idAluno;

	private Long idTurma;

}

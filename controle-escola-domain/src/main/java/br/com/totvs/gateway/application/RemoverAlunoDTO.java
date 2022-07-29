package br.com.totvs.gateway.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoverAlunoDTO {
	
	private Long idAluno;

	private Long idTurma;

}

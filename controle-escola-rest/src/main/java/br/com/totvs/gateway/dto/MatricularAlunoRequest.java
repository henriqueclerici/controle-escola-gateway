package br.com.totvs.gateway.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatricularAlunoRequest {
	
	private Long id;

	private List<TurmaRequest> listaTurma;

}

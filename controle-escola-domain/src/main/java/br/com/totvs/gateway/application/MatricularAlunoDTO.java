package br.com.totvs.gateway.application;

import java.util.List;

import br.com.totvs.gateway.application.turma.TurmaCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatricularAlunoDTO {
	
	private Long id;

	private List<TurmaCommand> listaTurma;

}

package br.com.totvs.gateway.application.turma;

import java.util.List;

import br.com.totvs.gateway.application.aluno.AlunoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDTO {
	
	private Long id;

	private String disciplina;
	
	private List<AlunoDTO> alunosDTO;

}

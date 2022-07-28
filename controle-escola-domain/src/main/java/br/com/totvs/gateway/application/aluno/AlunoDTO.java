package br.com.totvs.gateway.application.aluno;

import java.util.List;

import br.com.totvs.gateway.application.turma.TurmaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

	private Long id;

	private String cpf;

	private String nome;

	private Long idade;

	//private List<TurmaDTO> turma;

}

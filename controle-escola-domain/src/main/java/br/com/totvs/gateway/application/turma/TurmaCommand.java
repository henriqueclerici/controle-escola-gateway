package br.com.totvs.gateway.application.turma;

import java.util.Date;
import java.util.List;

import br.com.totvs.gateway.application.aluno.AlunoCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurmaCommand {
	
	private Long id;

	private String disciplina;

	private Date dataInicio;

	private Date dataLimiteInscricao;

}

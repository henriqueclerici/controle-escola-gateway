package br.com.totvs.gateway.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaRequest {
	
	private Long id;
	
	private String disciplina;
	
	private Date dataInicio;
	
	private Date dataLimiteInscricao;
	
	private List<AlunoRequest> alunos = new ArrayList<AlunoRequest>();

}

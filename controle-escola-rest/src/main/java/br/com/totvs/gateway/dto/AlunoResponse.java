package br.com.totvs.gateway.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResponse {
	
	private Long id;
	
	private String cpf;
	
	private String nome;
	
	private Long idade;
	
	@JsonInclude(Include.NON_NULL)
	private List<TurmaResponse> listaTurma;
	

	
	

}

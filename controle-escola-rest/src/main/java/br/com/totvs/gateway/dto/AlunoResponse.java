package br.com.totvs.gateway.dto;

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
	

	
	

}

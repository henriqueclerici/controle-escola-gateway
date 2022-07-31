package br.com.totvs.gateway.application;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecretariaDTO {
	
    private Long idTurma;
	
	private String disciplina;
	
	private List<SecretariaAlunoDTO> listaSecretariaAlunoDTO;


}

package br.com.totvs.gateway.application;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.domain.turma.Turma;

public class SecretariaDTOBuilder {
	
	private SecretariaDTOBuilder() {
		
	}
	
	public static SecretariaDTOBuilder builder() {
		return new SecretariaDTOBuilder();
	}
	
	
	public SecretariaDTO build(Turma turma) {
		return SecretariaDTO.builder()
		.disciplina(turma.getDisciplina())
		.idTurma(turma.getId())
		.listaSecretariaAlunoDTO(SecretariaAlunoDTOBuilder.builder().build(turma.getAluno()))
		.build();
		
		
	}
	
	
	public List<SecretariaDTO> build(List<Turma> Turmas) {
		
		return FluentIterable.from(Turmas).transform(new Function<Turma, SecretariaDTO>() {

			@Override
			public SecretariaDTO apply(Turma input) {
				return build(input);
			}
		}).toList();
		
	
	}

	
	
	 

}

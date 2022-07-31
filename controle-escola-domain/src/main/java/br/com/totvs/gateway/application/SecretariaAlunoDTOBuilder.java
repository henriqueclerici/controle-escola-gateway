package br.com.totvs.gateway.application;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.domain.aluno.Aluno;

public class SecretariaAlunoDTOBuilder {
	
	private SecretariaAlunoDTOBuilder() {
		
	}
	
	public static SecretariaAlunoDTOBuilder builder() {
		return new SecretariaAlunoDTOBuilder();
	}
	
	
	public SecretariaAlunoDTO build(Aluno aluno) {
		return SecretariaAlunoDTO.builder()
		.cpfAluno(aluno.getCpf())
		.idAluno(aluno.getId())
		.nomeAluno(aluno.getNome())
		.build();
		
		
	}
	
	
	public List<SecretariaAlunoDTO> build(List<Aluno> Alunos) {
		
		return FluentIterable.from(Alunos).transform(new Function<Aluno, SecretariaAlunoDTO>() {

			@Override
			public SecretariaAlunoDTO apply(Aluno input) {
				return build(input);
			}
		}).toList();
		
	
	}

	
	
	 

}

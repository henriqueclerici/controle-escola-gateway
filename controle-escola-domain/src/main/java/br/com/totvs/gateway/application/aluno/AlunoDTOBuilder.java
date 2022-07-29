package br.com.totvs.gateway.application.aluno;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.application.turma.TurmaDTOBuilder;
import br.com.totvs.gateway.domain.aluno.Aluno;

public class AlunoDTOBuilder {
	
	private AlunoDTOBuilder() {
		
	}
	
	public static AlunoDTOBuilder builder() {
		return new AlunoDTOBuilder();
	}
	
	
	public AlunoDTO build(Aluno aluno) {
		return AlunoDTO.builder()
		.cpf(aluno.getCpf())
		.id(aluno.getId())
		.idade(aluno.getIdade())
		.nome(aluno.getNome())
		.turma(TurmaDTOBuilder.builder().build(aluno.getTurma()))
		.build();
		
		
	}
	
	
	public List<AlunoDTO> build(List<Aluno> alunos) {
		
		return FluentIterable.from(alunos).transform(new Function<Aluno, AlunoDTO>() {

			@Override
			public AlunoDTO apply(Aluno input) {
				return build(input);
			}
		}).toList();
		
	
	}

	
	
	 

}

package br.com.totvs.gateway.builder;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

import br.com.totvs.gateway.application.aluno.AlunoCommand;
import br.com.totvs.gateway.dto.AlunoRequest;

public class AlunoCommandBuilder {
	
	private AlunoCommandBuilder() {
		
	}
	
	public static AlunoCommandBuilder builder() {
		return new AlunoCommandBuilder();
	}
	
	
	public AlunoCommand build(AlunoRequest alunoRequest) {
		if (null == alunoRequest.getCpf()) {
			throw new IllegalArgumentException("Favor informar o CPF");
		} else if (null == alunoRequest.getNome()) {
			throw new IllegalArgumentException("Favor informar o Nome");
		} else if (null == alunoRequest.getIdade()) {
			throw new IllegalArgumentException("Favor informar a Idade");
		}
		
		return AlunoCommand.builder()
		.cpf(alunoRequest.getCpf())
		.id(alunoRequest.getId())
		.idade(alunoRequest.getIdade())
		.nome(alunoRequest.getNome())
		.build();
		
		
	}
	
	
	public List<AlunoCommand> build(List<AlunoRequest> turmas) {

		return FluentIterable.from(turmas).transform(new Function<AlunoRequest, AlunoCommand>() {
			@Override
			public AlunoCommand apply(AlunoRequest input) {
				return build(input);
			}
		}).toList();
	}
	
	 

}

package br.com.totvs.gateway.application.aluno;

import java.util.List;

import br.com.totvs.gateway.application.exception.ControleEscolaException;

public interface AlunoFacade {
	
	public AlunoDTO cadastrarAluno(AlunoCommand command) throws ControleEscolaException;
	
	public List<AlunoDTO> listarAlunos() throws ControleEscolaException;

	public void excluirAluno();

}

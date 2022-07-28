package br.com.totvs.gateway.domain.aluno;

import java.util.List;

import br.com.totvs.gateway.application.exception.ControleEscolaException;

public interface AlunoService {

	public void cadastrarAluno(Aluno aluno) throws ControleEscolaException;

	public List<Aluno> listarAlunos() throws ControleEscolaException;

	public void excluirAluno();

}

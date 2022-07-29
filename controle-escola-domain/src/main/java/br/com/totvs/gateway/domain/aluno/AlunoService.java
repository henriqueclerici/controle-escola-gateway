package br.com.totvs.gateway.domain.aluno;

import java.util.List;

import br.com.totvs.gateway.application.exception.ControleEscolaException;
import br.com.totvs.gateway.domain.turma.Turma;

public interface AlunoService {

	public void cadastrarAluno(Aluno aluno) throws ControleEscolaException;

	public List<Aluno> listarAlunos() throws ControleEscolaException;

	public void excluirAluno() throws ControleEscolaException;

	public Aluno alterarAluno(Aluno aluno) throws ControleEscolaException;

	public Aluno buscarAluno(Long id) throws ControleEscolaException;

	public void adicionarTurma(List<Turma> turmas, Aluno aluno) throws ControleEscolaException;

}

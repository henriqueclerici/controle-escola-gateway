package br.com.totvs.gateway.domain.turma;

import java.util.List;

import br.com.totvs.gateway.application.exception.ControleEscolaException;
import br.com.totvs.gateway.domain.aluno.Aluno;

public interface TurmaService {

	void cadastrarTurma(Turma turma) throws ControleEscolaException;

	Turma alterarTurma(Turma turma) throws ControleEscolaException;

	List<Turma> listarTurmas() throws ControleEscolaException;

	void excluirTurma() throws ControleEscolaException;

	List<Turma> buscarTurmas(List<Long> ids) throws ControleEscolaException;

	Turma buscarTurmaRemoverAluno(Long idTurma, Aluno aluno) throws ControleEscolaException;

	void adicionarAluno(List<Turma> turmas, Aluno aluno) throws ControleEscolaException;
}

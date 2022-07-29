package br.com.totvs.gateway.domain.turma;

import java.util.List;

import br.com.totvs.gateway.application.exception.ControleEscolaException;

public interface TurmaService {

	void cadastrarTurma(Turma turma) throws ControleEscolaException;

	Turma alterarTurma(Turma turma) throws ControleEscolaException;

	List<Turma> listarTurmas() throws ControleEscolaException;

	void excluirTurma() throws ControleEscolaException;

}

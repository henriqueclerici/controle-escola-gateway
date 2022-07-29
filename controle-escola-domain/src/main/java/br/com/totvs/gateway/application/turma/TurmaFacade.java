package br.com.totvs.gateway.application.turma;

import java.util.List;

import br.com.totvs.gateway.application.exception.ControleEscolaException;

public interface TurmaFacade {

	TurmaDTO cadastrarTurma(TurmaCommand turmaCommand) throws ControleEscolaException;

	TurmaDTO alterarTurma(TurmaCommand turmaCommand) throws ControleEscolaException;

	List<TurmaDTO> listarTurmas() throws ControleEscolaException;

	void excluirTurmas() throws ControleEscolaException;

}

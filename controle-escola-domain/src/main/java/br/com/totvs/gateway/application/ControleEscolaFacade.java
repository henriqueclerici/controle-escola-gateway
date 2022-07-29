package br.com.totvs.gateway.application;

import java.util.List;

import br.com.totvs.gateway.application.aluno.AlunoDTO;
import br.com.totvs.gateway.application.exception.ControleEscolaException;
import br.com.totvs.gateway.application.turma.TurmaDTO;

public interface ControleEscolaFacade {

	AlunoDTO matricular(MatricularAlunoDTO build) throws ControleEscolaException;

	TurmaDTO removerAluno(RemoverAlunoDTO build) throws ControleEscolaException;

	List<TurmaDTO> buscarTurmaDoAluno(Long id) throws ControleEscolaException;

}

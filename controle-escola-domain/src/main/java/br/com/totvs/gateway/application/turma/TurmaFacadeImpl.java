package br.com.totvs.gateway.application.turma;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.gateway.application.aluno.AlunoFacadeImp;
import br.com.totvs.gateway.application.exception.ControleEscolaException;
import br.com.totvs.gateway.domain.turma.Turma;
import br.com.totvs.gateway.domain.turma.TurmaFactory;
import br.com.totvs.gateway.domain.turma.TurmaService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Getter
@Slf4j
public class TurmaFacadeImpl implements TurmaFacade {

	private final TurmaService service;

	@Autowired
	public TurmaFacadeImpl(final TurmaService service) {
		this.service = service;
	}

	@Override
	@Transactional
	public TurmaDTO cadastrarTurma(TurmaCommand turmaCommand) throws ControleEscolaException {
		log.info("Iniciou a inclusão de uma turma", TurmaFacadeImpl.class);
		try {
			Turma turma = TurmaFactory.builder().criarTurma(turmaCommand);
			service.cadastrarTurma(turma);
			return TurmaDTOBuilder.builder().build(turma);
		} catch (Exception e) {
			log.error("Erro ao buscar uma turma");
			throw new IllegalArgumentException("Erro ao buscar uma turma", e);

		}
	}

	@Override
	@Transactional
	public TurmaDTO alterarTurma(TurmaCommand turmaCommand) throws ControleEscolaException {
		log.info("Iniciou alteração de uma turma");
		try {
			Turma turma = TurmaFactory.builder().criarTurma(turmaCommand);
			return TurmaDTOBuilder.builder().build(getService().alterarTurma(turma));
		} catch (Exception e) {
			log.error("Erro ao alterar uma turma", e);
			throw new IllegalArgumentException("Erro ao alterar uma turma", e);
		}
	}

	@Override
	public List<TurmaDTO> listarTurmas() throws ControleEscolaException {
		log.info("Iniciou a busca das turmas");
		try {
			List<Turma> listaAluno = service.listarTurmas();
			return TurmaDTOBuilder.builder().build(listaAluno);
		} catch (Exception e) {
			log.error("Erro ao de buscar as turmas", e);
			throw new IllegalArgumentException("Erro ao de buscar as turmas", e);

		}
	}

	@Override
	@Transactional
	public void excluirTurmas() throws ControleEscolaException {
		log.info("Iniciou a exclusão das turmas", TurmaFacadeImpl.class);
		try {
			service.excluirTurma();
		} catch (Exception e) {
			log.error("Erro ao tentar excluir as turmas", e);
			throw new IllegalArgumentException("Erro ao tentar excluir as turmas", e);

		}

	}

}

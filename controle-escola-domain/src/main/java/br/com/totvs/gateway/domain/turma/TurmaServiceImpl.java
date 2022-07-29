package br.com.totvs.gateway.domain.turma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.gateway.application.exception.ControleEscolaException;
import br.com.totvs.gateway.infra.repositoy.TurmaRepository;
import lombok.Getter;

@Service
@Getter
public class TurmaServiceImpl implements TurmaService {
	
	private final TurmaRepository repository;

	@Autowired
	public TurmaServiceImpl(TurmaRepository repository) {
		this.repository = repository;
	}

	@Override
	public void cadastrarTurma(Turma turma) throws ControleEscolaException {
		getRepository().save(turma);

	}

	@Override
	public Turma alterarTurma(Turma turma) throws ControleEscolaException {
		return getRepository().save(turma);
	}

	@Override
	public List<Turma> listarTurmas() throws ControleEscolaException {
		return getRepository().findAll();
	}

	@Override
	public void excluirTurma() throws ControleEscolaException {
		getRepository().deleteAll();

	}

}

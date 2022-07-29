package br.com.totvs.gateway.domain.turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.gateway.application.exception.ControleEscolaException;
import br.com.totvs.gateway.domain.aluno.Aluno;
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

	@Override
	public List<Turma> buscarTurmas(List<Long> ids) throws ControleEscolaException {
		List<Turma> listaTurma = new ArrayList<Turma>();
		for (Long id : ids) {
			Optional<Turma> optional = getRepository().findById(id);
			if (optional.isPresent()) {
				Turma turma = optional.get();
				listaTurma.add(turma);
			}

		}

		return listaTurma;

	}

	@Override
	public Turma buscarTurmaRemoverAluno(Long idTurma, Aluno aluno) throws ControleEscolaException {
		Optional<Turma> optional = getRepository().findById(idTurma);
		if (!optional.isPresent()) {
			throw new IllegalArgumentException("Não foi possível encontrar a turma do aluno");
		}
		Turma turma = optional.get();
		turma.getAluno().removeIf(a -> a.getId().equals(aluno.getId()));
		return turma;
	}

	@Override
	public void adicionarAluno(List<Turma> turmas, Aluno aluno) throws ControleEscolaException {
		turmas.forEach(t -> {
			try {
				t.adicionarAluno(aluno);
				cadastrarTurma(t);
			} catch (ControleEscolaException e) {
				throw new IllegalArgumentException("Erro ao incluir a turma");
			}
		});
	}

}

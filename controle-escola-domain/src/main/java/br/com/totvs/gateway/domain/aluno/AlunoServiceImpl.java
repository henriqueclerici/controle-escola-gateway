package br.com.totvs.gateway.domain.aluno;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.gateway.application.exception.ControleEscolaException;
import br.com.totvs.gateway.domain.turma.Turma;
import br.com.totvs.gateway.infra.repositoy.AlunoRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Getter
@Slf4j
public class AlunoServiceImpl implements AlunoService {

	private final AlunoRepository alunoRepository;

	@Autowired
	public AlunoServiceImpl(final AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Override
	public void cadastrarAluno(Aluno aluno) throws ControleEscolaException {
		getAlunoRepository().save(aluno);
	}

	@Override
	public List<Aluno> listarAlunos() throws ControleEscolaException {
		return getAlunoRepository().findAll();
	}

	@Override
	public void excluirAluno() {
		getAlunoRepository().deleteAll();

	}

	@Override
	public Aluno alterarAluno(Aluno aluno) throws ControleEscolaException {
		return getAlunoRepository().save(aluno);
	}

	@Override
	public Aluno buscarAluno(Long id) throws ControleEscolaException {
		Optional<Aluno> aluno = getAlunoRepository().findById(id);

		if (!aluno.isPresent()) {
			log.error("Aluno não encontrato");
			throw new IllegalArgumentException("Aluno não encontrato");
		}
		return aluno.get();
	}

	@Override
	public void adicionarTurma(List<Turma> turmas, Aluno aluno) throws ControleEscolaException {
		aluno.adicionarTurma(turmas);
	}

}

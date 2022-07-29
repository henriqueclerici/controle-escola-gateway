package br.com.totvs.gateway.application;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.gateway.application.aluno.AlunoDTO;
import br.com.totvs.gateway.application.aluno.AlunoDTOBuilder;
import br.com.totvs.gateway.application.exception.ControleEscolaException;
import br.com.totvs.gateway.application.turma.TurmaDTO;
import br.com.totvs.gateway.application.turma.TurmaDTOBuilder;
import br.com.totvs.gateway.domain.aluno.Aluno;
import br.com.totvs.gateway.domain.aluno.AlunoService;
import br.com.totvs.gateway.domain.turma.Turma;
import br.com.totvs.gateway.domain.turma.TurmaService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Getter
@Slf4j
public class ControleEscolaFacadeImpl implements ControleEscolaFacade {
	
	private final AlunoService alunoService;
	
	private final TurmaService turmaService;

	@Autowired
	public ControleEscolaFacadeImpl(final AlunoService alunoService, final TurmaService turmaService) {
		this.alunoService = alunoService;
		this.turmaService = turmaService;
	}

	@Override
	@Transactional
	public AlunoDTO matricular(MatricularAlunoDTO matriculaAlunoDTO) throws ControleEscolaException {
		log.info("Iniciou a inclusão do aluno", ControleEscolaFacadeImpl.class);
		try {
			Aluno aluno = getAlunoService().buscarAluno(matriculaAlunoDTO.getId());
			List<Turma> turmas = getTurmaService().buscarTurmas(matriculaAlunoDTO.getListaTurma().stream().map(t -> t.getId()).collect(Collectors.toList()));
			getTurmaService().adicionarAluno(turmas, aluno);
			return AlunoDTOBuilder.builder().build(getAlunoService().buscarAluno(matriculaAlunoDTO.getId()));
		} catch (Exception e) {
			log.error("Erro ao buscar um aluno");
			throw new IllegalArgumentException("Erro ao buscar um aluno", e);

		}
	}

	@Override
	@Transactional
	public TurmaDTO removerAluno(RemoverAlunoDTO removerDTO) throws ControleEscolaException {
		log.info("Iniciou a remoção do aluno", ControleEscolaFacadeImpl.class);
		try {
			Aluno aluno = getAlunoService().buscarAluno(removerDTO.getIdAluno());
			Turma turma = getTurmaService().buscarTurmaRemoverAluno(removerDTO.getIdTurma(), aluno);
			getTurmaService().cadastrarTurma(turma);
			return TurmaDTOBuilder.builder().build(turma);
		} catch (Exception e) {
			log.error("Erro ao buscar um aluno");
			throw new IllegalArgumentException("Erro ao buscar um aluno", e);

		}
	}

	@Override
	public List<TurmaDTO> buscarTurmaDoAluno(Long idAluno) throws ControleEscolaException {
		log.info("Iniciou a busca da tumas do aluno", ControleEscolaFacadeImpl.class);
		try {
			Aluno aluno = getAlunoService().buscarAluno(idAluno);
			return TurmaDTOBuilder.builder().build(aluno.getTurma());
		} catch (Exception e) {
			log.error("Erro ao buscar as turmas do aluno");
			throw new IllegalArgumentException("Erro ao buscar as turmas do aluno", e);

		}
	}
	
	

}

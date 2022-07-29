package br.com.totvs.gateway.application.aluno;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.gateway.application.exception.ControleEscolaException;
import br.com.totvs.gateway.domain.aluno.Aluno;
import br.com.totvs.gateway.domain.aluno.AlunoFactory;
import br.com.totvs.gateway.domain.aluno.AlunoService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Getter
public class AlunoFacadeImp implements AlunoFacade {

	private final AlunoService service;

	@Autowired
	public AlunoFacadeImp(final AlunoService service) {
		this.service = service;
	}

	@Override
	@Transactional
	public AlunoDTO cadastrarAluno(AlunoCommand command) throws ControleEscolaException {
		log.info("Iniciou a inclusão do aluno", AlunoFacadeImp.class);
		try {
			Aluno aluno = AlunoFactory.builder().criarAluno(command);
			service.cadastrarAluno(aluno);
			return AlunoDTOBuilder.builder().build(aluno);
		} catch (Exception e) {
			log.error("Erro ao buscar um aluno");
			throw new IllegalArgumentException("Erro ao buscar um aluno", e);

		}
	}

	@Override
	public List<AlunoDTO> listarAlunos() throws ControleEscolaException {
		log.info("Iniciou a busca por todos os alunos", AlunoFacadeImp.class);
		try {
			List<Aluno> listaAluno = service.listarAlunos();
			return AlunoDTOBuilder.builder().build(listaAluno);
		} catch (Exception e) {
			log.error("Erro ao buscar um aluno", e);
			throw new IllegalArgumentException("Erro ao buscar um aluno", e);

		}

	}

	@Override
	public void excluirAluno() throws ControleEscolaException {
		log.info("Iniciou a exclusão de uma aluno", AlunoFacadeImp.class);
		try {
			service.excluirAluno();
		} catch (Exception e) {
			log.error("Erro ao excluir um aluno", e);
			throw new IllegalArgumentException("Erro ao excluir um aluno", e);

		}
	}

	@Override
	@Transactional
	public AlunoDTO alterarAluno(AlunoCommand alunoCommand) throws ControleEscolaException {
		log.info("Iniciou alteração de um usuário");
		try {
			Aluno aluno = AlunoFactory.builder().criarAluno(alunoCommand);
			return AlunoDTOBuilder.builder().build(getService().alterarAluno(aluno));
		} catch (Exception e) {
			log.error("Erro ao alterar um aluno", e);
			throw new IllegalArgumentException("Erro ao alterar um aluno", e);
		}

	}

}

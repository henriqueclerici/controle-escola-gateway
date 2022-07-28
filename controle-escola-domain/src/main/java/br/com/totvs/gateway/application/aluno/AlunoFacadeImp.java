package br.com.totvs.gateway.application.aluno;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totvs.gateway.application.exception.ControleEscolaException;
import br.com.totvs.gateway.domain.aluno.Aluno;
import br.com.totvs.gateway.domain.aluno.AlunoFactory;
import br.com.totvs.gateway.domain.aluno.AlunoService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
		Aluno aluno = AlunoFactory.builder().criarAluno(command);
		service.cadastrarAluno(aluno);
		return AlunoDTOBuilder.builder().build(aluno);
	}

	@Override
	public List<AlunoDTO> listarAlunos() throws ControleEscolaException {
		log.info("Iniciou a busca por todos os alunos", AlunoFacadeImp.class);
		return AlunoDTOBuilder.builder().build(service.listarAlunos());
	}

	@Override
	public void excluirAluno() {
		log.info("Iniciou a exclusão de uma aluno", AlunoFacadeImp.class);
		service.excluirAluno();
		
	}

}

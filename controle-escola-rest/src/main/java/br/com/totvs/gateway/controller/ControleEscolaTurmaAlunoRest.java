package br.com.totvs.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.gateway.application.ControleEscolaFacade;
import br.com.totvs.gateway.application.aluno.AlunoDTO;
import br.com.totvs.gateway.application.turma.TurmaDTO;
import br.com.totvs.gateway.builder.AlunoResponseBuilder;
import br.com.totvs.gateway.builder.MatriculaAlunoDTOBuilder;
import br.com.totvs.gateway.builder.RemoverAlunoDTOBuilder;
import br.com.totvs.gateway.builder.TurmaResponseBuilder;
import br.com.totvs.gateway.dto.AlunoResponse;
import br.com.totvs.gateway.dto.MatricularAlunoRequest;
import br.com.totvs.gateway.dto.RemoverAlunoRequest;
import br.com.totvs.gateway.dto.TurmaResponse;
import br.com.totvs.gateway.exception.ControleEscolaException;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/escola/aluno-turma")
public class ControleEscolaTurmaAlunoRest {
	

	private final ControleEscolaFacade facade;
	
	@Autowired
	public ControleEscolaTurmaAlunoRest(final ControleEscolaFacade facade)  {
		super();
		this.facade = facade;
	}
	
	
	@PostMapping(value = "/matricular")
	public ResponseEntity<AlunoResponse> matricular(@RequestBody MatricularAlunoRequest request) throws ControleEscolaException{
		try {
			log.info("Iniciou a matricula do aluno -> ", request);
			AlunoDTO alunoDto = facade.matricular(MatriculaAlunoDTOBuilder.builder().build(request));
			return ResponseEntity.ok(AlunoResponseBuilder.builder().build(alunoDto));
		} catch (Exception e) {
			// o tratamento da exception poderia ser melhor com retorno para o usuário
			log.error("Erro ao matricular o aluno", e);
			throw new IllegalArgumentException("Erro ao matricular o aluno", e);

		}
		
	}
	
	@PostMapping(value = "/remover-matricula")
	public ResponseEntity<TurmaResponse> removerMatricula(@RequestBody RemoverAlunoRequest request) throws ControleEscolaException{
		try {
			log.info("Iniciou a remoção do aluno -> ", request);
			TurmaDTO turmaDTO = facade.removerAluno(RemoverAlunoDTOBuilder.builder().build(request));
			return ResponseEntity.ok(TurmaResponseBuilder.builder().build(turmaDTO));
		} catch (Exception e) {
			// o tratamento da exception poderia ser melhor com retorno para o usuário
			log.error("Erro ao remover o aluno", e);
			throw new IllegalArgumentException("Erro ao remover o aluno", e);

		}
		
	}
	
	
	@GetMapping(value = "/buscar-turma-alunos/{id}")
	public ResponseEntity<List<TurmaResponse>> buscarTurmaDoAluno(@PathVariable Long id) throws ControleEscolaException{
		try {
			log.info("Iniciou a busca das turmas dos alunos -> ", id);
			List<TurmaDTO> turmaDTO = facade.buscarTurmaDoAluno(id);
			return ResponseEntity.ok(TurmaResponseBuilder.builder().build(turmaDTO));
		} catch (Exception e) {
			// o tratamento da exception poderia ser melhor com retorno para o usuário
			log.error("Erro ao  buscar as turmas dos alunos", e);
			throw new IllegalArgumentException("Erro ao buscar as turmas dos alunos", e);

		}
		
	}
	
	
	

}

package br.com.totvs.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.gateway.application.aluno.AlunoDTO;
import br.com.totvs.gateway.application.turma.TurmaDTO;
import br.com.totvs.gateway.application.turma.TurmaFacade;
import br.com.totvs.gateway.builder.AlunoCommandBuilder;
import br.com.totvs.gateway.builder.AlunoResponseBuilder;
import br.com.totvs.gateway.builder.TurmaCommandBuilder;
import br.com.totvs.gateway.builder.TurmaResponseBuilder;
import br.com.totvs.gateway.dto.AlunoRequest;
import br.com.totvs.gateway.dto.AlunoResponse;
import br.com.totvs.gateway.dto.TurmaRequest;
import br.com.totvs.gateway.dto.TurmaResponse;
import br.com.totvs.gateway.exception.ControleEscolaException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/escola/turma")
@Slf4j
public class ControleEscolaTurmaRest {
	
	private final TurmaFacade facade;
	
	@Autowired
	public ControleEscolaTurmaRest(final TurmaFacade facade) {
		this.facade = facade;
	}
	
	
	
	@PostMapping(value = "/cadastrar")
	@ApiOperation(value = "Método para cadastrar a turma")
	public ResponseEntity<TurmaResponse> cadastrarTurma(@RequestBody TurmaRequest turmaRequest)
			throws ControleEscolaException {
		try {
			log.info("Iniciou a inclusão de uma turma -> ", turmaRequest);
			TurmaDTO turmaDTO = facade.cadastrarTurma(TurmaCommandBuilder.builder().build(turmaRequest));
			return ResponseEntity.ok(TurmaResponseBuilder.builder().build(turmaDTO));
		} catch (Exception e) {
			// o tratamento da exception poderia ser melhor com retorno para a turma
			log.error("Erro na inclusão da turma", e);
			throw new IllegalArgumentException("Erro na inclusão da turma", e);

		}

	}
	
	@PostMapping(value = "/alterar")
	@ApiOperation(value = "Método para alterar a turma")
	public ResponseEntity<TurmaResponse> alterar(@RequestBody TurmaRequest turmaRequest)
			throws ControleEscolaException {
		try {
			log.info("Iniciou a alteração da turma -> ", turmaRequest);
			TurmaDTO turmaDTO = facade.alterarTurma(TurmaCommandBuilder.builder().build(turmaRequest));
			return ResponseEntity.ok(TurmaResponseBuilder.builder().build(turmaDTO));
		} catch (Exception e) {
			log.error("Erro na alteração da turma", e);
			throw new IllegalArgumentException("Erro na alteração da turma", e);

		}

	}
	
	@GetMapping(value = "/listar-turma")
	public ResponseEntity<List<TurmaResponse>> listarTurmas() throws ControleEscolaException{
		try {
			log.info("Iniciou a busca das turmas");
			List<TurmaDTO> turmaDTO = facade.listarTurmas();
			return ResponseEntity.ok(TurmaResponseBuilder.builder().build(turmaDTO));
		} catch (Exception e) {
			log.error("Erro ao buscar as  turmas", e);
			throw new IllegalArgumentException("Erro ao buscar as turmas", e);

		}
		
	}
	
	/** TODO
	 * Poderia fazer uma verificação para não deixar excluir caso ele já estivesse vinculado
	 * @param id
	 * @return
	 * @throws ControleEscolaException
	 */
	@PostMapping(value = "/excluir-turma")
	public ResponseEntity<HttpStatus> excluirTurmas() throws ControleEscolaException{
		try {
			log.info("Iniciou a exclusão das turmas");
		    facade.excluirTurmas();
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Erro ao excluir as turmas", e);
			throw new IllegalArgumentException("Erro ao excluir as turmas", e);

		}
		
	}

}

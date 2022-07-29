package br.com.totvs.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.gateway.application.aluno.AlunoDTO;
import br.com.totvs.gateway.application.aluno.AlunoFacade;
import br.com.totvs.gateway.builder.AlunoCommandBuilder;
import br.com.totvs.gateway.builder.AlunoResponseBuilder;
import br.com.totvs.gateway.dto.AlunoRequest;
import br.com.totvs.gateway.dto.AlunoResponse;
import br.com.totvs.gateway.exception.ControleEscolaException;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/escola/aluno")
@Slf4j
@Getter
public class ControleEscolaAlunoRest {

	private final AlunoFacade facade;

	@Autowired
	public ControleEscolaAlunoRest(final AlunoFacade facade) {
		this.facade = facade;
	}

	@PostMapping(value = "/cadastrar")
	@ApiOperation(value = "Método para cadastrar um aluno")
	public ResponseEntity<AlunoResponse> cadastrarAluno(@RequestBody AlunoRequest alunoRequest)
			throws ControleEscolaException {
		try {
			log.info("Iniciou a inclusão de um aluno -> ", alunoRequest);
			AlunoDTO alunoDto = facade.cadastrarAluno(AlunoCommandBuilder.builder().build(alunoRequest));
			return ResponseEntity.ok(AlunoResponseBuilder.builder().build(alunoDto));
		} catch (Exception e) {
			// o tratamento da exception poderia ser melhor com retorno para o usuário
			log.error("Erro na inclusão do aluno", e);
			throw new IllegalArgumentException("Erro na inclusão do aluno", e);

		}

	}
	
	@PostMapping(value = "/alterar")
	@ApiOperation(value = "Método para alterar um aluno")
	public ResponseEntity<AlunoResponse> alterarAluno(@RequestBody AlunoRequest alunoRequest)
			throws ControleEscolaException {
		try {
			log.info("Iniciou a alteração de um aluno -> ", alunoRequest);
			AlunoDTO alunoDto = facade.alterarAluno(AlunoCommandBuilder.builder().build(alunoRequest));
			return ResponseEntity.ok(AlunoResponseBuilder.builder().build(alunoDto));
		} catch (Exception e) {
			log.error("Erro na inclusão do aluno", e);
			throw new IllegalArgumentException("Erro na inclusão do aluno", e);

		}

	}
	
	@GetMapping(value = "/listar-aluno")
	public ResponseEntity<List<AlunoResponse>> listarAlunos() throws ControleEscolaException{
		try {
			log.info("Iniciou a busca de todos os alunos");
			List<AlunoDTO> alunoDto = facade.listarAlunos();
			return ResponseEntity.ok(AlunoResponseBuilder.builder().build(alunoDto));
		} catch (Exception e) {
			log.error("Erro ao buscar alunos do aluno", e);
			throw new IllegalArgumentException("Erro ao buscar alunos", e);

		}
		
	}
	
	/** TODO
	 * Poderia fazer uma verificação para não deixar excluir caso ele já estivesse vinculado
	 * @param id
	 * @return
	 * @throws ControleEscolaException
	 */
	@PostMapping(value = "/excluir-aluno")
	public ResponseEntity<HttpStatus> excluirAluno() throws ControleEscolaException{
		try {
			log.info("Iniciou a exclusão de um aluno");
		    facade.excluirAluno();
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			log.error("Erro ao excluir um aluno", e);
			throw new IllegalArgumentException("Erro ao excluir um aluno", e);

		}
		
	}

}

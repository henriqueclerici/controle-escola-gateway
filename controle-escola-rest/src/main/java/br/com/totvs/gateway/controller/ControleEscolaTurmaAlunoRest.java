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
import br.com.totvs.gateway.application.SecretariaDTO;
import br.com.totvs.gateway.builder.MatriculaAlunoDTOBuilder;
import br.com.totvs.gateway.builder.RemoverAlunoDTOBuilder;
import br.com.totvs.gateway.builder.SecretariaResponseBuilder;
import br.com.totvs.gateway.dto.MatricularAlunoRequest;
import br.com.totvs.gateway.dto.RemoverAlunoRequest;
import br.com.totvs.gateway.dto.SecretariaResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/escola/aluno-turma")
@Api(value = "Rest Utilizado para realizar rotinas de uma escola")
public class ControleEscolaTurmaAlunoRest {

	private final ControleEscolaFacade facade;

	@Autowired
	public ControleEscolaTurmaAlunoRest(final ControleEscolaFacade facade) {
		super();
		this.facade = facade;
	}

	@PostMapping(value = "/matricular")
	@ApiOperation(value = "Método utilizado para matricular um aluno a uma lista de turma informando seus ids")
	public ResponseEntity<List<SecretariaResponse>> matricular(@RequestBody MatricularAlunoRequest request)
			throws br.com.totvs.gateway.application.exception.ControleEscolaException {

		log.info("Iniciou a matricula do aluno -> ", request);
		List<SecretariaDTO> listSecretariaDTO = facade.matricular(MatriculaAlunoDTOBuilder.builder().build(request));
		return ResponseEntity.ok(SecretariaResponseBuilder.builder().build(listSecretariaDTO));

	}

	@PostMapping(value = "/remover-matricula")
	@ApiOperation(value = "Método utilizado para remover um aluno de um turma, informando seus ids")
	public ResponseEntity<SecretariaResponse> removerMatricula(@RequestBody RemoverAlunoRequest request)
			throws br.com.totvs.gateway.application.exception.ControleEscolaException {

		log.info("Iniciou a remoção do aluno -> ", request);
		SecretariaDTO secretariaDTO = facade.removerAluno(RemoverAlunoDTOBuilder.builder().build(request));
		return ResponseEntity.ok(SecretariaResponseBuilder.builder().build(secretariaDTO));

	}

	@GetMapping(value = "/buscar-turma-alunos/{idAluno}")
	@ApiOperation("Método utlizado para buscar as turmas do aluno utilizando o idAluno ")
	public ResponseEntity<List<SecretariaResponse>> buscarTurmaDoAluno(@PathVariable Long idAluno)
			throws br.com.totvs.gateway.application.exception.ControleEscolaException {
		log.info("Iniciou a busca das turmas dos alunos -> ", idAluno);
		List<SecretariaDTO> listSecretariaDTO = facade.buscarTurmaDoAluno(idAluno);
		return ResponseEntity.ok(SecretariaResponseBuilder.builder().build(listSecretariaDTO));

	}

}

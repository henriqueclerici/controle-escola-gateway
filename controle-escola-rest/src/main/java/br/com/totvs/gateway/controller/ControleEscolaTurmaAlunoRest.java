package br.com.totvs.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.gateway.application.ControleEscolaFacade;
import br.com.totvs.gateway.dto.AlunoResponse;
import br.com.totvs.gateway.dto.MatricularAlunoRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/escola/aluno-turma")
public class ControleEscolaTurmaAlunoRest {
	

	private final ControleEscolaFacade facade;
	
	@Autowired
	public ControleEscolaTurmaAlunoRest(final ControleEscolaFacade facade) {
		super();
		this.facade = facade;
	}
	
	
	
	public ResponseEntity<AlunoResponse> matricular(@RequestBody MatricularAlunoRequest request){
		return null;
		
	}
	 
	
	
	
	
	

}

package br.com.totvs.gateway.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.totvs.gateway.aluno.AlunoFactoryTest;
import br.com.totvs.gateway.application.aluno.AlunoCommand;
import br.com.totvs.gateway.application.aluno.AlunoDTOBuilder;
import br.com.totvs.gateway.application.turma.TurmaCommand;
import br.com.totvs.gateway.application.turma.TurmaDTOBuilder;
import br.com.totvs.gateway.application.turma.TurmaFacade;
import br.com.totvs.gateway.builder.AlunoCommandBuilder;
import br.com.totvs.gateway.builder.TurmaCommandBuilder;
import br.com.totvs.gateway.dto.AlunoRequest;
import br.com.totvs.gateway.dto.TurmaRequest;
import br.com.totvs.gateway.turma.TurmaFactoryTest;

@SpringBootTest
@AutoConfigureMockMvc
public class ControleEscolaTurmaRestTest {

	private static final String TURMA_CONTROLLER = "/escola/turma";
	private static final String TURMA_CADASTRAR = "/cadastrar";
	private static final String TURMA_ALTERAR = "/alterar";
	private static final String TURMA_LISTAR = "/listar-turma";
	private static final String TURMA_EXCLUIR = "/excluir-turma";
	
	

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();
	
	@MockBean
	private TurmaFacade facade;

	@Test
	public void testCadastrarTurmaErroCommand() throws Exception {
		TurmaRequest request = new TurmaRequest();
		request.setDisciplina(null);
		request.setId(null);
		

		this.mockMvc.perform(post(TURMA_CONTROLLER + TURMA_CADASTRAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(request))).andExpect(status().isBadRequest());
	}
	
	
	@Test
	public void testCadastrarTurma() throws Exception {
		TurmaRequest request = new TurmaRequest();
		request.setDisciplina("ti");
		request.setId(null);
		
		TurmaCommand command = TurmaCommandBuilder.builder().build(request);
		
		Mockito.when(facade.cadastrarTurma(command)).thenReturn(TurmaDTOBuilder.builder().build(TurmaFactoryTest.builder().criarTurmaMock()));

		this.mockMvc.perform(post(TURMA_CONTROLLER + TURMA_CADASTRAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(request))).andExpect(status().isOk());
	}
	
	@Test
	public void testAlterarTurma() throws Exception {
		TurmaRequest request = new TurmaRequest();
		request.setDisciplina("ti");
		request.setId(1L);
		
		TurmaCommand command = TurmaCommandBuilder.builder().build(request);
		
		Mockito.when(facade.alterarTurma(command)).thenReturn(TurmaDTOBuilder.builder().build(TurmaFactoryTest.builder().criarTurmaMock()));

		this.mockMvc.perform(post(TURMA_CONTROLLER + TURMA_ALTERAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(request))).andExpect(status().isOk());
	}
	
	
	@Test
	public void testListarTurma() throws Exception {
		
		Mockito.when(facade.listarTurmas()).thenReturn(TurmaDTOBuilder.builder().build(TurmaFactoryTest.builder().criarListaTurmaMock()));

		this.mockMvc.perform(get(TURMA_CONTROLLER + TURMA_LISTAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				).andExpect(status().isOk());
	}
	
	@Test
	public void testRemoverTurma() throws Exception {

		this.mockMvc.perform(post(TURMA_CONTROLLER + TURMA_EXCLUIR)).andExpect(status().isOk());
	}

}

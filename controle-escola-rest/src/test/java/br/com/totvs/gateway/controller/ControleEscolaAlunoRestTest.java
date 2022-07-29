package br.com.totvs.gateway.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import br.com.totvs.gateway.application.aluno.AlunoFacade;
import br.com.totvs.gateway.builder.AlunoCommandBuilder;
import br.com.totvs.gateway.dto.AlunoRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class ControleEscolaAlunoRestTest {

	private static final String ALUNO_CONTROLLER = "/escola/aluno";
	private static final String ALUNO_CADASTRAR = "/cadastrar";
	private static final String ALUNO_ALTERAR = "/alterar";
	private static final String ALUNO_LISTAR = "/listar-aluno";
	private static final String ALUNO_EXCLUIR = "/excluir-aluno";
	
	

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();
	
	@MockBean
	private AlunoFacade facade;

	@Test
	public void testCadastrarAlunoErroCommand() throws Exception {
		AlunoRequest request = new AlunoRequest();
		request.setCpf(null);
		request.setIdade(30L);
		request.setNome("Teste");
		

		this.mockMvc.perform(post(ALUNO_CONTROLLER + ALUNO_CADASTRAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(request))).andExpect(status().isBadRequest());
	}
	
	
	@Test
	public void testCadastrarAluno() throws Exception {
		AlunoRequest request = new AlunoRequest();
		request.setCpf("42769013831");
		request.setIdade(30L);
		request.setNome("Teste");
		
		AlunoCommand command = AlunoCommandBuilder.builder().build(request);
		
		Mockito.when(facade.cadastrarAluno(command)).thenReturn(AlunoDTOBuilder.builder().build(AlunoFactoryTest.builder().criarAlunoMock()));

		this.mockMvc.perform(post(ALUNO_CONTROLLER + ALUNO_CADASTRAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(request))).andExpect(status().isOk());
	}
	
	@Test
	public void testAlterarAluno() throws Exception {
		AlunoRequest request = new AlunoRequest();
		request.setCpf("42769013831");
		request.setIdade(30L);
		request.setNome("Teste");
		
		AlunoCommand command = AlunoCommandBuilder.builder().build(request);
		
		Mockito.when(facade.alterarAluno(command)).thenReturn(AlunoDTOBuilder.builder().build(AlunoFactoryTest.builder().criarAlunoMock()));

		this.mockMvc.perform(post(ALUNO_CONTROLLER + ALUNO_ALTERAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(request))).andExpect(status().isOk());
	}
	
	
	@Test
	public void testListarAluno() throws Exception {
		
		Mockito.when(facade.listarAlunos()).thenReturn(AlunoDTOBuilder.builder().build(AlunoFactoryTest.builder().criarListaAlunoMock()));

		this.mockMvc.perform(get(ALUNO_CONTROLLER + ALUNO_LISTAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				).andExpect(status().isOk());
	}
	
	@Test
	public void testRemoverAluno() throws Exception {

		this.mockMvc.perform(post(ALUNO_CONTROLLER + ALUNO_EXCLUIR)).andExpect(status().isOk());
	}

}

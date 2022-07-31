package br.com.totvs.gateway.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.totvs.gateway.SecretariaFactoryTest;
import br.com.totvs.gateway.aluno.AlunoFactoryTest;
import br.com.totvs.gateway.application.ControleEscolaFacade;
import br.com.totvs.gateway.application.MatricularAlunoDTO;
import br.com.totvs.gateway.application.RemoverAlunoDTO;
import br.com.totvs.gateway.application.aluno.AlunoDTOBuilder;
import br.com.totvs.gateway.application.turma.TurmaDTOBuilder;
import br.com.totvs.gateway.builder.MatriculaAlunoDTOBuilder;
import br.com.totvs.gateway.builder.RemoverAlunoDTOBuilder;
import br.com.totvs.gateway.dto.MatricularAlunoRequest;
import br.com.totvs.gateway.dto.RemoverAlunoRequest;
import br.com.totvs.gateway.dto.TurmaRequest;
import br.com.totvs.gateway.turma.TurmaFactoryTest;

@SpringBootTest
@AutoConfigureMockMvc
public class ControleEscolaTurmaAlunoRestTest {

	private static final String TURMA_ALUNO_CONTROLLER = "/escola/aluno-turma";
	private static final String TURMA_ALUNO_MATRICULAR = "/matricular";
	private static final String TURMA_ALUNO_REMOVER_MATRICULAR = "/remover-matricula";
	private static final String TURMA_ALUNO_BUSCAR = "/buscar-turma-alunos/" + "1";
	
	
	

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper mapper = new ObjectMapper();
	
	@MockBean
	private ControleEscolaFacade facade;
	
	@Test
	public void testMatricularAluno() throws Exception {
		MatricularAlunoRequest request = new MatricularAlunoRequest();
		request.setIdAluno(1L);
		request.setIdTurmas(Arrays.asList(1L));
		MatricularAlunoDTO matricularAlunoDTO = MatriculaAlunoDTOBuilder.builder().build(request);
		Mockito.when(facade.matricular(matricularAlunoDTO)).thenReturn(SecretariaFactoryTest.builder().criarListaSecretariaMock());

		this.mockMvc.perform(post(TURMA_ALUNO_CONTROLLER + TURMA_ALUNO_MATRICULAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(request))).andExpect(status().isOk());
	}
	
	@Test
	public void testRemoverMatricula() throws Exception {
		RemoverAlunoRequest request = new RemoverAlunoRequest();
		request.setIdAluno(1L);
		request.setIdTurma(1L);
		
		RemoverAlunoDTO dto = RemoverAlunoDTOBuilder.builder().build(request);
		
		Mockito.when(facade.removerAluno(dto)).thenReturn(SecretariaFactoryTest.builder().criarSecretariaMock());
		this.mockMvc.perform(post(TURMA_ALUNO_CONTROLLER + TURMA_ALUNO_REMOVER_MATRICULAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(mapper.writeValueAsString(request))).andExpect(status().isOk());
	}
	
	
	@Test
	public void testBuscarTurmaDoAluno() throws Exception {
		
		Mockito.when(facade.buscarTurmaDoAluno(1L)).thenReturn(SecretariaFactoryTest.builder().criarListaSecretariaMock());

		this.mockMvc.perform(get(TURMA_ALUNO_CONTROLLER + TURMA_ALUNO_BUSCAR).contentType(MediaType.APPLICATION_JSON_VALUE)
				).andExpect(status().isOk());
	}
	
	

}

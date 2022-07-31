package br.com.totvs.gateway;

import java.util.List;

import br.com.totvs.gateway.aluno.AlunoFactoryTest;
import br.com.totvs.gateway.application.SecretariaDTO;
import br.com.totvs.gateway.application.SecretariaDTOBuilder;
import br.com.totvs.gateway.domain.turma.Turma;
import br.com.totvs.gateway.turma.TurmaFactoryTest;

public class SecretariaFactoryTest {

	public SecretariaFactoryTest() {
		super();
	}

	public static SecretariaFactoryTest builder() {
		return new SecretariaFactoryTest();
	}

	public SecretariaDTO criarSecretariaMock() {
		Turma turma = TurmaFactoryTest.builder().criarTurmaMock();
		turma.setAluno(AlunoFactoryTest.builder().criarListaAlunoMock());
		return SecretariaDTOBuilder.builder().build(turma);

	}

	public List<SecretariaDTO> criarListaSecretariaMock() {
		List<Turma> listaTurma = TurmaFactoryTest.builder().criarListaTurmaMock();
		listaTurma.forEach(t -> {
			t.setAluno(AlunoFactoryTest.builder().criarListaAlunoMock());
		});

		return SecretariaDTOBuilder.builder().build(listaTurma);

	}

}

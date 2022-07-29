package br.com.totvs.gateway.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.totvs.gateway.domain.aluno.Aluno;

public class AlunoFactoryTest {

	public AlunoFactoryTest() {
		super();
	}
	
   public static AlunoFactoryTest builder() {
	   return new AlunoFactoryTest();
   }
   
   public Aluno criarAlunoMock() {
	   Aluno aluno = new Aluno();
	   aluno.setId(1L);
	   aluno.setCpf("1111111111");
	   aluno.setIdade(30L);
	   aluno.setNome("Teste");
	   return aluno;
	   
   }
   
   public List<Aluno> criarListaAlunoMock() {
	   List<Aluno> listaAluno = new ArrayList<Aluno>();
	   Aluno aluno1 = new Aluno();
	   aluno1.setId(1L);
	   aluno1.setCpf("1111111111");
	   aluno1.setIdade(30L);
	   aluno1.setNome("Teste");
	   listaAluno.add(aluno1);
	   Aluno aluno2 = new Aluno();
	   aluno2.setId(1L);
	   aluno2.setCpf("1111111111");
	   aluno2.setIdade(30L);
	   aluno2.setNome("Teste2");
	   listaAluno.add(aluno2);
	   
	   Aluno aluno3 = new Aluno();
	   aluno2.setId(1L);
	   aluno2.setCpf("1111111111");
	   aluno2.setIdade(30L);
	   aluno2.setNome("Teste3");
	   listaAluno.add(aluno3);
	   
	   
	   return listaAluno;
	   
   }
	
	

}

package br.com.totvs.gateway.turma;

import java.util.ArrayList;
import java.util.List;

import br.com.totvs.gateway.domain.aluno.Aluno;
import br.com.totvs.gateway.domain.turma.Turma;

public class TurmaFactoryTest {

	public TurmaFactoryTest() {
		super();
	}
	
   public static TurmaFactoryTest builder() {
	   return new TurmaFactoryTest();
   }
   
   public Turma criarTurmaMock() {
	   Turma turma = new Turma();
	   turma.setDisciplina("ti");
	   turma.setId(1L);
	   return turma;
	   
   }
   
   public List<Turma> criarListaTurmaMock() {
	   List<Turma> listaTurma = new ArrayList<Turma>();
	   Turma turma1 = new Turma();
	   turma1.setDisciplina("ti");
	   turma1.setId(1L);
	   listaTurma.add(turma1);
	   
	   
	   Turma turma2 = new Turma();
	   turma2.setDisciplina("ti");
	   turma2.setId(1L);
	   listaTurma.add(turma2);
	   
	   return listaTurma;
	   
   }
	
	

}

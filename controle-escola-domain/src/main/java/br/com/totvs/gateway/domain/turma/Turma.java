package br.com.totvs.gateway.domain.turma;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.totvs.gateway.domain.aluno.Aluno;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Long id;

	private String disciplina;

	private Date dataInicio;

	private Date dataLimiteInscricao;

	@ManyToMany
	@JsonIgnore
	@JoinTable(
			name = "aluno_turmas",
			joinColumns = @JoinColumn(name = "turma_id"),
			inverseJoinColumns = @JoinColumn(name = "aluno_id")
			)
	private List<Aluno> alunos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataLimiteInscricao() {
		return dataLimiteInscricao;
	}

	public void setDataLimiteInscricao(Date dataLimiteInscricao) {
		this.dataLimiteInscricao = dataLimiteInscricao;
	}

	public List<Aluno> getAluno() {
		return alunos;
	}

	public void setAluno(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}

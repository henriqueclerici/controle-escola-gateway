package br.com.totvs.gateway.domain.aluno;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.totvs.gateway.domain.turma.Turma;

@Entity
@Table(name = "ALUNO")
public class Aluno {

	@Id
	@GeneratedValue
	private Long id;
	
    @ManyToMany(mappedBy = "alunos")	
	private List<Turma> turma = new ArrayList<>();

	private String cpf;

	private String nome;

	private Long idade;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	

	

}

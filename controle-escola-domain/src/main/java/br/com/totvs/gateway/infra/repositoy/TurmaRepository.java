package br.com.totvs.gateway.infra.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.totvs.gateway.domain.turma.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}

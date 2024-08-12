package cl.praxis.EscuelaRural.model.repositories;

import cl.praxis.EscuelaRural.model.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Integer> {
}

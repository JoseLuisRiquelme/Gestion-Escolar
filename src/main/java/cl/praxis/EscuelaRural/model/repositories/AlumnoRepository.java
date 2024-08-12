package cl.praxis.EscuelaRural.model.repositories;

import cl.praxis.EscuelaRural.model.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno,Integer> {
}

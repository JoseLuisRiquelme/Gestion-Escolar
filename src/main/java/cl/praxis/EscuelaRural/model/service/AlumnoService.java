package cl.praxis.EscuelaRural.model.service;

import cl.praxis.EscuelaRural.model.entities.Alumno;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AlumnoService {
    List<Alumno> findAll();
    Alumno findOne(int id);
    boolean create(Alumno a);
    boolean update(Alumno a);
    boolean delete(int id);
}

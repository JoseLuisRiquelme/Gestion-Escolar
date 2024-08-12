package cl.praxis.EscuelaRural.model.service;

import cl.praxis.EscuelaRural.model.entities.Alumno;
import cl.praxis.EscuelaRural.model.entities.Curso;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CursoService {
    List<Curso> findAll();
    Curso findOne(int id);
    boolean create(Curso c);
    boolean update(Curso c);
    boolean delete(int id);
}

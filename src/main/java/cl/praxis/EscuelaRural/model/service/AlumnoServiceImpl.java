package cl.praxis.EscuelaRural.model.service;

import cl.praxis.EscuelaRural.model.entities.Alumno;
import cl.praxis.EscuelaRural.model.repositories.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlumnoServiceImpl implements AlumnoService {

    AlumnoRepository aRepository;
    public AlumnoServiceImpl(AlumnoRepository aRepository){
        this.aRepository=aRepository;
    }
    @Override
    public List<Alumno> findAll() {
        return aRepository.findAll();
    }

    @Override
    public Alumno findOne(int id) {
        return aRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Alumno a) {
        Alumno result = aRepository.save(a);
        return result!=null;
    }

    @Override
    public boolean update(Alumno a) {
        Alumno result = aRepository.save(a);
        return result!=null;
    }

    @Override
    public boolean delete(int id) {
        boolean exist = aRepository.existsById(id);
        if(exist){
            aRepository.deleteById(id);
        }
        return exist;
    }
}

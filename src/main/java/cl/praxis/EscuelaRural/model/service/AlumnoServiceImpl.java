package cl.praxis.EscuelaRural.model.service;

import cl.praxis.EscuelaRural.model.entities.Alumno;
import cl.praxis.EscuelaRural.model.repositories.AlumnoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AlumnoServiceImpl implements AlumnoService {

    AlumnoRepository aRepository;
    public AlumnoServiceImpl(AlumnoRepository aRepository){
        this.aRepository=aRepository;
    }
    @Transactional
    @Override
    public List<Alumno> findAll() {
        return aRepository.findAll();
    }
    @Transactional
    @Override
    public Alumno findOne(int id) {
        return aRepository.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public boolean create(Alumno a) {
        Alumno result = aRepository.save(a);
        return result!=null;
    }
    @Transactional
    @Override
    public boolean update(Alumno a) {
        Alumno result = aRepository.save(a);
        return result!=null;
    }
    @Transactional
    @Override
    public boolean delete(int id) {
        boolean exist = aRepository.existsById(id);
        if(exist){
            aRepository.deleteById(id);
        }
        return exist;
    }
}

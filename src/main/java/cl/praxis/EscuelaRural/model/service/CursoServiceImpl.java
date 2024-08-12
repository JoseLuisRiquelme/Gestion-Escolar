package cl.praxis.EscuelaRural.model.service;

import cl.praxis.EscuelaRural.model.entities.Curso;
import cl.praxis.EscuelaRural.model.repositories.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CursoServiceImpl implements CursoService {

CursoRepository cRepository;

public CursoServiceImpl(CursoRepository cRepository){
    this.cRepository=cRepository;
}
    @Transactional
    @Override
    public List<Curso> findAll() {
        return cRepository.findAll();
    }
    @Transactional
    @Override
    public Curso findOne(int id) {

    return cRepository.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public boolean create(Curso c) {
    Curso result = cRepository.save(c);
        return result!=null;
    }
    @Transactional
    @Override
    public boolean update(Curso c) {
    Curso result=cRepository.save(c);
        return result!=null;
    }
    @Transactional
    @Override
    public boolean delete(int id) {
    boolean exist = cRepository.existsById(id);
    if(exist){
        cRepository.deleteById(id);
    }
        return exist;
    }
}

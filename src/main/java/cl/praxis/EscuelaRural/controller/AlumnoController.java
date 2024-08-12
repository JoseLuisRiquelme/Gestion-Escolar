package cl.praxis.EscuelaRural.controller;

import cl.praxis.EscuelaRural.model.entities.Alumno;
import cl.praxis.EscuelaRural.model.entities.Curso;
import cl.praxis.EscuelaRural.model.service.AlumnoService;
import cl.praxis.EscuelaRural.model.service.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class AlumnoController {

    private final AlumnoService aService;
    private final CursoService cService;
    public AlumnoController(AlumnoService aService, CursoService cService) {
        this.aService = aService;
        this.cService = cService;
    }
//students
    @GetMapping
    public  String studentsList(Model model){
        List<Alumno> studentsList = aService.findAll();
        model.addAttribute("students",studentsList);
        return "studentsList";
    }
    @GetMapping("/example")
    public String example(){
        return "example";
    }
    //new student form
    @GetMapping("/new")
    public String getCreate(Model model) {
        List<Curso> courses=cService.findAll();
        model.addAttribute("courses",courses);
        return "newStudent";
    }
    //new student creation
    @PostMapping("/new")
    public String postCreate(@ModelAttribute Alumno student) {
        boolean result = aService.create(student);
        return "redirect:/students";
    }
    //delete student
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        boolean result = aService.delete(id);
        return "redirect:/students";
    }
    //read student
    @GetMapping("/{id}")
    public String getUpdate(@PathVariable("id") int id, Model model) {
        Alumno studentToUpdate = aService.findOne(id);
        List<Curso> courses=cService.findAll();
        model.addAttribute("courses",courses);
        model.addAttribute("student", studentToUpdate);
        return "studentEdit";
    }
    //update student
    @PostMapping
    public  String postUpdate(@ModelAttribute Alumno student){
        boolean result  = aService.update(student);
        return "redirect:/students";
    }


}
